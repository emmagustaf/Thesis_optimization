
public class Inlet extends Vertex{
    private int level;
    private AV av;

    public Inlet(int id, int lengthToRoot, int lengthToParent, Vertex parent, int level, AV av) {
        super(id, lengthToRoot, lengthToParent, parent);
        this.level = level;
        this.av = av;
    }

    public AV getAV() {
        return av;
    }

    public void setAV(AV av) {
        this.av = av;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
