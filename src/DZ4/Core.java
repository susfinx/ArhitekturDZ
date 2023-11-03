package DZ4;

public class Core {
    private final CustomerProvider customerProvider;
    private final TicketProvider ticketProvider;
    private final PaymentProvider paymentProvider;
    private final Database database = new Database();

    public Core() {
        this.customerProvider = new CustomerProvider(this.database);
        this.paymentProvider = new PaymentProvider();
        this.ticketProvider = new TicketProvider(this.database, this.paymentProvider);
    }

    public TicketProvider getTicketProvider() {
        return this.ticketProvider;
    }

    public CustomerProvider getCustomerProvider() {
        return this.customerProvider;
    }
}
