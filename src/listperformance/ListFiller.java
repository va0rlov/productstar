package listperformance;

import java.util.List;
import java.util.Random;

/**
 * Класс для заполнения списков случайными элементами.
 */
public class ListFiller {
    private static final int SIZE = 1_000_000; // Размер списка

    /**
     * Метод для заполнения списков случайными элементами.
     *
     * @param lists массив списков для заполнения
     */
    public void fillLists(List<Integer>[] lists) {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            int randomValue = random.nextInt();
            lists[0].add(randomValue); // Заполняем ArrayList
            lists[1].add(randomValue); // Заполняем LinkedList
        }
    }
}
