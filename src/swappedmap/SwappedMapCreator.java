package swappedmap;

import java.util.HashMap;

/**
 * Класс для создания обратного HashMap.
 */
public class SwappedMapCreator {

    /**
     * Метод для обмена ключей и значений в HashMap.
     *
     * @param map исходный HashMap, где ключи - Integer, а значения - String
     * @return новый HashMap, где ключи - String, а значения - Integer
     */
    public HashMap<String, Integer> swapKeysAndValues(HashMap<Integer, String> map) {
        HashMap<String, Integer> swappedMap = new HashMap<>();

        for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
            swappedMap.put(entry.getValue(), entry.getKey());
        }

        return swappedMap;
    }
}
