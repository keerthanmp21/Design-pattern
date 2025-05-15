package Structural_patterns;

class Projector {
    public void on() { System.out.println("Projector on"); }
    public void off() { System.out.println("Projector off"); }
}

class Amplifier {
    public void on() { System.out.println("Amplifier on"); }
    public void off() { System.out.println("Amplifier off"); }
}

class Screen {
    public void down() { System.out.println("Screen down"); }
    public void up() { System.out.println("Screen up"); }
}

class HomeTheaterFacade {
    private Projector projector;
    private Amplifier amplifier;
    private Screen screen;

    public HomeTheaterFacade(Projector projector, Amplifier amplifier, Screen screen) {
        this.projector = projector;
        this.amplifier = amplifier;
        this.screen = screen;
    }

    public void watchMovie() {
        System.out.println("Getting ready to watch a movie...");
        screen.down();
        projector.on();
        amplifier.on();
    }

    public void endMovie() {
        System.out.println("Shutting down movie theater...");
        amplifier.off();
        projector.off();
        screen.up();
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        Projector projector = new Projector();
        Amplifier amplifier = new Amplifier();
        Screen screen = new Screen();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(projector, amplifier, screen);

        homeTheater.watchMovie();
        System.out.println("-----");
        homeTheater.endMovie();
    }

}
