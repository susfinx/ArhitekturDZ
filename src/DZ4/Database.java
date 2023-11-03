package DZ4;


import java.util.ArrayList;
import java.util.Collection;

public class Database {
    private static int counter;
    private Collection<Ticket> tickets = new ArrayList();
    private Collection<Customer> customers = new ArrayList();

    public Database() {
    }

    public Collection<Ticket> getTickets() {
        return this.tickets;
    }

    public Collection<Customer> getCustomers() {
        return this.customers;
    }

    public double getTicketAmount() {
        return 55.0;
    }

    public int createTicketOrder(int clientId) {
        return ++counter;
    }
}
