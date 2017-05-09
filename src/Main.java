import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        SystemSetup setup = new SystemSetup();

        SystemSetup.levelUpdate("18:1", 0.8);
        SystemSetup.levelUpdate("25:1", 0.8);

        Algorithm.processSubtree(Algorithm.buildTree(SystemSetup.rootNode));//SystemSetup.inletClusters.get(35));//

        for (Tuple<Double, String> t : Algorithm.emptySeq) {
            System.out.println(t.y + " for " + t.x + " time.");
        }

        System.out.println("Total time: " + Algorithm.getTotalTime());

        Map<String,List<Disposal>> disposals = ParseData.parseCSVFile();

        /*System.out.println("Disposals for inlet 3:1:");
        for (Disposal d : disposals.get("3:1")) {
            System.out.println("Disposal: " + d.getLogId() + ", Date: " + d.getLogDate());
        }*/

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
