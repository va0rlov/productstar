// Класс Student, наследующий от Person
public class Student extends Person {

    // Конструктор для инициализации свойств Student
    public Student(String name, int age, int height, String department) {
        super(name, age, height, department);
    }

    // Метод для студента
    public void haveAParty() {
        System.out.println("Party time! BYOB!");
    }

    // Переопределение метода sayHi для студента
    @Override
    public void sayHi() {
        System.out.println("Good morning, sir! My name is " + name + " and I'm a student");
    }
}
