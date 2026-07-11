import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        String[] servicePackages = {"Full Service","Body Wash","Engine Tuning","Break Repair"};

        VehicleQueue serviceQueue = new VehicleQueue();
        VehicalStack historyStack = new VehicalStack();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        System.out.println("==================================================");
        System.out.println("  VEHICLE SERVICE QUEUE MANAGEMENT SYSTEM (CLI)   ");
        System.out.println("==================================================");

        while (choice != 5) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add New Vehicle to Queue (Enqueue)");
            System.out.println("2. Process/Service Next Vehicle (Dequeue -> Push to History)");
            System.out.println("3. View Live Waiting Queue (Display Queue)");
            System.out.println("4. View Completed Service History (Display Stack)");
            System.out.println("5. Exit System");
            System.out.print("Enter your choice (1-5): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            }else{
                System.out.println("Invalid input! Please enter a number between 1 and 5");
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

                    if (Vnum.isEmpty() || oName.isEmpty()) {
                        System.out.println("Error: Vehicle Number and Owner Name cannot be empty!");
                    }else{
                        Vehical newVehical = new Vehical(Vnum, oName, sType, 2);
                        serviceQueue.enqueue(newVehical);
                    }
                    break;
            
                case 2:
                    Vehical servicedVehical = serviceQueue.dequeue();

                    if (servicedVehical != null) {
                        historyStack.push(servicedVehical);
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
                    System.out.println("Exiting the system. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
        scanner.close();
    }
}