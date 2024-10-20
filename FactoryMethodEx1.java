public class FactoryMethodEx1 {
    public static void main(String[] args) {
        Logistics roadLogistics = new ReadLogistics();
        roadLogistics.planDelivery();

        Logistics seaLogistics = new SeaLogistics();
        seaLogistics.planDelivery();
    }
}

// Common interface for all types of transport
interface Transport{
    void deliver();
}

class Truck implements Transport{
    @Override
    public void deliver(){
        System.out.println("Delivering by truck.");
    }
}

class Ship implements Transport{
    @Override
    public void deliver(){
        System.out.println("Delivering by ship.");
    }
}

// Creator class that declares the factory method
abstract class Logistics{
    // Factory method that subclasses will implement
    public abstract Transport createTransport();

    // Business logic that uses the factory method
    public void planDelivery(){
        // Call the factory method to get a transport object
        Transport transport = createTransport();
        // Now use the created transport object
        transport.deliver();
    }
}

class ReadLogistics extends Logistics{
    @Override
    public Transport createTransport(){
        return new Truck();
    }
}

class SeaLogistics extends Logistics{
    @Override
    public Transport createTransport(){
        return new Ship();
    }
}