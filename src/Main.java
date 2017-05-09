import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        SystemSetup setup = new SystemSetup();
        Algorithm.processSubtree(setup.rootNode);

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
        InletCluster ic1 = new InletCluster(111,4,4, j, null, new ArrayList<>());
        InletCluster ic2 = new InletCluster(222,6,6, j, null, new ArrayList<>());

        Inlet i1 = new Inlet("1", 0, 1);
        Inlet i2 = new Inlet("2", 0, 2);
        Inlet i3 = new Inlet("3", 0, 1);
        Inlet i4 = new Inlet("4", 0, 2);

        List<Inlet> inlets1 = new ArrayList<>();
        List<Inlet> inlets2 = new ArrayList<>();
        inlets1.add(i1);
        inlets1.add(i2);
        inlets2.add(i3);
        inlets2.add(i4);

        ic1.setInletList(Arrays.asList("1","2"));
        ic2.setInletList(Arrays.asList("3","4"));

        List<InletCluster> clusters1 = new ArrayList<>();
        List<InletCluster> clusters2 = new ArrayList<>();
        clusters1.add(ic1);
        clusters2.add(ic2);

        ic1.setAV(new AV(1,4, clusters1));
        ic2.setAV(new AV(2,6, clusters2));

        j.setLeftChild(ic1);
        j.setRightChild(ic2);

        return j;
    }
}
