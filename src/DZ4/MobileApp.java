package DZ4;


import java.util.Collection;
import java.util.Date;

public class MobileApp {
    private final Customer customer;
    private final TicketProvider ticketProvider;

    public MobileApp(TicketProvider ticketProvider, CustomerProvider customerProvider) {
        this.ticketProvider = ticketProvider;
        this.customer = customerProvider.getCustomer("login", "password");
    }

    public Collection<Ticket> getTickets() {
        return this.customer.getTickets();
    }

    public void searchTicket(Date date) {
        this.customer.setTickets(this.ticketProvider.searchTicket(this.customer.getId(), new Date()));
    }

    public boolean buyTicket(String cardNo) {
        return this.ticketProvider.buyTicket(this.customer.getId(), cardNo);
    }
}
