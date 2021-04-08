import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String nodeIPAddress;
        String nodeID;
        int nodePortNumber;
        int maxJobs;
        String message;

        Scanner scan = new Scanner(System.in);

        System.out.println("Send message");
        message = scan.nextLine();

        System.out.println("Enter Node IP address");
        nodeIPAddress = scan.nextLine();

        System.out.println("Enter Node ID");
        nodeID = scan.nextLine();

        System.out.println("Enter Node Port Number");
        nodePortNumber = scan.nextInt();

        System.out.println("Enter Maximum Jobs");
        maxJobs = scan.nextInt();

        System.out.println("Creating a new node ...");

        NodeManager nodeManager = new NodeManager();
        Node node = new Node(nodeIPAddress, nodeID, nodePortNumber, maxJobs);
        nodeManager.registerNewNode(node);

        System.out.println("Node created!");

        System.out.println("Sending message ...");
        node.sendMessage(message);

        System.out.println("Message sent ...");

        scan.close();
    }
}
