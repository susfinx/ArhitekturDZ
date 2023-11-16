package DZ8.Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import DZ8.Presenters.Model;

public class TableModel implements Model {
    private Collection<Table> tables;

    public TableModel() {
    }

    public Collection<Table> loadTables() {
        if (this.tables == null) {
            this.tables = new ArrayList();
            this.tables.add(new Table());
            this.tables.add(new Table());
            this.tables.add(new Table());
            this.tables.add(new Table());
            this.tables.add(new Table());
        }

        return this.tables;
    }

    public int reservationTable(Date reservationDate, int tableNo, String name) {
        Iterator var4 = this.tables.iterator();

        Table table;
        do {
            if (!var4.hasNext()) {
                throw new RuntimeException("Некорректный номер столика");
            }

            table = (Table)var4.next();
        } while(table.getNo() != tableNo);

        Reservation reservation = new Reservation(tableNo, reservationDate, name);
        table.getReservations().add(reservation);
        return reservation.getId();
    }

    public boolean changeReservation(int reservationId, Date newReservationDate, String newName) {
        for (Table table : tables) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == reservationId) {
                    reservation.setDate(newReservationDate);
                    reservation.setName(newName);
                    return true;
                }
            }
        }
        return false;
    }
}
