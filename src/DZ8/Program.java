
package DZ8;

import java.util.Date;
import ru.geekbrains.lesson8.Models.TableModel;
import ru.geekbrains.lesson8.Presenters.BookingPresenter;
import ru.geekbrains.lesson8.Presenters.Model;
import ru.geekbrains.lesson8.Views.BookingView;

public class Program {
    public Program() {
    }

    public static void main(String[] args) {
        Model model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateTables();
        view.reservationTable(new Date(), 33, "Станислав");
    }
}
