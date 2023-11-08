package DZ5;

import java.util.ArrayList;
import java.util.Iterator;

public class Editor3D implements UILayer {
    private EditorBusinessLogicalLayer businessLogicalLayer;
    private EditorDatabase database;
    private ProjectFile projectFile;
    private EditorDatabaseAccess databaseAccess;


    public void addModel() {
        this.checkProjectFile();
        Model3D newModel = new Model3D();
        this.businessLogicalLayer.getAllModels().add(newModel);
        System.out.println("3D модель успешно добавлена.");
    }

    public void removeModel(int i) {
        this.checkProjectFile();
        ArrayList<Model3D> models = (ArrayList) this.businessLogicalLayer.getAllModels();
        if (i >= 0 && i <= models.size() - 1) {
            Model3D removedModel = models.get(i);
            this.businessLogicalLayer.getAllModels().remove(removedModel);
            System.out.println("3D модель успешно удалена.");
        } else {
            throw new RuntimeException("Номер модели указан некорректно.");
        }
    }

    public void addTexture() {
        this.checkProjectFile();
        Texture newTexture = new Texture();
        this.businessLogicalLayer.getAllTextures().add(newTexture);
        System.out.println("Текстура успешно добавлена.");
    }

    public void removeTexture(int i) {
        this.checkProjectFile();
        ArrayList<Texture> textures = (ArrayList) this.businessLogicalLayer.getAllTextures();
        if (i >= 0 && i <= textures.size() - 1) {
            Texture removedTexture = textures.get(i);
            this.businessLogicalLayer.getAllTextures().remove(removedTexture);
            System.out.println("Текстура успешно удалена.");
        } else {
            throw new RuntimeException("Номер текстуры указан некорректно.");
        }
    }

    private void initialize() {
        this.database = new EditorDatabase(this.projectFile);
        this.databaseAccess = new EditorDatabaseAccess(this.database);
        this.businessLogicalLayer = new EditorBusinessLogicalLayer(this.databaseAccess);
    }

    public void openProject(String fileName) {
        this.projectFile = new ProjectFile(fileName);
        this.initialize();
    }

    public void saveProject() {
        System.out.println("Изменения успешно сохранены.");
        this.database.save();
    }

    public void showProjectSettings() {
        this.checkProjectFile();
        System.out.println("*** Project v1 ***");
        System.out.println("******************");
        System.out.printf("fileName: %s\n", this.projectFile.getFileName());
        System.out.printf("setting1: %d\n", this.projectFile.getSetting1());
        System.out.printf("setting2: %s\n", this.projectFile.getSetting2());
        System.out.printf("setting3: %s\n", this.projectFile.getSetting3());
        System.out.println("******************");
    }

    public void printAllModels() {
        this.checkProjectFile();
        ArrayList<Model3D> models = (ArrayList)this.businessLogicalLayer.getAllModels();

        for(int i = 0; i < models.size(); ++i) {
            System.out.printf("===%d===\n", i);
            System.out.println(models.get(i));
            Iterator var3 = ((Model3D)models.get(i)).getTextures().iterator();

            while(var3.hasNext()) {
                Texture texture = (Texture)var3.next();
                System.out.printf("\t%s\n", texture);
            }
        }

    }

    public void printAllTextures() {
        this.checkProjectFile();
        ArrayList<Texture> textures = (ArrayList)this.businessLogicalLayer.getAllTextures();

        for(int i = 0; i < textures.size(); ++i) {
            System.out.printf("===%d===\n", i);
            System.out.println(textures.get(i));
        }

    }

    public void renderAll() {
        this.checkProjectFile();
        System.out.println("Подождите ...");
        long startTime = System.currentTimeMillis();
        this.businessLogicalLayer.renderAllModels();
        long endTime = System.currentTimeMillis() - startTime;
        System.out.printf("Операция выполнена за %d мс.\n", endTime);
    }

    public void renderModel(int i) {
        this.checkProjectFile();
        ArrayList<Model3D> models = (ArrayList)this.businessLogicalLayer.getAllModels();
        if (i >= 0 && i <= models.size() - 1) {
            System.out.println("Подождите ...");
            long startTime = System.currentTimeMillis();
            this.businessLogicalLayer.renderModel((Model3D)models.get(i));
            long endTime = System.currentTimeMillis() - startTime;
            System.out.printf("Операция выполнена за %d мс.\n", endTime);
        } else {
            throw new RuntimeException("Номер модели указан некорректною.");
        }
    }

    private void checkProjectFile() {
        if (this.projectFile == null) {
            throw new RuntimeException("Файл проекта не определен.");
        }
    }
}
