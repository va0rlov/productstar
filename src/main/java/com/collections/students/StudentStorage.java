package com.collections.students;

import java.util.*;
import java.util.stream.Collectors;

public class StudentStorage {
    private static final Map<Long, Student> studentStorageMap = new HashMap<>();
    private final StudentSurnameStorage studentSurnameStorage = new StudentSurnameStorage();
    private Long currentId = 0L;

    public void createStudent(Student student) {
        Long nextId = getNextId();
        studentStorageMap.put(nextId, student);
        studentSurnameStorage.studentCreated(nextId, student.getSurname());
    }

    public void updateStudent(Long id, Student student) {
        if (studentStorageMap.containsKey(id)) {
            String newSurname = student.getSurname();
            String oldSurname = studentStorageMap.get(id).getSurname();
            studentSurnameStorage.studentUpdated(id, oldSurname, newSurname);
            studentStorageMap.put(id, student);
        }
    }

    public void deleteStudent(Long id) {
        Student removed = studentStorageMap.remove(id);
        if (removed != null) {
            String surname = removed.getSurname();
            studentSurnameStorage.studentDeleted(id, surname);
        }
    }

    public void search(String surname) {
        List<String> data = Arrays.stream(surname.split(",")).sorted().toList();
        int dataLength = data.size();

        try {
            switch (dataLength) {
                case 0 -> searchAllStudents();
                case 1 -> searchStudentsBySurname(data.get(0));
                case 2 -> searchStudentsBySurnamesRange(data.get(0), data.get(1));
                default -> System.out.println("Введенные данные не могут быть интерпретированы");
            }
        } catch (Exception e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }
    }

    private void searchAllStudents() {
        Set<Long> allStudentIds = studentSurnameStorage.getSurnamesTreeMap().values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
        printSet(allStudentIds, "всех студентов");
    }

    private void searchStudentsBySurname(String surname) {
        Set<Long> studentsWithTheSameSurname = studentSurnameStorage.getStudentIdsBySurname(surname);
        printSet(studentsWithTheSameSurname, "студентов с фамилией \"" + surname + "\"");
    }

    private void searchStudentsBySurnamesRange(String surnameFrom, String surnameTo) {
        Set<Long> studentsInTheSurnamesRange = studentSurnameStorage.getStudentBySurnamesBetween(surnameFrom, surnameTo);
        printSet(studentsInTheSurnamesRange, "студентов с фамилиями в диапазоне от \"" + surnameFrom + "\" до \"" + surnameTo + "\"");
    }

    public Long getNextId() {
        currentId = currentId + 1;
        return currentId;
    }

    public static void printAll() {
        System.out.println(studentStorageMap);
    }

    public void printMap(Map<String, Long> data) {
        data.forEach((key, value) -> System.out.println(key + " - " + value));
    }

    public void printSet(Set<Long> data, String description) {
        if (data == null || data.isEmpty()) {
            System.out.println("Студентов по запросу \"" + description + "\" не найдено");
        } else {
            data.forEach(e -> System.out.println(e + " - " + studentStorageMap.get(e)));
        }
    }

    public Map<String, Long> getCountByCourse() {
        return studentStorageMap.values().stream().collect(Collectors.toMap(Student::getCourse, student -> 1L, Long::sum
                ));
    }

    public Map<String, Long> getCountByCity() {
        return studentStorageMap.values().stream().collect(Collectors.toMap(Student::getCity, student -> 1L, Long::sum
                ));
    }

    public Map<Long, Student> getAll() {
        return new HashMap<>(studentStorageMap);
    }
}