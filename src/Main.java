import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.*;

public class Main {

    public static List<String> output = new ArrayList<>();
    private static Map<String,List<Disposal>> allHistory;
    public static double totalTime = 0;
    public static int nbrOfInlets = 0;
    public static List<String> overLimit = new ArrayList<>();
    public static int minutes;

    public static void main(String[] args) {
        SystemSetup setup = new SystemSetup();
        int fraction = 1;

        //testAlgorithm(setup, fraction);

        String filePath = "/Users/elin/Documents/Programmering/Exjobb/disposals_jan2017.csv";
        String filePath2 = "/Users/elin/Documents/Programmering/Exjobb/disposals_2016.csv";
        //String filePath = "/Users/emma/Chalmers/exjobb/Prototype/thesis_opt/disposals_jan2017.csv";

        Map<String,List<Disposal>> disposalsJan2017 = ParseData.parseCSVFile(filePath);
        Map<String,List<Disposal>> disposals2016 = ParseData.parseCSVFile(filePath2);
        allHistory = disposals2016;

        Statistics.sortDays(allHistory);

        //worstCaseScenario(disposalsJan2017, setup);
        simulate(disposalsJan2017, setup);

        /*System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(Statistics.getDisposalStatsByTime("6:3", Arrays.asList(DayOfWeek.TUESDAY), LocalTime.of(5,0,0), LocalTime.of(23,59,59)));

        System.out.println();
        System.out.println("Monday-disposals amount: " + setup.inletsMap.get("6:3").getDisposals().get(DayOfWeek.TUESDAY).size());*/

        /*System.out.println("Disposals for inlet 3:1:");
        for (Disposal d : disposals.get("3:1")) {
            System.out.println("Disposal: " + d.getLogId() + ", Date: " + d.getLogDate());
        }*/

    }

    /*
     * Emptying all inlets at pre-scheduled times
     * TODO add emptying of triggered
     */
    private static void worstCaseScenario(Map<String,List<Disposal>> disposals, SystemSetup setup) {
        minutes = 60;

        LocalDateTime endTime = LocalDateTime.of(2017,1,1,13,0,0);

        while (endTime.getMonth().equals(Month.JANUARY)) {

            output.add("");
            output.add("Update levels until date: " + endTime);
            Map<String,List<Disposal>> nextUpdate = getNextUpdate(disposals, endTime);

            for (String inletID : nextUpdate.keySet()) {
                List<Disposal> newList = disposals.get(inletID);
                newList.removeAll(nextUpdate.get(inletID));
                disposals.put(inletID, newList);

            }

            List<Integer> fractionsToEmpty = LevelHandler.updateLevels(nextUpdate);
            endTime = endTime.plusMinutes(minutes);


            Algorithm.emptySeq.add(new Tuple<>(Algorithm.STARTUP_TIME, "Starting fans"));
            Algorithm.processSubtree(SystemSetup.rootNode, 1);     // Empty residual every hour
            output.add("Total time: " + Algorithm.getTotalTime());
            output.add("");
            output.add("");
            totalTime += Algorithm.getTotalTime();
            setup.refreshSystem();

            if (endTime.getHour() % 2 == 0) {   // Empty plastic every 2 hours
                Algorithm.processSubtree(SystemSetup.rootNode, 2);
                output.add("Total time: " + Algorithm.getTotalTime());
                output.add("");
                output.add("");
                totalTime += Algorithm.getTotalTime();
                setup.refreshSystem();
            }

            if (endTime.getHour() % 3 == 0) {   // Empty paper every 3 hours
                Algorithm.processSubtree(SystemSetup.rootNode, 3);
                output.add("Total time: " + Algorithm.getTotalTime());
                output.add("");
                output.add("");
                totalTime += Algorithm.getTotalTime();
                setup.refreshSystem();
            }

            /*for (int i = 0; i < 3; i++) {
                Algorithm.processSubtree(setup.rootNode, i + 1);

                output.add("Total time: " + Algorithm.getTotalTime());
                output.add("");
                output.add("");

                totalTime += Algorithm.getTotalTime();
                setup.refreshSystem();
            }*/

        }

        writeFile();
    }

    /*
     * Simulates the emptying of the system for all the disposals made in january.
     */
    private static void simulate(Map<String,List<Disposal>> disposals, SystemSetup setup) {
        // Set the time between checks to 1 day
        //LocalTime time = LocalTime.of(24, 0);
        minutes = 120;
        // Default starting time is 2017-01-01 13:00
        LocalDateTime endTime = LocalDateTime.of(2017,1,1,13,0,0);
        Map<String,List<Disposal>> tempDisposals = disposals;

        while (endTime.getMonth().equals(Month.JANUARY)) {
            long emptyingTime = 0;

            output.add("");
            output.add("Update levels until date: " + endTime);
            //System.out.println("Update levels until date: " + endTime);
            Map<String,List<Disposal>> nextUpdate = getNextUpdate(tempDisposals, endTime);

            for (String inletID : nextUpdate.keySet()) {
                List<Disposal> newList = tempDisposals.get(inletID);
                newList.removeAll(nextUpdate.get(inletID));
                tempDisposals.put(inletID, newList);

            }

            List<Integer> fractionsToEmpty = LevelHandler.updateLevels(nextUpdate);

            for (int fraction : fractionsToEmpty) {
                Vertex startNode = Algorithm.buildTree(SystemSetup.rootNode, fraction);

                if (startNode != null) {
                    Algorithm.emptySeq.add(new Tuple<>(Algorithm.STARTUP_TIME, "Starting fans"));
                    Algorithm.processSubtree(startNode, fraction);//SystemSetup.inletClusters.get(35));//

                    tempDisposals = updateDisposalsAfterEmptying(tempDisposals, endTime);
                    emptyingTime += Algorithm.getTotalTime();
                }

                printAlgorithm();
                totalTime += Algorithm.getTotalTime();
                setup.refreshSystem();
            }

            LocalDateTime timeByInterval = endTime.plusMinutes(minutes);
            LocalDateTime timeByEmptying = endTime.plusSeconds(emptyingTime);

            endTime = timeByInterval.isAfter(timeByEmptying) ? timeByInterval : timeByEmptying;

        }

        writeFile();

    }

    private static Map<String,List<Disposal>> getNextUpdate(Map<String,List<Disposal>> futureDisposals, LocalDateTime endTime) {
        Map<String,List<Disposal>> nextUpdate = new HashMap<>();

        for (String inletID : futureDisposals.keySet()) {
            List<Disposal> newList = new ArrayList<>();

            for (Disposal d : futureDisposals.get(inletID)) {
                if (d.getLogDate().isBefore(endTime)) {
                    newList.add(d);
                } else {
                    break;
                }
            }

            nextUpdate.put(inletID,newList);
        }

        return nextUpdate;
    }

    private static Map<String,List<Disposal>> updateDisposalsAfterEmptying(Map<String,List<Disposal>> disposals, LocalDateTime startTime) {
        Map<String,List<Disposal>> newDisposals = new HashMap<>();
        long secondsUntilEmptied = 0;
        boolean wasEmptied;

        for (String inletID : disposals.keySet()) {
            wasEmptied = false;
            List<Disposal> updatedDisposalList = new ArrayList<>();

            for (Tuple<Double,String> lineInSeq : Algorithm.emptySeq) {
                secondsUntilEmptied += lineInSeq.x;

                if (lineInSeq.y.equals("Open DV: " + inletID)) {
                    wasEmptied = true;
                    break;
                }
            }

            List<Disposal> tempList = disposals.get(inletID);

            if (wasEmptied) {
                List<Disposal> temp = disposals.get(inletID);
                for (Disposal d : temp) {
                    if (d.getLogDate().isBefore(startTime.plusSeconds(secondsUntilEmptied))) {
                        updatedDisposalList.add(d);
                    } else {
                        break;
                    }
                }


                tempList.removeAll(updatedDisposalList);
            }

            newDisposals.put(inletID, tempList);
        }

        return newDisposals;
    }

    private static void printAlgorithm() {
        for (Tuple<Double, String> t : Algorithm.emptySeq) {
            output.add(t.y + " for " + t.x + " s.");
        }

        output.add("Total time: " + Algorithm.getTotalTime());
        output.add("");
        output.add("");
    }

    private static void writeFile() {
        output.add("TOTAL TIME: " + totalTime);
        output.add("Their \"rest\" time: " + 262509);
        output.add("Their total time: " + (262509.0 + 79369.0 +	97130.0));

        String overfull = "Anything over limit, " + overLimit.size() + ": ";
        for (String s : overLimit) {
            overfull += s + ", ";
        }
        output.add(overfull);//overLimit.get(0) + " and " + overLimit.get(1));

        output.add("");
        output.add("Number of inlets emptied: " + nbrOfInlets);
        output.add("DVs per minute: " + (nbrOfInlets/(totalTime/60)));

        output.add("");
        output.add("Their \"rest\" number of inlets emptied: " + 3305);
        output.add("Their number of inlets emptied: " + (3305 +1191.0 + 1003.0));
        output.add("Their \"rest\" DVs per minute: " + (3305 / (262509/60)));

        try {
            Files.write(Paths.get("/Users/elin/Documents/Programmering/Exjobb/output.txt"), output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testAlgorithm(SystemSetup setup, int fraction) {
        //setup.levelUpdate("18:1", 0.8);
        //setup.levelUpdate("25:1", 0.8);

        /*Vertex startNode = Algorithm.buildTree(setup.rootNode, fraction);

        if (startNode != null) {
            Algorithm.processSubtree(startNode, fraction);//SystemSetup.inletClusters.get(35));//
        }

        for (Tuple<Double, String> t : Algorithm.emptySeq) {
            System.out.println(t.y + " for " + t.x + " s.");
        }

        System.out.println("Total time: " + Algorithm.getTotalTime());
        System.out.println();
        System.out.println();
        System.out.println();

        setup.refreshSystem();*/

        Algorithm.emptySeq.add(new Tuple<>(Algorithm.STARTUP_TIME, "Starting fans"));
        Algorithm.processSubtree(setup.rootNode, fraction);

        for (Tuple<Double, String> t : Algorithm.emptySeq) {
            System.out.println(t.y + " for " + t.x + " s.");
        }

        System.out.println("Total time: " + Algorithm.getTotalTime());
        System.out.println("Number of inlets emptied: " + nbrOfInlets);
        System.out.println("DVs per minute: " + (nbrOfInlets/(Algorithm.getTotalTime()/60)));
    }

    /*
     * A setup of a mini-tree to use for testing until SystemSetup is done
     */
    public static Vertex miniSetup() {
        Junction j = new Junction(1, 0, 0, null, null, null, 4, 6);
        Junction first = new Junction(2,1,1,j,null,null,3,0);

        InletCluster ic1 = new InletCluster(111,4,3, first, null, new ArrayList<>());
        InletCluster ic2 = new InletCluster(222,6,6, j, null, new ArrayList<>());
        InletCluster ic3 = new InletCluster(333,5,4, first, null, new ArrayList<>());


        Inlet i1 = new Inlet("1", 2, 1);
        Inlet i2 = new Inlet("2", 3, 2);
        Inlet i3 = new Inlet("3", 0, 1);
        Inlet i4 = new Inlet("4", 1, 2);
        Inlet i5 = new Inlet("5", 0, 2);

        List<Inlet> inlets1 = Arrays.asList(i1, i2);
        List<Inlet> inlets2 = Arrays.asList(i3, i4);
        List<Inlet> inlets3 = Arrays.asList(i5);

        ic1.setInletList(inlets1);
        ic2.setInletList(inlets2);
        ic3.setInletList(inlets3);

       // ic1.setInletList(Arrays.asList("1","2"));
       // ic2.setInletList(Arrays.asList("3","4"));

        List<InletCluster> clusters1 = new ArrayList<>();
        List<InletCluster> clusters2 = new ArrayList<>();
        List<InletCluster> clusters3 = new ArrayList<>();
        clusters1.add(ic1);
        clusters2.add(ic2);
        clusters3.add(ic3);

        ic1.setAV(new AV(1,4, clusters1));
        ic2.setAV(new AV(2,6, clusters2));
        ic3.setAV(new AV(3,5, clusters3));

        j.setLeftChild(first);
        j.setRightChild(ic2);

        first.setLeftChild(ic1);
        first.setRightChild(ic3);

        Map<Integer,Junction> junctions = new HashMap<>();
        junctions.put(1,j);
        junctions.put(2,first);

        Map<Integer,InletCluster> inletClusters = new HashMap<>();
        inletClusters.put(111,ic1);
        inletClusters.put(222,ic2);
        inletClusters.put(333,ic3);


//        System.out.println("RootChild: " + j.getLeftChild().getId() + " leftchilds parent: " + j.getLeftChild().getParent().getId() );

        //junctions.get(1).setLeftChild(inletClusters.get(111));

        //inletClusters.get(111).setParent(junctions.get(1));

  //      System.out.println("RootChild: " + j.getLeftChild().getId() + " leftchilds parent: " + j.getLeftChild().getParent().getId() );

        return j;
    }
}
