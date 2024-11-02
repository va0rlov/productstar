package listgenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Класс для генерации списка с дубликатами.
 */
public class ListGenerator {
    /**
     * Метод для генерации списка из заданного количества уникальных строк и общего количества элементов.
     *
     * @param uniqueCount количество уникальных строк
     * @param totalCount общее количество элементов в списке
     * @return сгенерированный ArrayList строк
     */
    public static ArrayList<String> generateListWithDuplicates(int uniqueCount, int totalCount) {
        HashSet<String> uniqueStrings = new HashSet<>();
        Random random = new Random();

        // Генерируем уникальные строки
        while (uniqueStrings.size() < uniqueCount) {
            uniqueStrings.add("Юнит_" + random.nextInt(1000)); // Генерируем строки вида "Юнит_X"
        }

        ArrayList<String> stringList = new ArrayList<>(uniqueStrings);

        // Добавляем дубликаты, чтобы получить общее количество элементов
        while (stringList.size() < totalCount) {
            stringList.add(stringList.get(random.nextInt(uniqueCount))); // Добавляем случайный элемент из уникальных
        }

        // Перемешиваем список для случайного порядка
        java.util.Collections.shuffle(stringList);

        return stringList;
    }
}
