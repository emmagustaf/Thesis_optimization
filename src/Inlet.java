
public class Inlet extends Vertex{
    private int level;
    private String av;

    public Inlet(int id, int lengthToRoot, int lengthToParent, Vertex parent, int level, String av) {
        super(id, lengthToRoot, lengthToParent, parent);
        this.level = level;
        this.av = av;
    }

}
