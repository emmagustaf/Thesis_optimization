import java.util.ArrayList;
import java.util.List;

public class AV {

    private int id;
    private int lengthToRoot;
    private List<InletCluster> inlets;

    public AV(int id, int lengthToRoot, List<InletCluster> inlets){
        this.id = id;
        this.lengthToRoot = lengthToRoot;
        this.inlets = inlets;
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

    public int getLengthToRoot() {
        return lengthToRoot;
    }

    public void setLengthToRoot(int lengthToRoot) {
        this.lengthToRoot = lengthToRoot;
    }
}