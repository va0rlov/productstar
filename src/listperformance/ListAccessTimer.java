package listperformance;

import java.util.List;
import java.util.Random;

/**
 * Класс для замера времени доступа к элементам в списках.
 */
public class ListAccessTimer {
    private static final int TESTS = 1_000; // Количество тестов для доступа к элементам

    /**
     * Метод для замера времени доступа к элементам в ArrayList.
     *
     * @param arrayList список для тестирования
     * @return время доступа в наносекундах
     */
    public long measureArrayListAccessTime(List<Integer> arrayList) {
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < TESTS; i++) {
            int index = random.nextInt(arrayList.size());
            arrayList.get(index);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    /**
     * Метод для замера времени доступа к элементам в LinkedList.
     *
     * @param linkedList список для тестирования
     * @return время доступа в наносекундах
     */
    public long measureLinkedListAccessTime(List<Integer> linkedList) {
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < TESTS; i++) {
            int index = random.nextInt(linkedList.size());
            linkedList.get(index);
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
