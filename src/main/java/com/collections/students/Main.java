package com.collections.students;

import java.util.Scanner;

public class Main {

    private static final StudentCommandHandler STUDENT_COMMAND_HANDLER = new StudentCommandHandler();

    public static void main(String[] args) {
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
}