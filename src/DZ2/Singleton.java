package DZ2;

public class Singleton {
    private static Singleton instance;
    private String settings;
    private Singleton() {
        settings = "Default settings";
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public String getSettings() {
        return settings;
    }

    public void setSettings(String newSettings) {
        settings = newSettings;
    }
}


