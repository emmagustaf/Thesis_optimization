import java.util.List;

public class InletCluster extends Vertex{

    private List<Inlet> inletList;
    private AV av;

    public InletCluster(int id, int lengthToRoot, int lengthToParent, Vertex parent, AV av, List<Inlet> inletList) {
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

    public List<Inlet> getInletList() {
        return inletList;
    }

    public void setInletList(List<Inlet> inletList) {
        this.inletList = inletList;
    }
}
