package cars;

/**
 * Класс, представляющий автомобиль с двигателем внутреннего сгорания.
 * Наследуется от класса Car и реализует интерфейс Drivable.
 */
public class CombustionCar extends Car implements Drivable {

    /**
     * Конструктор класса CombustionCar.
     *
     * @param name     Имя автомобиля.
     * @param hp       Мощность двигателя в лошадиных силах.
     * @param weight   Вес автомобиля в килограммах.
     * @param carType  Тип автомобиля.
     */
    public CombustionCar(String name, int hp, int weight, CarType carType) {
        super(name, hp, weight, carType);
    }

    /**
     * Реализация метода drive из интерфейса Drivable.
     * Запускает двигатель, поворачивает руль и останавливает двигатель.
     */
    @Override
    public void drive() {
        getEngine().startEngine();
        getWheel().steer();
        getEngine().stopEngine();
    }
}