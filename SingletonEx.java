public class SingletonEx{
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        s1.checkSingleton();

        Singleton s2 = Singleton.getInstance();
        s2.checkSingleton();
    }
}

class Singleton{
    private static Singleton instance;
    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            System.out.println("creating new instance");
            instance = new Singleton();
        }
        return instance;
    }

    public void checkSingleton(){
        System.out.println("inside singleton");
    }
}