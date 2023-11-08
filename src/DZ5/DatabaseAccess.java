package DZ5;

import java.util.Collection;
public interface DatabaseAccess {
    void addEntity(Entity var1);

    void removeEntity(Entity var1);

    Collection<Texture> getAllTextures();

    Collection<Model3D> getAllModels();
}