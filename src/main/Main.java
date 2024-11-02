package main;

import listgenerator.ListGenerator;
import listutils.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Генерируем список из 100 элементов, 35 из которых уникальные
        ArrayList<String> stringList = ListGenerator.generateListWithDuplicates(15, 50);

        // Выводим исходный список
        System.out.println("\nИсходный список: " + stringList);

        // Удаляем дубликаты
        List<String> uniqueList = ListUtils.removeDuplicates(stringList);

        // Выводим список без дубликатов
        System.out.println("\nСписок без дубликатов: " + uniqueList);

        // Создаем промежуточный список с количеством вхождений
        Map<String, Integer> occurrencesMap = ListUtils.countOccurrences(stringList);

        // Выводим промежуточный список
        System.out.println("\nКоличество вхождений: " + occurrencesMap);
    }
}
