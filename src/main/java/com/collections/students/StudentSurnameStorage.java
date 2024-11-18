package com.collections.students;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StudentSurnameStorage {
    private static final TreeMap<String, Set<Long>> surnamesTreeMap = new TreeMap<>();

    public void studentCreated(Long id, String surname) {
        Set<Long> existingIds = surnamesTreeMap.getOrDefault(surname, new HashSet<>());
        existingIds.add(id);
        surnamesTreeMap.put(surname, existingIds);
    }

    public void studentDeleted(Long id, String surname) {
        surnamesTreeMap.get(surname).remove(id);
    }

    public void studentUpdated(Long id, String oldSurname, String newSurname) {
        studentDeleted(id, oldSurname);
        studentCreated(id, newSurname);
    }

    public Set<Long> getStudentIdsBySurname(String surname) {
        return surnamesTreeMap.get(surname);
    }

    public TreeMap<String, Set<Long>> getSurnamesTreeMap() {
        return new TreeMap<>(surnamesTreeMap);
    }

    public Set<Long> getStudentBySurnamesLessOrEqualsThan(String surname) {
        return surnamesTreeMap.headMap(surname, true).values().stream().flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    public Set<Long> getStudentBySurnamesBetween(String surnameFrom, String surnameTo) {
        return surnamesTreeMap.subMap(surnameFrom, true, surnameTo, true).values().stream().flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    public static void printAll() {
        surnamesTreeMap.forEach((surname, ids) -> {
            System.out.println("Фамилия: " + surname);
            ids.forEach(id -> System.out.println("  ID: " + id));
        });
    }
}