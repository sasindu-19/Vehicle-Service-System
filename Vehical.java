public class Vehical{
    String vehicalNumber;
    String ownerName;
    String serviceType;
    int priority;
    String serviceStatus;   // "WAITING" or "SERVICED"
    Vehical next;

    public Vehical(String vehicalNumber,String ownerName,String serviceType,int priority){
        this.vehicalNumber = vehicalNumber;
        this.ownerName = ownerName;
        this.serviceType = serviceType;
        this.priority = priority;
        this.serviceStatus = "WAITING";   // default when added to queue
        this.next = null;
    }
}