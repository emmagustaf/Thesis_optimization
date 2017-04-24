
public class Junction extends Vertex{

    private Vertex leftChild, rightChild;
    private int leftDepth, rightDepth;

    public Junction(int id, int lengthToRoot, int lengthToParent, Vertex parent, Vertex leftChild, Vertex rightChild
            , int leftDepth, int rightDepth) {
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

    public int getLeftDepth() {
        return leftDepth;
    }

    public void setLeftDepth(int leftDepth) {
        this.leftDepth = leftDepth;
    }

    public int getRightDepth() {
        return rightDepth;
    }

    public void setRightDepth(int rightDepth) {
        this.rightDepth = rightDepth;
    }
}
