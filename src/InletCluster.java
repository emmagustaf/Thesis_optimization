import java.util.List;

public class InletCluster extends Vertex{

    private List<String> inletList;
    private AV av;

    public InletCluster(int id, double lengthToRoot, double lengthToParent, Vertex parent, AV av, List<String> inletList) {
        super(id, lengthToRoot, lengthToParent, parent);
        this.av = av;
        this.inletList = inletList;
    }

    public AV getAV() {
        return av;
    }

    public void setAV(AV av) {
        this.av = av;
    }

    public List<String> getInletList() {
        return inletList;
    }

    public void setInletList(List<String> inletList) {
        this.inletList = inletList;
    }
}
