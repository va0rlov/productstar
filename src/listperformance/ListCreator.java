package listperformance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс для создания ArrayList и LinkedList.
 */
public class ListCreator {
    private static final int SIZE = 1_000_000; // Размер списка

    /**
     * Метод для создания и инициализации ArrayList и LinkedList.
     *
     * @return массив, содержащий оба списка
     */
    public List<Integer>[] createLists() {
        List<Integer>[] lists = new List[2];
        lists[0] = new ArrayList<>(SIZE);
        lists[1] = new LinkedList<>();
        return lists;
    }
}
