package Creational_patterns;


class Car {
    private String engine;
    private String wheels;
    private String color;

    public void setEngine(String engine) { this.engine = engine; }
    public void setWheels(String wheels) { this.wheels = wheels; }
    public void setColor(String color) { this.color = color; }

    public void show() {
        System.out.println("Car with engine: " + engine + ", wheels: " + wheels + ", color: " + color);
    }
}

interface CarBuilder {
    void buildEngine();
    void buildWheels();
    void paint();
    Car getCar();
}

class SportsCarBuilder implements CarBuilder {
    private Car car = new Car();

    public void buildEngine() {
        car.setEngine("V8 Engine");
    }

    public void buildWheels() {
        car.setWheels("Sports Wheels");
    }

    public void paint() {
        car.setColor("Red");
    }

    public Car getCar() {
        return car;
    }
}

class CarDirector {
    private CarBuilder builder;

    public CarDirector(CarBuilder builder) {
        this.builder = builder;
    }

    public Car constructCar() {
        builder.buildEngine();
        builder.buildWheels();
        builder.paint();
        return builder.getCar();
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        CarBuilder builder = new SportsCarBuilder();
        CarDirector director = new CarDirector(builder);

        Car car = director.constructCar();
        car.show();
    }

}