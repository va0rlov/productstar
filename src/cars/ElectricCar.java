package cars;

/**
 * Класс, представляющий электромобиль.
 * Наследуется от класса Car и реализует интерфейс Drivable.
 */
public class ElectricCar extends Car implements Drivable {

    /**
     * Конструктор класса ElectricCar.
     *
     * @param name     Имя автомобиля.
     * @param hp       Мощность двигателя в лошадиных силах.
     * @param weight   Вес автомобиля в килограммах.
     * @param carType  Тип автомобиля.
     */
    public ElectricCar(String name, int hp, int weight, CarType carType) {
        super(name, hp, weight, carType);
    }

    /**
     * Реализация метода drive из интерфейса Drivable.
     * Поворачивает руль (электромобили не требуют запуска двигателя).
     */
    @Override
    public void drive() {
        getWheel().steer();
    }
}