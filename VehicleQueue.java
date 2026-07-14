public class VehicleQueue {
    Vehical front;
    Vehical rear;

    public VehicleQueue() {
        this.front = null;
        this.rear  = null;
    }

    public void enqueue(Vehical newVehical) {
        if (rear == null) {
            front = rear = newVehical;
        } else {
            rear.next = newVehical;
            rear = newVehical;
        }
        System.out.println("  Vehicle [" + newVehical.vehicalNumber + "] registered successfully.");
    }

    public Vehical dequeue() {
        if (front == null) {
            System.out.println("  No vehicles waiting for service.");
            return null;
        }
        Vehical temp = front;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        System.out.println("  Processing vehicle [" + temp.vehicalNumber + "] ...");
        return temp;
    }

    public void display() {
        if (front == null) {
            System.out.println("  No vehicles currently waiting.");
            return;
        }
        System.out.println();
        System.out.println("  No.   Plate No.        Owner                Service");
        System.out.println("  ------------------------------------------------------------");
        Vehical current = front;
        int position = 1;
        while (current != null) {
            System.out.printf("  %-5d %-16s %-20s %s%n",
                    position, current.vehicalNumber, current.ownerName, current.serviceType);
            current = current.next;
            position++;
        }
        System.out.println("  ------------------------------------------------------------");
        System.out.println();
    }

    public Vehical searchByPlate(String plateNumber) {
        Vehical current = front;
        while (current != null) {
            if (current.vehicalNumber.equalsIgnoreCase(plateNumber)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}