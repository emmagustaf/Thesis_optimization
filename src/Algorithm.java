import java.util.ArrayList;
import java.util.List;

public class Algorithm {

    // Random values for now
    private static final double STABILIZATION_TIME = 5;
    private static final double SAFETY_MARGIN = 5;

    private static final double EMPTY_DV_TIME = 14;
    // Time it takes to close the last AV and empty a new one
    private static final double OPEN_CLOSE_AV_TIME = 2;
    private static final double SPEED = 10; // m/s

    /*
     * List of tuples containing a description of the action taken and the time
     * it takes. Second element in tuple will probably be AV or DV/Inlet id
     * instead of description String later.
     */
    public static List<Tuple<Double,String>> emptySeq = new ArrayList<>();
    private static List<AV> emptiedAVs = new ArrayList<>();


    public static AV processSubtree(Vertex v) {

        if (v instanceof InletCluster) {
            AV av = ((InletCluster) v).getAV();

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

            // Start with the AV furthest away from the root node
            AV av1 = processSubtree(firstChild);
            AV av2 = processSubtree(secondChild);

            // If no new AV has been opened in the subtrees, return null
            if (av2 == null && av1 == null) {
                return null;

            } else if (v.getLengthToRoot() != 0) {
                AV av = av2 == null ? av1 : av2;
                emptySeq.add(new Tuple(v.getLengthToParent()/SPEED, "Continue on AV: " + av.getId()));

                return av;
            } else { // Reached the root
                emptySeq.add(new Tuple<>(OPEN_CLOSE_AV_TIME, "Close AV: " + getLastAV()));
                return null; // done
            }

        }
    }

    private static void emptyAV(AV av) {
        if (emptySeq.size() > 0) {
            emptySeq.add(new Tuple<>(OPEN_CLOSE_AV_TIME, "Close AV: " + getLastAV()));
        }

        emptySeq.add(new Tuple<>(OPEN_CLOSE_AV_TIME, "Open AV: " + av.getId()));
        //emptySeq.add(new Tuple<>(STABILIZATION_TIME * av.getLengthToRoot(), "Stabilize pressure in AV: " + av.getId()));

        List<InletCluster> clusters = av.getInlets();

        for (InletCluster cluster : clusters) {
            List<Inlet> inlets = cluster.getInletList();

            for (Inlet i : inlets) {
                emptySeq.add(new Tuple<>(EMPTY_DV_TIME, "Open DV: " + i.getId()));
            }

        }

        InletCluster lastCluster = clusters.get(clusters.size() - 1);
        emptySeq.add(new Tuple<>(lastCluster.getLengthToParent()/SPEED, "Continue on AV: " + av.getId()));
        emptiedAVs.add(av);
    }

    /*public static Vertex buildTree(Vertex v) {
        if (v instanceof InletCluster) {
            InletCluster ic = (InletCluster) v;

            // If any inlet in the cluster has a level, the cluster is added to the tree
            return anyLevel(ic) ? ic : null;

        } else {
            Junction j = (Junction) v;
            Vertex v1 = buildTree(j.getRightChild());
            Vertex v2 = buildTree(j.getLeftChild());

            if (v1 == null && v2 == null) {
                return null;
            } else if (v2 == null) {
                Junction parent = (Junction) j.getParent();
                if (parent.getLeftChild().getId() == j.getId()) {
                    parent.setLeftChild(j.getRightChild());
                }
            }
        }

        return v;
    }

    private static boolean anyLevel(InletCluster cluster) {
        for (Inlet i : cluster.getInletList()) {
            if (i.getLevel() > 0) {
                return true;
            }
        }

        return false;
    }*/

    public static String getLastAV() {
        String lastSeq = emptySeq.get(emptySeq.size() - 1).y;
        return lastSeq.substring(lastSeq.lastIndexOf(" ") + 1);
    }

    public static double getTotalTime() {
        double d = 0;

        for (Tuple<Double,String> t : emptySeq) {
            d += t.x;
        }

        return d;
    }

}
