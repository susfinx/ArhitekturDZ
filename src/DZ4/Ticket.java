package DZ4;

import java.util.Date;

class Ticket {
    private int id;
    private int customerId;
    private Date date;
    private String qrcode;
    private boolean enable = true;

    Ticket() {
    }

    public int getId() {
        return this.id;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getQrcode() {
        return this.qrcode;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public Date getDate() {
        return this.date;
    }

    public void setCustomerId(int id) {
    }
}
