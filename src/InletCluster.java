import java.util.List;

public class InletCluster extends Vertex{

    private List<Inlet> inletList;
    private AV av;
    private double ind;

    public InletCluster(int id, double lengthToRoot, double lengthToParent, Vertex parent, AV av, List<Inlet> inletList) {
        super(id, lengthToRoot, lengthToParent, parent);
        this.av = av;
        this.inletList = inletList;
        this.ind = 0;
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

    public double getInd() {
        return ind;
    }

    public void setInd(double ind) {
        this.ind = ind;
    }
}
