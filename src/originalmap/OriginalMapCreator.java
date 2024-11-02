package originalmap;

import java.util.HashMap;

/**
 * Класс для создания и наполнения оригинального HashMap.
 */
public class OriginalMapCreator {

    /**
     * Метод для создания и наполнения HashMap.
     *
     * @return заполненный HashMap с Integer в качестве ключей и String в качестве значений
     */
    public HashMap<Integer, String> createOriginalMap() {
        HashMap<Integer, String> originalMap = new HashMap<>();
        originalMap.put(1, "One");
        originalMap.put(2, "Two");
        originalMap.put(3, "Three");
        return originalMap;
    }
}
