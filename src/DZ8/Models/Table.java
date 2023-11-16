package DZ8.Models;

import java.util.ArrayList;
import java.util.Collection;

public class Table {
    private static int counter;
    private final int no;
    private final Collection<Reservation> reservations;

    public Table() {
        this.no = ++counter;
        this.reservations = new ArrayList();
    }

    public Collection<Reservation> getReservations() {
        return this.reservations;
    }

    public int getNo() {
        return this.no;
    }

    public String toString() {
        return String.format("Столик #%d", this.no);
    }
}
