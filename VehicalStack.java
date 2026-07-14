public class VehicalStack {
    Vehical top;

    public VehicalStack() {
        this.top = null;
    }

    public void push(Vehical completVehical) {
        if (completVehical == null) {
            return;
        }
        completVehical.next = top;
        top = completVehical;
        System.out.println("  Vehicle [" + completVehical.vehicalNumber + "] added to history.");
    }

    public void displayHistory() {
        if (top == null) {
            System.out.println("  No service history records found.");
            return;
        }

        System.out.println();
        System.out.println("  No.   Plate No.        Owner                Service");
        System.out.println("  ------------------------------------------------------------");
        Vehical current = top;
        int count = 1;
        while (current != null) {
            System.out.printf("  %-5d %-16s %-20s %s%n",
                    count, current.vehicalNumber, current.ownerName, current.serviceType);
            current = current.next;
            count++;
        }
        System.out.println("  ------------------------------------------------------------");
        System.out.println();
    }
}