package Creational_patterns;

interface Prototype extends Cloneable {
    Prototype clone();
}

class Shape implements Prototype {
    private String type;
    private int x;
    private int y;

    public Shape(String type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    @Override
    public Shape clone() {
        return new Shape(this.type, this.x, this.y); // deep copy for primitives
    }

    public void draw() {
        System.out.println("Drawing " + type + " at (" + x + ", " + y + ")");
    }
}

public class PrototypePattern {
    public static void main(String[] args) {
        Shape original = new Shape("Circle", 10, 20);
        Shape clone1 = original.clone();
        Shape clone2 = original.clone();

        original.draw();
        clone1.draw();
        clone2.draw();
    }

}
