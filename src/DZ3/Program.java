package DZ3;

import java.awt.*;

public class Program {

    /**
     * TODO: Домашнее задание:
     * Доработать приложение, спроектированное на семинаре. Добавить тип, описывающий "автомойку".
     * Продемонстрировать работу получившейся программы,
     * создать несколько типов автомобилей,
     * загнать каждый автомобиль на заправку, а затем и на автомойку.
     *
     * @param args
     */
    public static void main(String[] args) {
        RefuelingStation refuelingStation = new RefuelingStation();
        RefuelingStationV2 refuelingStation2 = new RefuelingStationV2();

        Harvester harvester = new Harvester("A", "B", Color.BLACK);
        harvester.setRefuelingStation(refuelingStation2);
        harvester.fuel();
        harvester.wash(); // Мойка комбайна

        SportCar sportCar = new SportCar("X", "Y", Color.RED);
        sportCar.setRefuelingStation(refuelingStation);
        sportCar.fuel();
        sportCar.wash(); // Мойка спортивного автомобиля
    }

}