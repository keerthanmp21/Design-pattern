public class prototypeEx1 {
    public static void main(String[] args) {
        try {
            // Create original objects
            Circle originalCircle = new Circle("Red", 5);
            Rectangle originalRectangle = new Rectangle("Blue", 10, 20);

            // Clone the original objects
            Circle clonedCircle = (Circle) originalCircle.clone();
            Rectangle clonedRectangle = (Rectangle) originalRectangle.clone();

            // Modify the cloned objects
            clonedCircle.setColor("Green");
            clonedCircle.setRadius(10);

            clonedRectangle.setColor("Yellow");
            clonedRectangle.setWidth(15);

            // Display the original and cloned objects
            System.out.println("Original Circle:");
            originalCircle.draw();  // Output: Drawing a Circle with radius 5 and color Red

            System.out.println("Cloned Circle:");
            clonedCircle.draw();    // Output: Drawing a Circle with radius 10 and color Green

            System.out.println("Original Rectangle:");
            originalRectangle.draw();  // Output: Drawing a Rectangle with width 10 and height 20 and color Blue

            System.out.println("Cloned Rectangle:");
            clonedRectangle.draw();    // Output: Drawing a Rectangle with width 15 and height 20 and color Yellow

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}


abstract class Shape implements Cloneable{
    private String color;

    public Shape(String color){
        this.color = color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public abstract void draw();

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}

class Circle extends Shape{
    private int radius;

    public Circle(String color, int radius){
        super(color);
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius " + radius + " and color " + getColor());
    }

    // Optionally, override clone if special handling is needed
    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Circle) super.clone(); // Shallow copy by default
    }
}

// Concrete Prototype: Rectangle
class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(String color, int width, int height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle with width " + width + " and height " + height + " and color " + getColor());
    }

    // Optionally, override clone if special handling is needed
    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Rectangle) super.clone(); // Shallow copy by default
    }
}