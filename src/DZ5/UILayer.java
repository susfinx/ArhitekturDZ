package DZ5;

public interface UILayer {
    void openProject(String var1);

    void showProjectSettings();

    void saveProject();

    void printAllModels();

    void printAllTextures();

    void renderAll();

    void renderModel(int var1);

    void addModel();

    void removeModel(int var1);

    void addTexture();

    void removeTexture(int var1);
}
