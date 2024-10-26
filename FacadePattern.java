public class FacadePattern {
    public static void main(String[] args) {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem soundSystem = new SoundSystem();
        Lights lights = new Lights();

        HomeTheatreFacade homeTheatreFacade = new HomeTheatreFacade(dvdPlayer, 
        projector, soundSystem, lights);

        homeTheatreFacade.watchMovie("Lucia");
        homeTheatreFacade.endMovie();
    }
}

class DVDPlayer{
    public void on(){
        System.out.println("DVD Player is On");
    }

    public void play(String movie){
        System.out.println("Playing movie: " + movie);
    }

    public void off(){
        System.out.println("DVD Player is off");
    }
}

class Projector{
    public void on() {
        System.out.println("Projector is ON");
    }

    public void off() {
        System.out.println("Projector is OFF");
    }

    public void wideScreenMode() {
        System.out.println("Projector in widescreen mode");
    }
}

class SoundSystem{
    public void on() {
        System.out.println("Sound System is ON");
    }

    public void setVolume(int level) {
        System.out.println("Setting volume to " + level);
    }

    public void off() {
        System.out.println("Sound System is OFF");
    }
}

class Lights{
    public void dim(int level) {
        System.out.println("Lights dimming to " + level + "%");
    }
}

class HomeTheatreFacade{
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;
    private Lights lights;

    public HomeTheatreFacade(DVDPlayer dvdPlayer, Projector projector, SoundSystem 
    soundSystem, Lights lights){
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.soundSystem = soundSystem;
        this.lights = lights;
    }

    public void watchMovie(String movie){
        System.out.println("Get ready to watch movie...,,,");
        lights.dim(10);
        projector.on();
        projector.wideScreenMode();
        soundSystem.on();
        soundSystem.setVolume(5);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie(){
        System.out.println("Shutting down home theatre...");
        dvdPlayer.off();
        soundSystem.off();
        projector.off();
        lights.dim(100);
    }
}