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

    public static void main(String[] args) {
        SystemSetup setup = new SystemSetup();
        int fraction = 3;

        testAlgorithm(setup, fraction);

        String filePath = "/Users/elin/Documents/Programmering/Exjobb/disposals_jan2017.csv";
        String filePath2 = "/Users/elin/Documents/Programmering/Exjobb/disposals_2016.csv";
        //String filePath = "/Users/emma/Chalmers/exjobb/Prototype/thesis_opt/disposals_jan2017.csv";

        Map<String,List<Disposal>> disposalsJan2017 = ParseData.parseCSVFile(filePath);
        Map<String,List<Disposal>> disposals2016 = ParseData.parseCSVFile(filePath2);
        allHistory = disposals2016;

        Statistics.sortDays(allHistory);

        //simulate(disposalsJan2017, setup);

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
     * Kör datan i disposals som "realtiddata", anropa updateLevel typ varje dag eller liknande och skicka med den datan som är "ny" sedan senaste anropet.
     */
    private static void simulate(Map<String,List<Disposal>> disposals, SystemSetup setup) {
        // Set the time between checks to 1 day
        //LocalTime time = LocalTime.of(24, 0);
        int minutes = 30;
        // Default starting time is 2017-01-01 13:00
        LocalDateTime startTime = LocalDateTime.of(2017,1,1,13,0,0);
        LocalDateTime endTime = startTime;
        Map<String,List<Disposal>> temp = disposals;

        while (endTime.getMonth().equals(Month.JANUARY)) {

            output.add("");
            output.add("Update levels until date: " + endTime);
            //System.out.println("Update levels until date: " + endTime);
            Map<String,List<Disposal>> nextUpdate = getNextUpdate(temp, endTime);
            for (String inletID : nextUpdate.keySet()) {

                List<Disposal> newList = temp.get(inletID);
                newList.removeAll(nextUpdate.get(inletID));
                temp.put(inletID, newList);

            }
            
            LevelHandler.updateLevels(nextUpdate);

            endTime = endTime.plusMinutes(minutes);

            int fraction = 1;
            Vertex startNode = Algorithm.buildTree(setup.rootNode, fraction);

            if (startNode != null) {
                Algorithm.processSubtree(startNode, fraction);//SystemSetup.inletClusters.get(35));//
            }

            for (Tuple<Double, String> t : Algorithm.emptySeq) {
                output.add(t.y + " for " + t.x + " s.");
            }

            output.add("Total time: " + Algorithm.getTotalTime());
            output.add("");
            output.add("");
            totalTime += Algorithm.getTotalTime();

            setup.refreshSystem();
        }

        output.add("TOTALTID: " + totalTime);

        try {
            Files.write(Paths.get("/Users/elin/Documents/Programmering/Exjobb/output.txt"), output);
        } catch (IOException e) {
            e.printStackTrace();
        }


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

        Algorithm.processSubtree(setup.rootNode, fraction);

        for (Tuple<Double, String> t : Algorithm.emptySeq) {
            System.out.println(t.y + " for " + t.x + " s.");
        }

        System.out.println("Total time: " + Algorithm.getTotalTime());
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
