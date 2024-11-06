package com.rollingaverage;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс RollingAverage предоставляет метод для вычисления скользящего среднего значения
 * для всех подмассивов длиной k в заданном массиве целых чисел.
 */
public class RollingAverage {

    /**
     * Вычисляет скользящее среднее значение для всех подмассивов длиной k в заданном массиве.
     *
     * @param arr Входной массив целых чисел.
     * @param k Длина подмассивов, для которых вычисляется среднее значение.
     * @return Список средних значений для всех подмассивов длиной k.
     */
    public static List<Double> getRollingAverage(ArrayList<Integer> arr, int k) {
        // Проверка на корректность входных данных
        if (arr == null || arr.isEmpty() || k <= 0 || k > arr.size()) {
            throw new IllegalArgumentException("Некорректные входные данные: массив не должен быть пустым, " +
                    "k должно быть больше 0 и не превышать длину массива.");
        }

        List<Double> result = new ArrayList<>();

        // Инициализация суммы первого окна
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr.get(i);
        }
        result.add(sum / k);

        // Проход по оставшимся элементам массива
        for (int i = k; i < arr.size(); i++) {
            sum += arr.get(i) - arr.get(i - k); // Обновляем сумму, вычитая элемент, который выходит из окна, и добавляя новый элемент
            result.add(sum / k);
        }

        return result;
    }
}