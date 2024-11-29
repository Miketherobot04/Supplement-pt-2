import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class NodeTest {
    @Test
    void testNodeCreation() {
        Node node = new Node(10);
        assertNotNull(node);
        assertEquals(10, node.data);
    }

    @Test
    void testInsertion() {
        Node root = new Node(10);
        root.insert(5);
        root.insert(15);

        assertNotNull(root.left);
        assertNotNull(root.right);
        assertEquals(5, root.left.data);
        assertEquals(15, root.right.data);
    }

    @Test
    void testDump() {
        Node root = new Node(10);
        root.insert(5);
        root.insert(15);

        String expectedOutput = """
        NodeID: 1, Data: 10
            NodeID: 2, Data: 5
            NodeID: 3, Data: 15
        """;
        assertEquals(expectedOutput.trim(), root.dump(0).trim());
    }
}