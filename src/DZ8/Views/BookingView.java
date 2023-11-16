package DZ8.Views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import ru.geekbrains.lesson8.Models.Table;
import ru.geekbrains.lesson8.Presenters.View;
import ru.geekbrains.lesson8.Presenters.ViewObserver;

public class BookingView implements View {
    private Collection<ViewObserver> observers = new ArrayList();

    public BookingView() {
    }

    public void registerObserver(ViewObserver observer) {
        this.observers.add(observer);
    }

    public void showTables(Collection<Table> tables) {
        Iterator var2 = tables.iterator();

        while(var2.hasNext()) {
            Table table = (Table)var2.next();
            System.out.println(table);
        }

    }

    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0) {
            System.out.printf("Столик успешно забронирован. Номер резерва #%d\n", reservationNo);
        } else {
            System.out.println("Невозможно забронировать столик.\nПовторите попытку позже.");
        }

    }

    public void reservationTable(Date reservtionDate, int tableNo, String name) {
        Iterator var4 = this.observers.iterator();

        while(var4.hasNext()) {
            ViewObserver observer = (ViewObserver)var4.next();
            observer.onReservationTable(reservtionDate, tableNo, name);
        }

    }
}
