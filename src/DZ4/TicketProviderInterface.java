package DZ4;

import java.util.Collection;
import java.util.Date;

public interface TicketProviderInterface {
    Collection<Ticket> searchTicket(int clientId, Date date);
    boolean buyTicket(int clientId, String cardNo);
    boolean checkTicket(String qrcode);
}
