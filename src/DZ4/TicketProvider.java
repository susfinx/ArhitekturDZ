package DZ4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class TicketProvider implements TicketProviderInterface {
    private final Database database;
    private final PaymentProvider paymentProvider;

    public TicketProvider(Database database, PaymentProvider paymentProvider) {
        this.database = database;
        this.paymentProvider = paymentProvider;
    }

    @Override
    public Collection<Ticket> searchTicket(int clientId, Date date) {
        Collection<Ticket> tickets = new ArrayList();
        Iterator var4 = this.database.getTickets().iterator();

        while(var4.hasNext()) {
            Ticket ticket = (Ticket)var4.next();
            if (ticket.getCustomerId() == clientId && ticket.getDate().equals(date)) {
                tickets.add(ticket);
            }
        }

        return tickets;
    }

    @Override
    public boolean buyTicket(int clientId, String cardNo) {
        int orderId = this.database.createTicketOrder(clientId);
        double amount = this.database.getTicketAmount();
        return this.paymentProvider.buyTicket(orderId, cardNo, amount);
    }

    @Override
    public boolean checkTicket(String qrcode) {
        Iterator var2 = this.database.getTickets().iterator();

        Ticket ticket;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            ticket = (Ticket)var2.next();
        } while(!ticket.getQrcode().equals(qrcode));

        ticket.setEnable(false);
        return true;
    }
}
