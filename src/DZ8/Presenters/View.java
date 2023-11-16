package DZ8.Presenters;

import java.util.Collection;
import ru.geekbrains.lesson8.Models.Table;

public interface View {
    void registerObserver(ViewObserver var1);

    void showTables(Collection<Table> var1);

    void showReservationTableResult(int var1);
}
