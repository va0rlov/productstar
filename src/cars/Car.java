package cars;

/**
 * Базовый класс, представляющий автомобиль.
 * Содержит общие характеристики автомобиля и композицию с классами Engine и Wheel.
 */
public class Car {
    private String name; // Имя автомобиля
    private int hp; // Мощность двигателя в лошадиных силах
    private int weight; // Вес автомобиля в килограммах
    private final CarType carType; // Тип автомобиля (седан, внедорожник и т.д.)
    private Wheel wheel; // Композиция с классом Wheel
    private Engine engine; // Композиция с классом Engine

    /**
     * Конструктор класса Car.
     *
     * @param name     Имя автомобиля.
     * @param hp       Мощность двигателя в лошадиных силах.
     * @param weight   Вес автомобиля в килограммах.
     * @param carType  Тип автомобиля.
     */
    public Car(String name, int hp, int weight, CarType carType) {
        this.name = name;
        this.hp = hp;
        this.weight = weight;
        this.carType = carType;
        this.wheel = new Wheel(); // Создание объекта Wheel по умолчанию
        this.engine = new Engine(); // Создание объекта Engine по умолчанию
    }

    /**
     * Возвращает имя автомобиля.
     *
     * @return Имя автомобиля.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя автомобиля.
     *
     * @param name Новое имя автомобиля.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает мощность двигателя в лошадиных силах.
     *
     * @return Мощность двигателя.
     */
    public int getHp() {
        return hp;
    }

    /**
     * Устанавливает мощность двигателя в лошадиных силах.
     *
     * @param hp Новая мощность двигателя.
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Возвращает вес автомобиля в килограммах.
     *
     * @return Вес автомобиля.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Устанавливает вес автомобиля в килограммах.
     *
     * @param weight Новый вес автомобиля.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Возвращает тип автомобиля.
     *
     * @return Тип автомобиля.
     */
    public CarType getCarType() {
        return carType;
    }

    /**
     * Возвращает объект Wheel, связанный с автомобилем.
     *
     * @return Объект Wheel.
     */
    public Wheel getWheel() {
        return wheel;
    }

    /**
     * Устанавливает объект Wheel для автомобиля.
     *
     * @param wheel Новый объект Wheel.
     */
    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    /**
     * Возвращает объект Engine, связанный с автомобилем.
     *
     * @return Объект Engine.
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Устанавливает объект Engine для автомобиля.
     *
     * @param engine Новый объект Engine.
     */
    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}