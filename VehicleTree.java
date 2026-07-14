/**
 * VehicleTree.java
 * Binary Search Tree (BST) to store SERVICED vehicles.
 *
 * DATA STRUCTURE: Binary Search Tree (BST)
 *   - Key: vehicalNumber (plate number) - lexicographic order
 *   - Insert : O(log n) average
 *   - Search : O(log n) average
 *   - Traversal: O(n)
 *
 * ALGORITHMS:
 *   - BST Insert  (recursive)
 *   - BST Search  (recursive)
 *   - In-Order Traversal  -> sorted output by plate number
 */
public class VehicleTree {

    // ---- Inner BST Node class ----
    private class Node {
        Vehical data;
        Node left, right;

        Node(Vehical v) {
            this.data = v;
            this.left  = null;
            this.right = null;
        }
    }

    private Node root;  // root of the BST

    public VehicleTree() {
        this.root = null;
    }

    // ================================================================
    //  INSERT - BST Insert by vehicalNumber (lexicographic)
    //  Time Complexity: O(log n) average, O(n) worst case
    // ================================================================
    public void insert(Vehical v) {
        root = insertRec(root, v);
        System.out.println("  [BST] Vehicle [" + v.vehicalNumber + "] inserted into BST.");
    }

    private Node insertRec(Node node, Vehical v) {
        if (node == null) return new Node(v);   // Found empty spot - insert here

        int cmp = v.vehicalNumber.compareToIgnoreCase(node.data.vehicalNumber);

        if (cmp < 0) {
            node.left  = insertRec(node.left,  v);   // Go left
        } else if (cmp > 0) {
            node.right = insertRec(node.right, v);   // Go right
        } else {
            System.out.println("  [BST] Vehicle [" + v.vehicalNumber + "] already in tree.");
        }
        return node;
    }

    // ================================================================
    //  SEARCH - BST Search by plate number
    //  Time Complexity: O(log n) average
    // ================================================================
    public void search(String plateNumber) {
        System.out.println("\n  Searching BST for: " + plateNumber + "...");
        Node result = searchRec(root, plateNumber.toUpperCase());

        if (result != null) {
            String priorityLabel;
            switch (result.data.priority) {
                case 1: priorityLabel = "HIGH";   break;
                case 2: priorityLabel = "NORMAL"; break;
                case 3: priorityLabel = "LOW";    break;
                default: priorityLabel = "UNKNOWN";
            }
            System.out.println("  [FOUND]");
            System.out.println("    Plate    : " + result.data.vehicalNumber);
            System.out.println("    Owner    : " + result.data.ownerName);
            System.out.println("    Service  : " + result.data.serviceType);
            System.out.println("    Priority : " + priorityLabel);
            System.out.println("    Status   : SERVICED");
        } else {
            System.out.println("  [NOT FOUND] No serviced vehicle with plate: " + plateNumber);
        }
    }

    private Node searchRec(Node node, String plate) {
        if (node == null) return null;   // Not found

        int cmp = plate.compareToIgnoreCase(node.data.vehicalNumber);

        if      (cmp == 0) return node;                        // Found!
        else if (cmp < 0)  return searchRec(node.left,  plate); // Search left
        else               return searchRec(node.right, plate); // Search right
    }

}
