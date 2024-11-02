package main;

import originalmap.OriginalMapCreator;
import swappedmap.SwappedMapCreator;

import java.util.HashMap;

/**
 * Главный класс для запуска программы.
 */
public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр класса для создания оригинального HashMap
        OriginalMapCreator originalMapCreator = new OriginalMapCreator();
        HashMap<Integer, String> originalMap = originalMapCreator.createOriginalMap();

        // Создаем экземпляр класса для создания обратного HashMap
        SwappedMapCreator swappedMapCreator = new SwappedMapCreator();
        HashMap<String, Integer> swappedMap = swappedMapCreator.swapKeysAndValues(originalMap);

        // Выводим результат на экран
        System.out.println("originalMap: " + originalMap);
        System.out.println("swappedMap: " + swappedMap);
    }
}
