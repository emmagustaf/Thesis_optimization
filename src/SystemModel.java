import java.util.List;
import java.util.Map;

public class SystemModel {

    private Junction rootNode;
    private List<AV> AVs;
    private List<Inlet> inletList;

    // The key is an AV ID and the value is the list of InletClusters that belong to the AV
    private Map<String,List<InletCluster>> avClusters;

    public SystemModel(Junction rootNode, List<AV> AVs, Map<String,List<InletCluster>> avClusters, List<Inlet> inletList) {
        this.rootNode = rootNode;
        this.AVs = AVs;
        this.avClusters = avClusters;
        this.inletList = inletList;

    }


    public Junction getRootNode() {
        return rootNode;
    }

    public void setRootNode(Junction rootNode) {
        this.rootNode = rootNode;
    }

    public List<AV> getAVs() {
        return AVs;
    }

    public void setAVs(List<AV> AVs) {
        this.AVs = AVs;
    }

    public Map<String, List<InletCluster>> getAvClusters() {
        return avClusters;
    }

    public void setAvClusters(Map<String, List<InletCluster>> avClusters) {
        this.avClusters = avClusters;
    }

    public List<Inlet> getInletList() {
        return inletList;
    }

    public void setInletList(List<Inlet> inletList) {
        this.inletList = inletList;
    }
}
