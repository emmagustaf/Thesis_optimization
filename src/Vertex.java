
public abstract class Vertex {

    private Vertex parent;
    private int id;
    private double lengthToRoot, lengthToParent;

    public Vertex(int id, double lengthToRoot, double lengthToParent, Vertex parent) {
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

    public double getLengthToRoot() {
        return lengthToRoot;
    }

    public void setLengthToRoot(double lengthToRoot) {
        this.lengthToRoot = lengthToRoot;
    }

    public double getLengthToParent() {
        return lengthToParent;
    }

    public void setLengthToParent(double lengthToParent) {
        this.lengthToParent = lengthToParent;
    }

}