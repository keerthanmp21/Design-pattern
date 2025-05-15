package Structural_patterns;

interface Beverage {
    String getDescription();
    double getCost();
}

class Espresso implements Beverage {
    public String getDescription() {
        return "Espresso";
    }

    public double getCost() {
        return 2.0;
    }
}

abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}

class Milk extends BeverageDecorator {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    public double getCost() {
        return beverage.getCost() + 0.5;
    }
}

class Sugar extends BeverageDecorator {
    public Sugar(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Sugar";
    }

    public double getCost() {
        return beverage.getCost() + 0.2;
    }
}


public class DecoratorPattern {
    public static void main(String[] args) {
        Beverage drink = new Espresso();
        drink = new Milk(drink);
        drink = new Sugar(drink);

        System.out.println(drink.getDescription()); // Espresso, Milk, Sugar
        System.out.println("Cost: $" + drink.getCost()); // Cost: $2.7
    }

}
