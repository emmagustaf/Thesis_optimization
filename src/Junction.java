
public class Junction extends Vertex{

    private Vertex leftChild, rightChild;
    private double leftDepth, rightDepth;

    public Junction(int id, double lengthToRoot, double lengthToParent, Vertex parent, Vertex leftChild, Vertex rightChild
            , double leftDepth, double rightDepth) {
        super(id, lengthToRoot, lengthToParent, parent);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.leftDepth = leftDepth;
        this.rightDepth = rightDepth;
    }

    public Vertex getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Vertex leftChild) {
        this.leftChild = leftChild;
    }

    public Vertex getRightChild() {
        return rightChild;
    }

    public void setRightChild(Vertex rightChild) {
        this.rightChild = rightChild;
    }

    public double getLeftDepth() {
        return leftDepth;
    }

    public void setLeftDepth(double leftDepth) {
        this.leftDepth = leftDepth;
    }

    public double getRightDepth() {
        return rightDepth;
    }

    public void setRightDepth(double rightDepth) {
        this.rightDepth = rightDepth;
    }
}
