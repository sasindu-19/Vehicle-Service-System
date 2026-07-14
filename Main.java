import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[] servicePackages = {
            "Full Service", "Body Wash", "Engine Tuning", "Brake Repair"
        };

        VehicleQueue serviceQueue = new VehicleQueue();
        VehicalStack historyStack = new VehicalStack();
        VehicleTree  serviceTree  = new VehicleTree();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.println("==================================================");
        System.out.println("      VEHICLE SERVICE MANAGEMENT SYSTEM           ");
        System.out.println("==================================================");
        System.out.println();

        while (choice != 6) {

            System.out.println();
            System.out.println("  MAIN MENU");
            System.out.println("  --------------------------------------------------");
            System.out.println("  [1]  Register New Vehicle");
            System.out.println("  [2]  Service Next Vehicle");
            System.out.println("  [3]  View Waiting Vehicles");
            System.out.println("  [4]  View Service History");
            System.out.println("  [5]  Search Vehicle by Plate Number");
            System.out.println("  [6]  Exit");
            System.out.println("  --------------------------------------------------");
            System.out.print("  Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("  Invalid input. Please enter a number (1-6).");
                scanner.nextLine();
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.println();
                    System.out.println("  ==================================================");
                    System.out.println("    REGISTER NEW VEHICLE");
                    System.out.println("  ==================================================");

                    System.out.print("  Vehicle Plate No. : ");
                    String Vnum = scanner.nextLine().trim().toUpperCase();

                    System.out.print("  Owner Name        : ");
                    String oName = scanner.nextLine().trim();

                    System.out.println();
                    System.out.println("  Available Services:");
                    System.out.println("  --------------------------------------------------");
                    for (int i = 0; i < servicePackages.length; i++) {
                        System.out.println("  [" + (i + 1) + "]  " + servicePackages[i]);
                    }
                    System.out.println("  --------------------------------------------------");
                    System.out.print("  Select service    : ");

                    int serviceChoice = 1;
                    if (scanner.hasNextInt()) {
                        serviceChoice = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        scanner.nextLine();
                    }

                    String sType;
                    if (serviceChoice >= 1 && serviceChoice <= servicePackages.length) {
                        sType = servicePackages[serviceChoice - 1];
                    } else {
                        System.out.println("  Invalid selection. Defaulting to General Service.");
                        sType = "General Service";
                    }

                    System.out.println();
                    System.out.println("  Priority Level:");
                    System.out.println("  [1]  High     [2]  Normal     [3]  Low");
                    System.out.print("  Select priority   : ");

                    int priorityChoice = 2;
                    if (scanner.hasNextInt()) {
                        priorityChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (priorityChoice < 1 || priorityChoice > 3) {
                            System.out.println("  Invalid priority. Defaulting to Normal.");
                            priorityChoice = 2;
                        }
                    } else {
                        scanner.nextLine();
                    }

                    if (Vnum.isEmpty() || oName.isEmpty()) {
                        System.out.println("  Plate number and owner name cannot be empty.");
                    } else {
                        Vehical newVehical = new Vehical(Vnum, oName, sType, priorityChoice);
                        serviceQueue.enqueue(newVehical);
                    }
                    break;

                case 2:
                    System.out.println();
                    System.out.println("  ==================================================");
                    System.out.println("    SERVICE NEXT VEHICLE");
                    System.out.println("  ==================================================");
                    Vehical servicedVehical = serviceQueue.dequeue();
                    if (servicedVehical != null) {
                        servicedVehical.serviceStatus = "Serviced";
                        historyStack.push(servicedVehical);
                        serviceTree.insert(servicedVehical);
                    }
                    break;

                case 3:
                    System.out.println();
                    System.out.println("  ==================================================");
                    System.out.println("    WAITING VEHICLES");
                    System.out.println("  ==================================================");
                    serviceQueue.display();
                    break;

                case 4:
                    System.out.println();
                    System.out.println("  ==================================================");
                    System.out.println("    SERVICE HISTORY");
                    System.out.println("  ==================================================");
                    historyStack.displayHistory();
                    break;

                case 5:
                    System.out.println();
                    System.out.println("  ==================================================");
                    System.out.println("    SEARCH VEHICLE");
                    System.out.println("  ==================================================");
                    System.out.print("  Plate Number : ");
                    String searchPlate = scanner.nextLine().trim().toUpperCase();

                    if (searchPlate.isEmpty()) {
                        System.out.println("  Plate number cannot be empty.");
                        break;
                    }

                    Vehical inQueue = serviceQueue.searchByPlate(searchPlate);
                    if (inQueue != null) {
                        String pLabel;
                        switch (inQueue.priority) {
                            case 1:  pLabel = "High";    break;
                            case 2:  pLabel = "Normal";  break;
                            case 3:  pLabel = "Low";     break;
                            default: pLabel = "Unknown"; break;
                        }
                        System.out.println();
                        System.out.println("  --------------------------------------------------");
                        System.out.printf("  %-14s : %s%n", "Plate No.",  inQueue.vehicalNumber);
                        System.out.printf("  %-14s : %s%n", "Owner",      inQueue.ownerName);
                        System.out.printf("  %-14s : %s%n", "Service",    inQueue.serviceType);
                        System.out.printf("  %-14s : %s%n", "Priority",   pLabel);
                        System.out.printf("  %-14s : %s%n", "Status",     "Waiting");
                        System.out.println("  --------------------------------------------------");
                    } else {
                        serviceTree.search(searchPlate);
                    }
                    break;

                case 6:
                    System.out.println();
                    System.out.println("  ==================================================");
                    System.out.println("  Thank you. Goodbye!");
                    System.out.println("  ==================================================");
                    System.out.println();
                    break;

                default:
                    System.out.println("  Invalid choice. Please enter a number (1-6).");
            }
        }

        scanner.close();
    }
}