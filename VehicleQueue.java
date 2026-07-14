public class VehicleQueue{
    Vehical front;
    Vehical rear;

    public VehicleQueue(){
        this.front = null;
        this.rear = null;
    }

    public void enqueue(Vehical newVehical){
        if (rear == null) {
            front = rear = newVehical;
            System.out.println("Vehical ["+ newVehical.vehicalNumber +"] added to the System Successfully");
            return;
        }

        rear.next = newVehical;
        rear = newVehical;
        System.out.println("Vehical ["+ newVehical.vehicalNumber +"] added to the System Successfully");
    }

    public Vehical dequeue(){
        if (front == null) {
            System.out.println("empty! No vehicals to service.");
            return null;
        }

        Vehical temp = front;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        System.out.println("Vehical ["+ temp.vehicalNumber +"] removed for service.");
        return temp;

    }

    public void display(){
        if(front == null){
            System.out.println("The live service queue is currently empty.");
            return;
        }

        System.out.println("\n--- LIVE SERVICE QUEUE ---");
        Vehical current = front;
        int position = 1;

        while (current != null) {
            System.out.println(position + ".["+ current.vehicalNumber +"] | Owner: "+ current.ownerName +"| Service: " + current.serviceType);
            current = current.next;
            position++;
        }
        System.out.println("--------------------------\n");
    }

    // SEARCH by plate number - used to check if vehicle is still WAITING
    public Vehical searchByPlate(String plateNumber) {
        Vehical current = front;
        while (current != null) {
            if (current.vehicalNumber.equalsIgnoreCase(plateNumber)) {
                return current;   // Found in queue → still WAITING
            }
            current = current.next;
        }
        return null;   // Not in queue
    }
}