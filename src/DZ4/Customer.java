package DZ4;


import java.util.Collection;

public class Customer {
    private static int counter;
    private final int id;
    private Collection<Ticket> tickets;

    public Customer() {
        this.id = ++counter;
    }

    public Collection<Ticket> getTickets() {
        return this.tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getId() {
        return this.id;
    }
}
