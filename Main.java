import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        String[] servicePackages = {"Full Service","Body Wash","Engine Tuning","Break Repair"};

        VehicleQueue serviceQueue = new VehicleQueue();
        VehicalStack historyStack = new VehicalStack();
        VehicleTree  serviceTree  = new VehicleTree();   // BST - stores serviced vehicles

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.println("==================================================");
        System.out.println("        VEHICLE SERVICE MANAGEMENT SYSTEM         ");
        System.out.println("==================================================");

        while (choice != 6) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add New Vehicle to Queue (Enqueue)");
            System.out.println("2. Process/Service Next Vehicle (Dequeue -> Push to History)");
            System.out.println("3. View Live Waiting Queue (Display Queue)");
            System.out.println("4. View Completed Service History (Display Stack)");
            System.out.println("--- BST (Binary Search Tree) ---");
            System.out.println("5. Search Serviced Vehicle by Plate (BST Search)");
            System.out.println("6. Exit System");
            System.out.print("Enter your choice (1-6): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            }else{
                System.out.println("Invalid input! Please enter a number between 1 and 6");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter Vehical Number: ");
                    String Vnum = scanner.nextLine().trim();

                    System.out.println("Enter Owner's Name: ");
                    String oName = scanner.nextLine().trim();

                    System.out.println("Available Services: ");
                    for(int i=0; i<servicePackages.length; i++){
                        System.out.println(" [" + (i + 1) + "]" + servicePackages[i]);
                    }

                    System.out.println("Select Service Number: ");
                    int serviceChoice = scanner.nextInt();
                    scanner.nextLine();

                    String sType;
                    if (serviceChoice >=1 && serviceChoice <= servicePackages.length) {
                        sType = servicePackages[serviceChoice - 1];
                    }else{
                        System.out.println("Invalid selection! Defaulting to General Service.");
                        sType = "General Service";
                    }

                    System.out.println("Select Priority: [1] HIGH  [2] NORMAL  [3] LOW");
                    int priorityChoice = 2;  // default NORMAL
                    if (scanner.hasNextInt()) {
                        priorityChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (priorityChoice < 1 || priorityChoice > 3) {
                            System.out.println("Invalid priority! Defaulting to NORMAL.");
                            priorityChoice = 2;
                        }
                    } else {
                        scanner.nextLine();
                    }

                    if (Vnum.isEmpty() || oName.isEmpty()) {
                        System.out.println("Error: Vehicle Number and Owner Name cannot be empty!");
                    }else{
                        Vehical newVehical = new Vehical(Vnum, oName, sType, priorityChoice);
                        serviceQueue.enqueue(newVehical);
                    }
                    break;
            
                case 2:
                    Vehical servicedVehical = serviceQueue.dequeue();

                    if (servicedVehical != null) {
                        servicedVehical.serviceStatus = "SERVICED";   // update status
                        historyStack.push(servicedVehical);            // Stack - LIFO history
                        serviceTree.insert(servicedVehical);           // BST  - auto insert
                        System.out.println("Success: Vehicle moved to history records.");
                    }
                    break;

                case 3:
                    serviceQueue.display();
                    break;

                case 4:
                    historyStack.displayHistory();
                    break;

                case 5:
                    // Search by plate — check Queue (WAITING) first, then BST (SERVICED)
                    System.out.print("Enter Plate Number to search: ");
                    String searchPlate = scanner.nextLine().trim().toUpperCase();

                    Vehical inQueue = serviceQueue.searchByPlate(searchPlate);
                    if (inQueue != null) {
                        // Found in Queue → still WAITING
                        String pLabel;
                        switch (inQueue.priority) {
                            case 1: pLabel = "HIGH";   break;
                            case 2: pLabel = "NORMAL"; break;
                            case 3: pLabel = "LOW";    break;
                            default: pLabel = "UNKNOWN";
                        }
                        System.out.println("  [FOUND]");
                        System.out.println("    Plate    : " + inQueue.vehicalNumber);
                        System.out.println("    Owner    : " + inQueue.ownerName);
                        System.out.println("    Service  : " + inQueue.serviceType);
                        System.out.println("    Priority : " + pLabel);
                        System.out.println("    Status   : WAITING");
                    } else {
                        // Not in queue — search BST (SERVICED vehicles)
                        serviceTree.search(searchPlate);
                    }
                    break;

                case 6:
                    System.out.println("Exiting the system. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
        scanner.close();
    }
}