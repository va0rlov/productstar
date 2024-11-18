package com.collections.students;

import java.util.Scanner;

public class Main {

    private static final StudentCommandHandler STUDENT_COMMAND_HANDLER = new StudentCommandHandler();

    public static void main(String[] args) {
        initializeStudents();

        StudentStorage.printAll();
        StudentSurnameStorage.printAll();

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
            String code = scanner.nextLine();
            Integer actionCode = Integer.valueOf(code);
            Action action = Action.fromCode(actionCode);
            if (action.isRequireAdditionalData()) {
                String data = scanner.nextLine();
                return new Command(action, data);
            } else {
                return new Command(action);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка ввода: " + ex.getMessage());
            return new Command(Action.ERROR);
        }
    }

    private static void initializeStudents() {
        StudentStorage studentStorage = new StudentStorage();
        String[] surnames = {"Иванов", "Петров", "Сидоров", "Кузнецов", "Соколов", "Попов", "Лебедев", "Козлов", "Новиков", "Морозов"};
        String[] names = {"Иван", "Петр", "Алексей", "Дмитрий", "Сергей", "Андрей", "Николай", "Михаил", "Владимир", "Александр"};
        String[] courses = {"1", "2"};
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