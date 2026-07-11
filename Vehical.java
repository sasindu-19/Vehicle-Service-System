public class Vehical{
    String vehicalNumber;
    String ownerName;
    String serviceType;
    int priority;
    Vehical next;

    public Vehical(String vehicalNumber,String ownerName,String serviceType,int priority){
        this.vehicalNumber = vehicalNumber;
        this.ownerName = ownerName;
        this.serviceType = serviceType;
        this.priority = priority;
        this.next = null;
    }
}