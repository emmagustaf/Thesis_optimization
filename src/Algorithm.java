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

        if (v == null) { // TODO No tree to empty (Should be done before calling method)
            return null;
        } else if (v instanceof InletCluster) {
            AV av = ((InletCluster) v).getAV();

            if (!emptiedAVs.contains(av)) {
                emptyAV(av);
                return av;
            } else {
                return null; // No new AV is opened!
            }

        } else {
            System.out.println(v);
            //Junction j = (Junction) v;

            boolean leftDeepest = ((Junction) v).getLeftDepth() > ((Junction) v).getRightDepth();
            Vertex firstChild = leftDeepest ? ((Junction) v).getLeftChild() : ((Junction) v).getRightChild();
            Vertex secondChild = leftDeepest ? ((Junction) v).getRightChild() : ((Junction) v).getLeftChild();

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
            } else  { // Reached the root
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
        emptySeq.add(new Tuple<>(lastCluster.getLengthToParent()/SPEED, "Continue on AV: " + av.getId())); //(55.4+7.4+4+3)*0.05*10
        emptiedAVs.add(av);
    }

    public static Vertex buildTree(Vertex v) {
        if (v instanceof InletCluster) {
            // If any inlet in the cluster has a level, the cluster is added to the tree
            return SystemSetup.anyLevel(((InletCluster) v).getAV()) ? v : null;

        } else {
            Vertex v1 = buildTree(((Junction) v).getRightChild());
            Vertex v2 = buildTree(((Junction) v).getLeftChild());

            if (v1 == null && v2 == null) {
                return null;
            } else if (v2 == null) { // If the left subtree should not be included, remove vertex and point right child to parent.
                if (v.getLengthToRoot() == 0) {
                    return ((Junction) v).getRightChild();
                }
                if (((Junction)v.getParent()).getLeftChild().getId() == v.getId()) {
                    SystemSetup.updateRelation(v.getParent(), ((Junction) v).getRightChild(), null);
                } else {
                    SystemSetup.updateRelation(v.getParent(), null, ((Junction) v).getRightChild());
                }

                SystemSetup.setJunctionDepth(v.getParent());

            } else if (v1 == null) { // If the right subtree should not be included, remove vertex and point left child to parent.
                if (v.getLengthToRoot() == 0) {
                    return ((Junction) v).getLeftChild();
                }
                if (((Junction)v.getParent()).getLeftChild().getId() == v.getId()) {
                    SystemSetup.updateRelation(v.getParent(), ((Junction) v).getLeftChild(), null);
                } else {
                    SystemSetup.updateRelation(v.getParent(), null, ((Junction) v).getLeftChild());
                }

                SystemSetup.setJunctionDepth(v.getParent());

            }
        }

        return v;
    }

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
