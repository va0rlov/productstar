package com.collections.students;

import java.util.Scanner;

public class Main {

    private static StudentCommandHandler STUDENT_COMMAND_HANDLER
            = new StudentCommandHandler();

    public static void main(String[] args) {
        while (true) {
            printMessage();
            Command command = readCommand();
            if (command.getAction() == Action.EXIT) {
                return;
            } else if (command.getAction() == Action.ERROR) {
                continue;
            } else {
                STUDENT_COMMAND_HANDLER.processCommand(command);
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
            System.out.println("Проблема обработки ввода");
            return new Command(Action.ERROR);
        }
    }

    private static void printMessage() {
        System.out.println("-------------------");
        System.out.println("0. Выход");
        System.out.println("1. Создание данных");
        System.out.println("2. Обновление данных");
        System.out.println("3. Удаление данных");
        System.out.println("4. Статистика по курсам");
        System.out.println("5. Статистика по городам");
        System.out.println("6. Поиск по фамилии");
        System.out.println("-------------------");
    }
}
