
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

}
