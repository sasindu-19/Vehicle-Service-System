public class VehicleTree {

    private class Node {
        Vehical data;
        Node left, right;

        Node(Vehical v) {
            this.data  = v;
            this.left  = null;
            this.right = null;
        }
    }

    private Node root;

    public VehicleTree() {
        this.root = null;
    }

    //Insert by vehicalNumber
    public void insert(Vehical v) {
        root = insertRec(root, v);
    }

    private Node insertRec(Node node, Vehical v) {
        if (node == null) return new Node(v);
        int cmp = v.vehicalNumber.compareToIgnoreCase(node.data.vehicalNumber);
        if (cmp < 0) {
            node.left  = insertRec(node.left,  v);
        } else if (cmp > 0) {
            node.right = insertRec(node.right, v);
        }
        return node;
    }

    //Search by plate number
    public void search(String plateNumber) {
        Node result = searchRec(root, plateNumber.toUpperCase());

        if (result != null) {
            String pLabel;
            switch (result.data.priority) {
                case 1:  pLabel = "High";    break;
                case 2:  pLabel = "Normal";  break;
                case 3:  pLabel = "Low";     break;
                default: pLabel = "Unknown"; break;
            }
            System.out.println();
            System.out.println("  --------------------------------------------------");
            System.out.printf("  %-14s : %s%n", "Plate No.", result.data.vehicalNumber);
            System.out.printf("  %-14s : %s%n", "Owner",     result.data.ownerName);
            System.out.printf("  %-14s : %s%n", "Service",   result.data.serviceType);
            System.out.printf("  %-14s : %s%n", "Priority",  pLabel);
            System.out.printf("  %-14s : %s%n", "Status",    result.data.serviceStatus);
            System.out.println("  --------------------------------------------------");
        } else {
            System.out.println("  No record found for plate: " + plateNumber);
        }
    }

    private Node searchRec(Node node, String plate) {
        if (node == null) return null;
        int cmp = plate.compareToIgnoreCase(node.data.vehicalNumber);
        if      (cmp == 0) return node;
        else if (cmp  < 0) return searchRec(node.left,  plate);
        else               return searchRec(node.right, plate);
    }
}
