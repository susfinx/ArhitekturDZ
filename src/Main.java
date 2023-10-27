import DZ2.Singleton;

public class Main {
    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstance();

        singleton.setSettings(" New settings");

        System.out.println("Settings: " + singleton.getSettings());

        Singleton anotherSingleton = Singleton.getInstance();

        System.out.println("Are they the same instance? " + (singleton == anotherSingleton));
    }
}