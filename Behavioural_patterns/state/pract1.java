package Behavioural_patterns.state;

public class pract1 {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.setState(new RedLight());
        trafficLight.applyState();

        trafficLight.setState(new YellowLight());
        trafficLight.applyState();

        trafficLight.setState(new GreenLight());
        trafficLight.applyState();
    }
}

interface TrafficLightState {
    void handleRequest();
}

class RedLight implements TrafficLightState {
    @Override
    public void handleRequest() {
        System.out.println("Red Light");
    }
}

class YellowLight implements TrafficLightState {
    @Override
    public void handleRequest() {
        System.out.println("Yellow Light");
    }
}

class GreenLight implements TrafficLightState {
    @Override
    public void handleRequest() {
        System.out.println("Green Light");
    }
}

class TrafficLight{
    private TrafficLightState currentState;

    public void setState(TrafficLightState state) {
        this.currentState = state;
    }

    public void applyState() {
        currentState.handleRequest();
    }
}

