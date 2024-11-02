package listutils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Утилитный класс для работы со списками.
 */
public class ListUtils {
    /**
     * Метод для удаления дубликатов из ArrayList.
     *
     * @param list исходный ArrayList строк
     * @return новый ArrayList без дубликатов
     */
    public static List<String> removeDuplicates(ArrayList<String> list) {
        // Используем HashSet для хранения уникальных элементов
        HashSet<String> set = new HashSet<>(list);

        // Возвращаем уникальные элементы обратно в ArrayList
        return new ArrayList<>(set);
    }

    /**
     * Метод для подсчета количества вхождений элементов в списке.
     *
     * @param list исходный ArrayList строк
     * @return HashMap с элементами и их количеством вхождений
     */
    public static Map<String, Integer> countOccurrences(ArrayList<String> list) {
        Map<String, Integer> occurrencesMap = new HashMap<>();

        for (String item : list) {
            occurrencesMap.put(item, occurrencesMap.getOrDefault(item, 0) + 1);
        }

        return occurrencesMap;
    }
}
