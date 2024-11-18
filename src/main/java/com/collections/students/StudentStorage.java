package com.collections.students;

import java.util.*;
import java.util.stream.Collectors;

public class StudentStorage {
    private Map<Long, Student> studentStorageMap = new HashMap<>();
    private StudentSurnameStorage studentSurnameStorage = new StudentSurnameStorage();
    private Long currentId = 0L;

    /**
     * Создание данных о студенте
     * @param student данные о студенте
     * @return сгенерированный уникальный идентификатор студента
     */
    public Long createStudent(Student student) {
        Long nextId = getNextId();
        studentStorageMap.put(nextId, student);
        studentSurnameStorage.studentCreated(nextId, student.getSurname());
        return nextId;
    }

    /**
     * Обновление данных о студенте
     * @param id идентификатор студента
     * @param student данные студента
     * @return true если данные были обновлены, false если студент не был найден
     */
    public boolean updateStudent(Long id, Student student) {
        if (!studentStorageMap.containsKey(id)) {
            return false;
        } else {
            String newSurname = student.getSurname();
            String oldSurname = studentStorageMap.get(id).getSurname();
            studentSurnameStorage.studentUpdated(id, oldSurname, newSurname);
            studentStorageMap.put(id, student);
            return true;
        }
    }

    /**
     * Удаление данных о студенте
     * @param id идентификатор студента
     * @return true если студент был удален, false если студент не был найден по идентификатору
     */
    public boolean deleteStudent(Long id) {
        Student removed = studentStorageMap.remove(id);
        if (removed != null) {
            String surname = removed.getSurname();
            studentSurnameStorage.studentDeleted(id, surname);
        }
        return removed != null;
    }

    public void searchWorkShop(String surname) {
        Set<Long> students = studentSurnameStorage.getStudentBySurnamesLessOrEqualsThan(surname);
        for (Long studentId : students) {
            Student student = studentStorageMap.get(studentId);
            System.out.println(student);
        }
    }

    public void search(String surname) {
        List<String> data = Arrays.stream(surname.split(",")).sorted().toList();
        Integer dataLength = 0;
        if (surname.replaceAll(" ", "") != "") {
            dataLength = data.size();
        }

        try {
            switch (dataLength) {
                case 0 -> {
                    Set<Long> allStudentIds = studentSurnameStorage.getSurnamesTreeMap()
                            .values()
                            .stream()
                            .flatMap(students -> students.stream())
                            .collect(Collectors.toSet());
                    printSet(allStudentIds, surname);
                    break;
                }
                case 1 -> {
                    Set<Long> studentsWithTheSameSurname = studentSurnameStorage.getStudentIdsBySurname(data.get(0));
                    printSet(studentsWithTheSameSurname, surname);
                    break;
                }
                case 2 -> {
                    Set<Long> studentsInTheSurnamesRange = studentSurnameStorage
                            .getStudentBySurnamesBetween(data.get(0), data.get(1));
                    printSet(studentsInTheSurnamesRange, surname);
                    break;
                }
                default -> {
                    System.out.println("Введенные данные не могут быть интерпретированы");
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }
    }

    public Long getNextId() {
        currentId = currentId + 1;
        return currentId;
    }

    public void printAll() {
        System.out.println(studentStorageMap);
    }

    public void printMap(Map<String, Long> data) {
        data.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + " - " + e.getValue());
        });
    }

    public void printSet(Set<Long> data, String surname) {
        if (data == null) {
            System.out.println("Студенов по фамилии \"" + surname + "\" не найдено");
        }
        data.stream().forEach(e -> {
            System.out.println(e + " - " + studentStorageMap.get(e));
        });
    }

    public Map<String, Long> getCountByCourseOld() {
        Map<String, Long> res = new HashMap<>();
        for (Student student : studentStorageMap.values()) {
            String key = student.getCourse();
            Long count = res.getOrDefault(key, 0L);
            count++;
            res.put(key, count);
        }
        return res;
    }

    public Map<String, Long> getCountByCourse() {
        Map<String, Long> res = studentStorageMap.values().stream()
                .collect(Collectors.toMap(
                        student -> student.getCourse(),
                        student -> 1L,
                        (count1, count2) -> count1 + count2
                ));
        return res;
    }

    public Map<String, Long> getCountByCity() {
        Map<String, Long> res = studentStorageMap.values().stream()
                .collect(Collectors.toMap(
                        student -> student.getCity(),
                        student -> 1L,
                        (count1, count2) -> count1 + count2
                ));
        return res;
    }

    public Map<Long, Student> getAll() {
        return new HashMap(studentStorageMap);
    }
}
