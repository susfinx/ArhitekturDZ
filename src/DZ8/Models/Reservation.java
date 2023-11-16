package DZ8.Models;

import java.util.Date;

public class Reservation {
    private static int counter = 1000;
    private final int id;
    private final int tableNo;
    private Date date;
    private String name;

    public Reservation(int tableNo, Date date, String name) {
        this.id = ++counter;
        this.tableNo = tableNo;
        this.date = date;
        this.name = name;
    }

    public Date getDate() {
        return this.date;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String newName) {
    }

    public void setDate(Date newReservationDate) {
    }
}
