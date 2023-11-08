package DZ5;

import java.util.Collection;

public interface Database {
    void load();

    void save();

    Collection<Entity> getAll();
}
