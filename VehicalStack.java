public class VehicalStack{
    Vehical top;

    public VehicalStack(){
        this.top = null;
    }

    public void push(Vehical completVehical){
        if (completVehical == null) {
            return;
        }

        completVehical.next = top;

        top = completVehical;

        System.out.println("Vehical [" + completVehical.vehicalNumber + "] added to history stack.");
    }

    public void displayHistory(){
        if (top == null) {
            System.out.println("No service history records found.");
            return;
        }

        System.out.println("\n=== COMPLETED SERVICE HISTORY ===");
        Vehical current = top;
        int count = 1;

        while (current != null) {
            System.out.println(count + ". [" + current.vehicalNumber + "] | Owner: " + current.ownerName + " | Service: " + current.serviceType);
            current = current.next;
            count++;
        }

        System.out.println("========================================\n");
    }
}