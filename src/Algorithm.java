import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    // Random values for now
    private static final double STABILIZATION_TIME = 5;
    private static final double EMPTY_DV_TIME = 3;
    // Time it takes to close the last AV and empty a new one
    private static final double OPEN_CLOSE_AV_TIME = 1;

    /*
     * List of tuples containing a description of the action taken and the time
     * it takes. Second element in tuple will probably be AV or DV/Inlet id
     * instead of description String later.
     */
    public static List<Tuple<Double,String>> emptySeq = new ArrayList<>();
    private static List<AV> emptiedAVs = new ArrayList<>();


    public static AV processSubtree(Vertex v) {
        AV av;

        if (v instanceof InletCluster) {
            av = ((InletCluster) v).getAV();

            if (!emptiedAVs.contains(av)) {
                emptyAV(av);
                return av;
            } else {
                return null; // No new AV is opened!
            }

        } else {
            Junction j = (Junction) v;

            boolean leftDeepest = j.getLeftDepth() > j.getRightDepth();
            Vertex firstChild = leftDeepest ? j.getLeftChild() : j.getRightChild();
            Vertex secondChild = leftDeepest ? j.getRightChild() : j.getLeftChild();

            processSubtree(firstChild);
            av = processSubtree(secondChild);

            if (v.getLengthToRoot() != 0) {
                emptySeq.add(new Tuple(v.getLengthToParent(), "Continue on AV: " + av.getId()));
                return av;
            } else {
                emptySeq.add(new Tuple<>(OPEN_CLOSE_AV_TIME, "Close AV: " + getLastAV()));
                return null; // done
            }

        }


    }

    public static void emptyAV(AV av) {
        if (emptySeq.size() > 0) {
            emptySeq.add(new Tuple<>(OPEN_CLOSE_AV_TIME, "Close AV: " + getLastAV()));
        }

        emptySeq.add(new Tuple<>(OPEN_CLOSE_AV_TIME, "Open AV: " + av.getId()));
        emptySeq.add(new Tuple<>(STABILIZATION_TIME * av.getLengthToRoot(), "Stabilize pressure in AV: " + av.getId()));

        List<InletCluster> clusters = av.getInlets();

        for (InletCluster cluster : clusters) {
            List<Inlet> inlets = cluster.getInletList();

            for (Inlet i : inlets) {
                emptySeq.add(new Tuple<>(EMPTY_DV_TIME, "Open DV: " + i.getId()));
            }

        }

        InletCluster lastCluster = clusters.get(clusters.size() - 1);
        emptySeq.add(new Tuple<>(lastCluster.getLengthToParent(), "Continue on AV: " + av.getId()));
        emptiedAVs.add(av);
    }

    public static String getLastAV() {
        String lastSeq = emptySeq.get(emptySeq.size()-1).y;
        return lastSeq.substring(lastSeq.lastIndexOf(" ")+1);
    }

    public static double getTotalTime() {
        double d = 0;

        for (Tuple<Double,String> t : emptySeq) {
            d += t.x;
        }

        return d;
    }

}
