package DZ5;

import java.util.ArrayList;
import java.util.Collection;

public class Model3D implements Entity {
    private static int counter = 10000;
    private int id;
    private Collection<Texture> textures;

    public Model3D() {
        this.id = ++counter;
    }

    public Collection<Texture> getTextures() {
        if (this.textures == null) {
            this.textures = new ArrayList();
        }

        return this.textures;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return String.format("3DModel #%s", this.id);
    }
}
