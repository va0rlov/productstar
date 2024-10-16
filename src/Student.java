/**
 * Класс, представляющий студента.
 * Наследуется от абстрактного класса Person.
 */
public class Student extends Person {

    /**
     * Конструктор для инициализации свойств студента.
     *
     * @param name       Имя студента.
     * @param age        Возраст студента.
     * @param height     Рост студента в сантиметрах.
     * @param department Отдел, в котором учится студент.
     */
    public Student(String name, int age, int height, String department) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.department = department;
    }

    /**
     * Переопределение метода sayHi для студента.
     * Выводит приветствие от имени студента.
     */
    @Override
    public void sayHi() {
        System.out.println("Good morning, sir! My name is " + name + " and I'm a student");
    }

    /**
     * Метод, представляющий студента, который идет на вечеринку.
     * Выводит сообщение о том, что студент идет на вечеринку.
     */
    public void haveAParty() {
        System.out.println("Party time! BYOB!");
    }
}