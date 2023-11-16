package DZ8.Presenters;

import java.util.Collection;
import java.util.Date;
import DZ8.Models.Table;

public interface Model {
    Collection<Table> loadTables();

    int reservationTable(Date var1, int var2, String var3);
    boolean changeReservation(int reservationId, Date newReservationDate, String newName);
}
