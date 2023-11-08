package DZ5;

public class Texture implements Entity {
    private static int counter = 50000;
    private int id;

    public Texture() {
        this.id = ++counter;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return String.format("Texture #%s", this.id);
    }
}
