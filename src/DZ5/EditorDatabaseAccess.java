package DZ5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class EditorDatabaseAccess implements DatabaseAccess {
    private final Database editorDatabase;

    public EditorDatabaseAccess(Database editorDatabase) {
        this.editorDatabase = editorDatabase;
    }

    public void addEntity(Entity entity) {
        this.editorDatabase.getAll().add(entity);
    }

    public void removeEntity(Entity entity) {
        this.editorDatabase.getAll().remove(entity);
    }

    public Collection<Texture> getAllTextures() {
        Collection<Texture> models = new ArrayList();
        Iterator var2 = this.editorDatabase.getAll().iterator();

        while(var2.hasNext()) {
            Entity entity = (Entity)var2.next();
            if (entity instanceof Texture) {
                models.add((Texture)entity);
            }
        }

        return models;
    }

    public Collection<Model3D> getAllModels() {
        Collection<Model3D> models = new ArrayList();
        Iterator var2 = this.editorDatabase.getAll().iterator();

        while(var2.hasNext()) {
            Entity entity = (Entity)var2.next();
            if (entity instanceof Model3D) {
                models.add((Model3D)entity);
            }
        }

        return models;
    }
}
