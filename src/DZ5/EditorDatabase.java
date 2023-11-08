package DZ5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class EditorDatabase implements Database {
    private Random random = new Random();
    private final ProjectFile projectFile;
    private Collection<Entity> entities;

    public EditorDatabase(ProjectFile projectFile) {
        this.projectFile = projectFile;
        this.load();
    }

    public void load() {
    }

    public void save() {
    }

    public Collection<Entity> getAll() {
        if (this.entities == null) {
            this.entities = new ArrayList();
            int modelsCount = 10 - this.random.nextInt(6);

            for(int i = 0; i < modelsCount; ++i) {
                this.generateModelAndTextures();
            }
        }

        return this.entities;
    }

    private void generateModelAndTextures() {
        Model3D model = new Model3D();
        int textureCount = this.random.nextInt(3);

        for(int i = 0; i < textureCount; ++i) {
            Texture texture = this.generateTexture();
            model.getTextures().add(texture);
            this.entities.add(texture);
        }

        this.entities.add(model);
    }

    private Texture generateTexture() {
        return new Texture();
    }
}
