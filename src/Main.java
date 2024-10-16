/**
 * Основной класс для демонстрации работы с классами Student и Docent.
 */
public class Main {
    /**
     * Точка входа в программу.
     * Создает массивы студентов и доцентов, вызывает их методы с красивым выводом и иконками.
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {

        // Создание массива студентов
        Student[] students = new Student[6];
        students[0] = new Student("Vasiliy", 21, 178, "Year 3");
        students[1] = new Student("Ivan", 20, 180, "Year 2");
        students[2] = new Student("Maria", 22, 165, "Year 4");
        students[3] = new Student("Sergey", 19, 175, "Year 1");
        students[4] = new Student("Olga", 23, 170, "Year 5");
        students[5] = new Student("Dmitry", 21, 182, "Year 3");

        // Создание массива доцентов
        Docent[] docents = new Docent[3];
        docents[0] = new Docent("Alexandr Petrovich", 38, 172, "Kafedra OOP");
        docents[1] = new Docent("Elena Ivanovna", 45, 168, "Kafedra Math");
        docents[2] = new Docent("Sergey Alexandrovich", 50, 175, "Kafedra Physics");

        // Вывод информации о студентах с иконкой
        System.out.println("========================= Students " + "🎓" + " =========================\n");
        for (Student student : students) {
            student.sayHi();
            student.haveAParty();
            student.describePerson();
            System.out.println("----------------------------------------");
        }

        // Вывод информации о доцентах с иконкой
        System.out.println("\n========================= Docents 👨‍🏫 ========================\n");
        for (Docent docent : docents) {
            docent.sayHi();
            docent.makeStudentsSuffer();
            docent.describePerson();
            System.out.println("----------------------------------------");
        }
    }
}