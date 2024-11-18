package com.collections.students.commands;

import com.collections.students.model.Student;
import com.collections.students.enums.Action;
import com.collections.students.storage.StudentStorage;

import java.util.Map;

public class StudentCommandHandler {

    private final StudentStorage studentStorage = new StudentStorage();

    public void processCommand(Command command) {
        Action action = command.getAction();

        switch (action) {
            case CREATE -> processCreateCommand(command);
            case UPDATE -> processUpdateCommand(command);
            case DELETE -> processDeleteCommand(command);
            case STATS_BY_COURSE -> processStatsByCourseCommand(command);
            case STATS_BY_CITY -> processStatsByCityCommand(command);
            case SEARCH -> processSearchCommand(command);
            default -> System.out.println("Действие " + action + " не поддерживается");
        }
    }

    private void processCreateCommand(Command command) {
        String data = command.getData();
        String[] dataArray = data.split(",");
        if (dataArray.length != 5) {
            System.out.println("Некорректный формат данных. Повторите ввод.");
            return;
        }

        Student student = new Student();
        student.setSurname(dataArray[0].trim());
        student.setName(dataArray[1].trim());
        student.setCourse(dataArray[2].trim());
        student.setCity(dataArray[3].trim());

        try {
            student.setAge(Integer.valueOf(dataArray[4].trim()));
        } catch (NumberFormatException e) {
            System.out.println("Некорректный возраст. Повторите ввод.");
            return;
        }

        studentStorage.createStudent(student);
        StudentStorage.printAll();
    }

    private void processUpdateCommand(Command command) {
        String data = command.getData();
        String[] dataArray = data.split(",");
        if (dataArray.length != 6) {
            System.out.println("Некорректный формат данных. Повторите ввод.");
            return;
        }

        Long id;
        try {
            id = Long.valueOf(dataArray[0].trim());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный идентификатор. Повторите ввод.");
            return;
        }

        if (!studentStorage.getAll().containsKey(id)) {
            System.out.println("Студент с данным идентификатором отсутствует. Повторите ввод.");
            StudentStorage.printAll();
            return;
        }

        Student student = new Student();
        student.setSurname(dataArray[1].trim());
        student.setName(dataArray[2].trim());
        student.setCourse(dataArray[3].trim());
        student.setCity(dataArray[4].trim());

        try {
            student.setAge(Integer.valueOf(dataArray[5].trim()));
        } catch (NumberFormatException e) {
            System.out.println("Некорректный возраст. Повторите ввод.");
            return;
        }

        studentStorage.updateStudent(id, student);
        StudentStorage.printAll();
    }

    private void processDeleteCommand(Command command) {
        String data = command.getData();
        Long id;
        try {
            id = Long.valueOf(data.trim());
        } catch (NumberFormatException e) {
            System.out.println("Некорректный идентификатор. Повторите ввод.");
            return;
        }

        if (!studentStorage.getAll().containsKey(id)) {
            System.out.println("Студент с данным идентификатором отсутствует. Повторите ввод.");
            StudentStorage.printAll();
            return;
        }

        studentStorage.deleteStudent(id);
        StudentStorage.printAll();
    }

    private void processSearchCommand(Command command) {
        String surname = command.getData();
        studentStorage.search(surname);
    }

    private void processStatsByCourseCommand(Command command) {
        Map<String, Long> data = studentStorage.getCountByCourse();
        studentStorage.printMap(data);
    }

    private void processStatsByCityCommand(Command command) {
        Map<String, Long> data = studentStorage.getCountByCity();
        studentStorage.printMap(data);
    }

    private boolean isContainsKey(Long id) {
        boolean res = studentStorage.getAll().containsKey(id);
        if (!res) {
            System.out.println("Студент с данным идентификатором отсутствует, повторите ввод");
            StudentStorage.printAll();
        }
        return !res;
    }
}