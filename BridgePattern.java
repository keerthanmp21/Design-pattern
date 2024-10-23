public class BridgePattern {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedColor());
        Shape greenSquare = new Square(new GreenColor());

        redCircle.draw();
        greenSquare.draw();
    }
}

interface Color{
    void applyColor();
}

class RedColor implements Color{
    @Override
    public void applyColor(){
        System.out.println("Applying red color.");
    }
}

class GreenColor implements Color{
    @Override
    public void applyColor(){
        System.out.println("Applying green color.");
    }
}

abstract class Shape{
    protected Color color;

    public Shape(Color color){
        this.color = color;
    }

    abstract public void draw();
}

class Circle extends Shape{
    public Circle(Color color){
        super(color);
    }

    @Override
    public void draw(){
        System.out.println("circle filled with color: ");
        color.applyColor();
    }
}

class Square extends Shape{
    public Square(Color color){
        super(color);
    }

    @Override
    public void draw(){
        System.out.println("square filled with color: ");
        color.applyColor();
    }
}