public class Node {
    private static int idCounter = 0; // Unique ID generator
    private final int nodeID;
    private Integer data; // Use Integer for null check
    private Node left, right;

    public Node(Integer data) {
        this.nodeID = ++idCounter;
        this.data = data;
    }

    public void insert(int newData) {
        if (data == null) {
            data = newData;
        } else if (newData < data) {
            if (left == null) left = new Node(newData);
            else left.insert(newData);
        } else {
            if (right == null) right = new Node(newData);
            else right.insert(newData);
        }
    }

    public String dump(int level) {
        StringBuilder sb = new StringBuilder();
        sb.append("\t".repeat(level))
          .append("NodeID: ").append(nodeID)
          .append(", Data: ").append(data).append("\n");

        if (left != null) sb.append(left.dump(level + 1));
        if (right != null) sb.append(right.dump(level + 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.insert(5);
        root.insert(15);
        root.insert(3);

        System.out.println(root.dump(0));
    }
}
