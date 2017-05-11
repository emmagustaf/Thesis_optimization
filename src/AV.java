import java.util.ArrayList;
import java.util.List;

public class AV {

    private int id;
    private double lengthToRoot;
    private List<InletCluster> inlets;
    private List<Junction> pathToRoot;

    public AV(int id, double lengthToRoot, List<InletCluster> inlets){
        this.id = id;
        this.lengthToRoot = lengthToRoot;
        this.inlets = inlets;
        this.pathToRoot = new ArrayList<>();
    }


    public List<InletCluster> getInlets() {
        return inlets;
    }

    public void setInlets(List<InletCluster> inlets) {
        this.inlets = inlets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLengthToRoot() {
        return lengthToRoot;
    }

    public void setLengthToRoot(int lengthToRoot) {
        this.lengthToRoot = lengthToRoot;
    }

    public List<Junction> getPathToRoot() {
        return pathToRoot;
    }

    public void setPathToRoot(List<Junction> pathToRoot) {
        this.pathToRoot = pathToRoot;
    }
}