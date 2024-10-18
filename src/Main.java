import cars.*;

/**
 * Основной класс программы для тестирования автомобилей.
 */
public class Main {

    /**
     * Точка входа в программу.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        Car mazdaCx5 = new CombustionCar("Mazda CX-5", 120, 2200, CarType.SUV);
        Car bmwm3 = new CombustionCar("BMW M3", 220, 1800, CarType.COUPE);
        Car tesla = new ElectricCar("Tesla Model 3", 250, 2000, CarType.SEDAN);

        testTheCar(mazdaCx5);
        testTheCar(bmwm3);
        testTheCar(tesla);
    }

    /**
     * Метод для тестирования автомобиля.
     * Выводит характеристики автомобиля и управляет им.
     *
     * @param car Автомобиль для тестирования.
     */
    public static void testTheCar(Car car) {
        System.out.println("--------------");
        describeCar(car);
        driveCar((Drivable) car);
        System.out.println("--------------");
    }

    /**
     * Метод для вывода характеристик автомобиля.
     *
     * @param car Автомобиль, характеристики которого нужно вывести.
     */
    public static void describeCar(Car car) {
        System.out.println("Name: " + car.getName() + "\n" +
                "Type: " + car.getCarType() + "\n" +
                "HP: " + car.getHp() + "\n" +
                "Weight: " + car.getWeight());
    }

    /**
     * Метод для управления автомобилем.
     * Использует интерфейс Drivable для полиморфного вызова метода drive.
     *
     * @param driveable Объект, реализующий интерфейс Drivable.
     */
    public static void driveCar(Drivable driveable) {
        driveable.drive();
    }
}