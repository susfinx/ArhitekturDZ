package DZ5;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class EditorBusinessLogicalLayer implements BusinessLogicalLayer {
    private DatabaseAccess databaseAccess;
    private Random random = new Random();

    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    public Collection<Model3D> getAllModels() {
        return this.databaseAccess.getAllModels();
    }

    public Collection<Texture> getAllTextures() {
        return this.databaseAccess.getAllTextures();
    }

    public void renderModel(Model3D model) {
        this.processRender(model);
    }

    public void renderAllModels() {
        Iterator var1 = this.getAllModels().iterator();

        while(var1.hasNext()) {
            Model3D model = (Model3D)var1.next();
            this.processRender(model);
        }

    }

    private void processRender(Model3D model) {
        try {
            Thread.sleep((long)(2500 - this.random.nextInt(2000)));
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        }

    }
}
