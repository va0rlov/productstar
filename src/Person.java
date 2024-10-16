/**
 * Абстрактный класс, представляющий человека.
 * Содержит общие свойства и методы, которые могут быть использованы в подклассах.
 */
public abstract class Person {
    // Имя человека
    String name;

    // Возраст человека
    int age;

    // Рост человека в сантиметрах
    int height;

    // Отдел, в котором работает человек
    String department;

    /**
     * Абстрактный метод для приветствия.
     * Каждый подкласс должен реализовать этот метод по-своему.
     */
    public abstract void sayHi();

    /**
     * Метод для описания человека.
     * Выводит информацию о человеке, включая его имя, возраст, рост и отдел.
     */
    public void describePerson() {
        System.out.println(
                name + " is " + age + " years old and is " + height + " cm tall. " +
                        "Works in " + department + " department"
        );
    }
}