// Класс Docent, наследующий от Person
public class Docent extends Person {

    // Конструктор для инициализации свойств Docent
    public Docent(String name, int age, int height, String department) {
        super(name, age, height, department);
    }

    // Метод для доцента
    public void makeStudentsSuffer() {
        System.out.println("You shall not pass!");
    }

    // Переопределение метода sayHi для доцента
    @Override
    public void sayHi() {
        System.out.println("Yo, mate! I'm a docent. Respect my authority!");
    }
}
