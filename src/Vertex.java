
public abstract class Vertex {

    private Vertex parent;
    private int id;
    private int lengthToRoot, lengthToParent;

    public Vertex(int id, int lengthToRoot, int lengthToParent, Vertex parent) {
        this.id = id;
        this.lengthToRoot = lengthToRoot;
        this.lengthToParent = lengthToParent;
        this.parent = parent;
    }

    /*public int getChildCount() {
        if (left != null && right != null) {
            return 2;
        }else if (left != null || right != null) {
            return 1;
        }else {
            return 0;
        }
    }*/

    public Vertex getParent() {
        return this.parent;
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

    public int getLengthToParent() {
        return lengthToParent;
    }

    public void setLengthToParent(int lengthToParent) {
        this.lengthToParent = lengthToParent;
    }

}