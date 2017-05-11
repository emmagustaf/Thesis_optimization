import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm {

    // Random values for now
    private static final double STARTUP_TIME = 120;
    private static final double STABILIZATION_TIME = 0.1;
    private static final double SAFETY_MARGIN = 20;

    private static final double EMPTY_DV_TIME = 14;
    // Time it takes to close the last AV and empty a new one
    private static final double OPEN_CLOSE_AV_TIME = 4;
    private static final double SPEED = 10; // m/s

    /*
     * List of tuples containing a description of the action taken and the time
     * it takes. Second element in tuple will probably be AV or DV/Inlet id
     * instead of description String later.
     */
    public static List<Tuple<Double,String>> emptySeq = new ArrayList<>();
    public static List<AV> emptiedAVs = new ArrayList<>();
    public static AV lastAV = null;


    public static AV processSubtree(Vertex v, int fraction) {

        if (v instanceof InletCluster) {
            AV av = SystemSetup.inletClusters.get(v.getId()).getAV();//((InletCluster) v).getAV();

            if (!emptiedAVs.contains(av)) {
                emptyAV(av, fraction);
                return av;
            } else {
                return null; // No new AV is opened!
            }

        } else {
            //Junction j = (Junction) v;

            boolean leftDeepest = SystemSetup.junctions.get(v.getId()).getLeftDepth() >  SystemSetup.junctions.get(v.getId()).getRightDepth();
            Vertex firstChild = leftDeepest ?  SystemSetup.junctions.get(v.getId()).getLeftChild() :  SystemSetup.junctions.get(v.getId()).getRightChild();
            Vertex secondChild = leftDeepest ?  SystemSetup.junctions.get(v.getId()).getRightChild() :  SystemSetup.junctions.get(v.getId()).getLeftChild();


            // Start with the AV furthest away from the root node
            AV av1 = processSubtree(firstChild, fraction);
            AV av2 = processSubtree(secondChild, fraction);

            // If no new AV has been opened in the subtrees, return null
            if (av2 == null && av1 == null) {
                return null;

            } else if ( SystemSetup.junctions.get(v.getId()).getLengthToRoot() != 0) {
                AV av = av2 == null ? av1 : av2;
                emptySeq.add(new Tuple( SystemSetup.junctions.get(v.getId()).getLengthToParent()/SPEED, "Continue on AV: " + av.getId()));
                emptySeq.add(new Tuple<>(SAFETY_MARGIN, "Safety margin for " + av.getId()));
                return av;
            } else  { // Reached the root
                emptySeq.add(new Tuple<>(OPEN_CLOSE_AV_TIME, "Close AV: " + getLastAV()));
                emptySeq.add(new Tuple<>(STARTUP_TIME, "Turning system off"));
                return null; // done
            }

        }
    }

    private static void emptyAV(AV av, int fraction) {
        double stabilizationTime;

        if (emptiedAVs.size() > 0) {
            emptySeq.add(new Tuple<>(OPEN_CLOSE_AV_TIME, "Close AV: " + lastAV.getId()));
            stabilizationTime = calculateStabilizationTime(av.getId(), SystemSetup.avs.get(lastAV.getId()).getPathToRoot());
        } else {
            emptySeq.add(new Tuple<>(STARTUP_TIME, "Starting fans"));
            stabilizationTime = SystemSetup.avs.get(av.getId()).getLengthToRoot() * STABILIZATION_TIME;
        }

        emptySeq.add(new Tuple<>(OPEN_CLOSE_AV_TIME, "Open AV: " + av.getId()));
        emptySeq.add(new Tuple<>(stabilizationTime, "Stabilize pressure in AV: " + av.getId())); //STABILIZATION_TIME * av.getLengthToRoot()

        List<InletCluster> clusters = SystemSetup.avs.get(av.getId()).getInlets();

        for (InletCluster cluster : SystemSetup.avs.get(av.getId()).getInlets()) {
            List<Inlet> inlets = cluster.getInletList();

            for (Inlet i : inlets) {
                if (SystemSetup.inletsMap.get(i.getId()).getFraction() == fraction) {
                    emptySeq.add(new Tuple<>(EMPTY_DV_TIME, "Open DV: " + i.getId()));
                    emptySeq.add(new Tuple<>(SAFETY_MARGIN, "Safety margin for " + av.getId()));
                    Main.nbrOfInlets++;
                    SystemSetup.levelUpdate(i.getId(), 0);
                }
            }
            emptySeq.add(new Tuple<>(SystemSetup.inletClusters.get(cluster.getId()).getLengthToParent()/SPEED, "Transport cluster: " + cluster.getId()));

        }

        InletCluster lastCluster = clusters.get(clusters.size() - 1);
        emptySeq.add(new Tuple<>(lastCluster.getLengthToParent()/SPEED, "Continue on AV: " + av.getId())); //(55.4+7.4+4+3)*0.05*10
        emptySeq.add(new Tuple<>(SAFETY_MARGIN, "Safety margin for " + av.getId()));
        emptiedAVs.add(SystemSetup.avs.get(av.getId()));

        lastAV = av;
    }


    public static Vertex buildTree(Vertex v, int fraction) {
        if (v instanceof InletCluster) {
            // If any inlet in the cluster has a level, the cluster is added to the tree
            return SystemSetup.anyLevel(SystemSetup.inletClusters.get(v.getId()).getAV(), fraction) ? v : null;

        } else {
            Vertex v1 = buildTree(SystemSetup.junctions.get(v.getId()).getRightChild(), fraction);
            Vertex v2 = buildTree(SystemSetup.junctions.get(v.getId()).getLeftChild(), fraction);

            if (v1 == null && v2 == null) {
                return null;
            } else if (v2 == null) { // If the left subtree should not be included, remove vertex and point right child to parent.
                if (SystemSetup.junctions.get(v.getId()).getLengthToRoot() == 0) {
                    return SystemSetup.junctions.get(v.getId()).getRightChild();
                }
                if (SystemSetup.junctions.get(SystemSetup.junctions.get(v.getId()).getParent().getId()).getLeftChild().getId() == v.getId()) {
                    SystemSetup.updateRelation(SystemSetup.junctions.get(v.getId()).getParent(), SystemSetup.junctions.get(v.getId()).getRightChild(), null);
                } else {
                    SystemSetup.updateRelation(SystemSetup.junctions.get(v.getId()).getParent(), null, SystemSetup.junctions.get(v.getId()).getRightChild());
                }

                SystemSetup.setJunctionDepth(SystemSetup.junctions.get(v.getId()).getParent());

            } else if (v1 == null) { // If the right subtree should not be included, remove vertex and point left child to parent.
                if (SystemSetup.junctions.get(v.getId()).getLengthToRoot() == 0) {
                    return SystemSetup.junctions.get(v.getId()).getLeftChild();
                }
                if (SystemSetup.junctions.get(SystemSetup.junctions.get(v.getId()).getParent().getId()).getLeftChild().getId() == v.getId()) {
                    SystemSetup.updateRelation(SystemSetup.junctions.get(v.getId()).getParent(), SystemSetup.junctions.get(v.getId()).getLeftChild(), null);
                } else {
                    SystemSetup.updateRelation(SystemSetup.junctions.get(v.getId()).getParent(), null, SystemSetup.junctions.get(v.getId()).getLeftChild());
                }

                SystemSetup.setJunctionDepth(SystemSetup.junctions.get(v.getId()).getParent());

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

    private static double calculateStabilizationTime(int newAV, List<Junction> path) {
        List<InletCluster> clusters = SystemSetup.avs.get(newAV).getInlets();
        InletCluster cluster = clusters.get(clusters.size()-1);
        Junction nextNode = (Junction) SystemSetup.inletClusters.get(cluster.getId()).getParent();

        double stabilizeLength = cluster.getLengthToParent();

        while (!path.contains(SystemSetup.junctions.get(nextNode.getId()))) {
            nextNode = SystemSetup.junctions.get(nextNode.getParent().getId());
            stabilizeLength += nextNode.getLengthToParent();
        }

        return stabilizeLength * STABILIZATION_TIME;
    }

}
