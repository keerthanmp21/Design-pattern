public class FactoryMethodEx2 {
    public static void main(String[] args) {
        LogisticsFactory logistics = new RoadLogisticsFactory();
        Transport transport = logistics.createTransport();
        transport.deliver();

        LogisticsFactory logistics2 = new SeaLogisticsFactory();
        Transport transport2 = logistics2.createTransport();
        transport2.deliver();
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

// Factory interface
interface LogisticsFactory {
    Transport createTransport();
}

// Concrete Factories
class RoadLogisticsFactory implements LogisticsFactory {
    public Transport createTransport() {
        return new Truck();
    }
}

class SeaLogisticsFactory implements LogisticsFactory {
    public Transport createTransport() {
        return new Ship();
    }
}