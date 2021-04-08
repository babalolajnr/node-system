import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

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

        try {
            InetAddress address = InetAddress.getByName("localhost");
            message = message + ", " + nodeIPAddress + ", " + nodePortNumber + ", " + nodeID;
            DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, address, 4000);
            DatagramSocket socket = new DatagramSocket(10000);

            socket.send(packet);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        return this.nodeIPAddress;
    }

    public void setMaxJobs(int maxJobs) {
        this.maxJobs = maxJobs;
    }

    public String getNodeID(Node node) {
        return node.nodeID;
    }
}
