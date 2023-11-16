package DZ8.Presenters;

import java.util.Date;

public class BookingPresenter implements ViewObserver {
    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }

    public void updateTables() {
        this.view.showTables(this.model.loadTables());
    }

    private void showReservationTableResult(int reservationNo) {
        this.view.showReservationTableResult(reservationNo);
    }

    public void onReservationTable(Date reservtionDate, int tableNo, String name) {
        try {
            int reservationNo = this.model.reservationTable(reservtionDate, tableNo, name);
            this.showReservationTableResult(reservationNo);
        } catch (RuntimeException var5) {
            this.showReservationTableResult(-1);
        }

    }

    public void changeReservationTable(int reservationId, Date newReservationDate, String newName) {
        try {
            boolean reservationChanged = model.changeReservation(reservationId, newReservationDate, newName);

            if (reservationChanged) {
                System.out.println("Бронь успешно изменена.");
                updateTables();
            } else {
                System.out.println("Не удалось изменить бронь. Пожалуйста, попробуйте позже.");
            }
        } catch (RuntimeException e) {
            System.out.println("Ошибка при изменении брони: " + e.getMessage());
        }
    }
}