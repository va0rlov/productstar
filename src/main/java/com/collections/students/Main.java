package com.collections.students;

import java.util.Scanner;

public class Main {

    private static final StudentCommandHandler STUDENT_COMMAND_HANDLER = new StudentCommandHandler();

    public static void main(String[] args) {
        initializeStudents();
//        StudentStorage.printAll();
//        StudentSurnameStorage.printAll();
        while (true) {
            MessagePrinter.printMessage();
            Command command = readCommand();
            if (command.getAction() == Action.EXIT) {
                return;
            } else {
                if (command.getAction() != Action.ERROR) {
                    STUDENT_COMMAND_HANDLER.processCommand(command);
                }
            }
        }
    }

    public static Command readCommand() {
        Scanner scanner = new Scanner(System.in);
        try {
            String code = scanner.nextLine().trim();
            if (code.isEmpty()) {
                System.out.println("Код действия не может быть пустым. Повторите ввод.");
                return new Command(Action.ERROR);
            }
            Integer actionCode = Integer.valueOf(code);
            Action action = Action.fromCode(actionCode);
            if (action.isRequireAdditionalData()) {
                String data = scanner.nextLine().trim();
                if (data.isEmpty() && action != Action.SEARCH) {
                    System.out.println("Данные не могут быть пустыми. Повторите ввод.");
                    return new Command(Action.ERROR);
                }
                return new Command(action, data);
            } else {
                return new Command(action);
            }
        } catch (NumberFormatException ex) {
            System.out.println("Некорректный код действия. Повторите ввод.");
            return new Command(Action.ERROR);
        } catch (Exception ex) {
            System.out.println("Ошибка ввода: " + ex.getMessage());
            return new Command(Action.ERROR);
        }
    }

    private static void initializeStudents() {
        StudentStorage studentStorage = new StudentStorage();
        String[] surnames = {"Иванов", "Петров", "Сидоров", "Кузнецов", "Соколов", "Попов", "Лебедев", "Козлов", "Новиков", "Морозов"};
        String[] names = {"Иван", "Петр", "Алексей", "Дмитрий", "Сергей", "Андрей", "Николай", "Михаил", "Владимир", "Александр"};
        String[] courses = {"Программирование", "Психология"};
        String[] cities = {"Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Нижний Новгород"};

        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setSurname(surnames[i]);
            student.setName(names[i]);
            student.setCourse(courses[i % 2]);
            student.setCity(cities[i % 5]);
            student.setAge(20 + i);
            studentStorage.createStudent(student);
        }
    }
}