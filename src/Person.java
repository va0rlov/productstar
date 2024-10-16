// Базовый класс Person
public class Person {
    String name;
    int age;
    int height;
    String department;

    // Конструктор для инициализации общих свойств
    public Person(String name, int age, int height, String department) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.department = department;
    }

    // Метод для приветствия
    public void sayHi() {
        System.out.println("Hello! My name is " + name);
    }

    // Метод для описания человека
    public void describePerson() {
        System.out.println(
                name + " is " + age + " years old and is " + height + " cm tall. " +
                        "Works in " + department + " department"
        );
    }
}

