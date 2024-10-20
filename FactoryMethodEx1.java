public class FactoryMethodEx1 {
    public static void main(String[] args) {
        Logistics roadLogistics = new ReadLogistics();
        roadLogistics.planDelivery();

        Logistics seaLogistics = new SeaLogistics();
        seaLogistics.planDelivery();
    }
}

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

abstract class Logistics{
    public abstract Transport createTransport();

    public void planDelivery(){
        Transport transport = createTransport();
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