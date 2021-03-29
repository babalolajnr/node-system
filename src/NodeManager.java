import java.util.LinkedList;

public class NodeManager {
    private LinkedList<Node> availableNodes;

    public NodeManager() {
        availableNodes = new LinkedList<Node>();
    }

    public boolean registerNewNode(String nodeIPAddress, int nodePortNumber, String nodeID, int maxJobs) {
        return registerNewNode(new Node(nodeIPAddress, nodeID, nodePortNumber, maxJobs));
    }

    public boolean registerNewNode(Node newNode) {
        if (newNode != null) {
            availableNodes.add(newNode);
            return true;
        }
        return false;
    }

    public boolean doJob(String jobMessage, String nodeID) {
        Node node = findNode(nodeID);
        if (node != null) {
            return node.sendMessage(jobMessage);
        }
        return false;
    }

    public boolean removeNode() {
        return true;
    }

    public Node findNode(String nodeID) {
        for (int i = 0; i < availableNodes.size(); i++) {
            Node theNode = (Node) availableNodes.get(i);
            if (theNode.getNodeID().equals(nodeID))
                return theNode;
        }
        return null;
    }

    public void sendMessage(String message) {

    }

}
