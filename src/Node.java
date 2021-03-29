public class Node {
    private String nodeIPAddress;
    private String nodeID;
    private int nodePortNumber;
    private int maxJobs;
    private int currentJobs;

    public Node(String nodeIPAddress, String nodeID, int port, int maxJobs) {
        this.nodeIPAddress = nodeIPAddress;
        this.nodeID = nodeID;
        this.maxJobs = maxJobs;
        nodePortNumber = port;
    }

    public boolean sendMessage(String message) {
        // code here
        return true;
    }

    public boolean addJob() {
        // code here
        if (currentJobs + 1 > maxJobs)
            return false;
        else {
            currentJobs++;
            return true;
        }
    }

    public boolean finishJob() {
        // code here
        currentJobs--;
        if (currentJobs < 0)
            currentJobs = 0;
        return true;
    }

    public int calculateWeight() {
        return maxJobs / currentJobs;
    }

    public String getNodeIPAddress() {
        return "";
    }

    public void setMaxJobs(int maxJobs) {

    }
}
