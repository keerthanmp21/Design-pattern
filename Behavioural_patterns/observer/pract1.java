package Behavioural_patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class pract1 {
    public static void main(String[] args) {
        // Create WeatherStation (Subject)
        WeatherStation weatherStation = new WeatherStation();

        // Create Displays (Observers)
        Observer phoneDisplay1 = new PhoneDisplay("Alice's Phone");
        Observer phoneDisplay2 = new PhoneDisplay("Bob's Phone");
        Observer ledDisplay = new LEDDisplay();

        // Register observers
        weatherStation.addObserver(phoneDisplay1);
        weatherStation.addObserver(phoneDisplay2);
        weatherStation.addObserver(ledDisplay);

        // Simulate temperature changes
        weatherStation.setTemperature(25.0f);
        weatherStation.setTemperature(30.5f);

        // Remove an observer
        weatherStation.removeObserver(phoneDisplay1);

        // Change temperature again
        weatherStation.setTemperature(28.0f);
    }
}

interface Observer{
    void update(float temperature);
}

class WeatherStation{
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void setTemperature(float temperature){
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers(){
        for(Observer observer: observers){
            observer.update(temperature);
        }
    }
}

class PhoneDisplay implements Observer{
    private String name;

    public PhoneDisplay(String name){
        this.name = name;
    }

    @Override
    public void update(float temperature) {
        System.out.println(name + " Display: Temperature updated to " + temperature + "°C");
    }
}

class LEDDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("LED Display: Temperature is now " + temperature + "°C");
    }
}