package DZ4;


import java.util.Date;
import java.util.List;

public class Program {
    public Program() {
    }

    public static void main(String[] args) {
        Core core = new Core();
        MobileApp mobileApp = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());
        new BusStation(core.getTicketProvider());

        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        Ticket ticket1 = new Ticket();
        ticket1.setCustomerId(customer1.getId());
        Ticket ticket2 = new Ticket();
        ticket2.setCustomerId(customer2.getId());

        customer1.setTickets(List.of(ticket1));
        customer2.setTickets(List.of(ticket2));

        if (mobileApp.buyTicket("1000000000000099")) {
            mobileApp.searchTicket(new Date());
        }
    }
}