import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String nodeIPAddress;
        String nodeID;
        int nodePortNumber;
        int maxJobs;

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter Node IP address");
        nodeIPAddress = scan.nextLine();

        System.out.println("Enter Node ID");
        nodeID = scan.nextLine();

        System.out.println("Enter Node Port Number");
        nodePortNumber = scan.nextInt();

        System.out.println("Enter Maximum Jobs");
        maxJobs = scan.nextInt();

        NodeManager nodeManager = new NodeManager();
        Node node = new Node(nodeIPAddress, nodeID, nodePortNumber, maxJobs);
        nodeManager.registerNewNode(node);

        scan.close();
    }
}
