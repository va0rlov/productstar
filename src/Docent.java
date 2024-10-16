/**
 * Класс, представляющий доцента.
 * Наследуется от абстрактного класса Person.
 */
public class Docent extends Person {

    /**
     * Конструктор для инициализации свойств доцента.
     *
     * @param name       Имя доцента.
     * @param age        Возраст доцента.
     * @param height     Рост доцента в сантиметрах.
     * @param department Отдел, в котором работает доцент.
     */
    public Docent(String name, int age, int height, String department) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.department = department;
    }

    /**
     * Переопределение метода sayHi для доцента.
     * Выводит приветствие от имени доцента.
     */
    @Override
    public void sayHi() {
        System.out.println("Yo, mate! I'm a docent. Respect my authority!");
    }

    /**
     * Метод, представляющий доцента, который усложняет жизнь студентам.
     * Выводит сообщение о том, что доцент усложняет жизнь студентам.
     */
    public void makeStudentsSuffer() {
        System.out.println("You shall not pass!");
    }
}