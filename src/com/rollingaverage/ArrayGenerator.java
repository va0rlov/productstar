package com.rollingaverage;

import java.util.ArrayList;
import java.util.Random;

/**
 * Класс ArrayGenerator предоставляет метод для генерации массива случайных целых чисел в заданном диапазоне.
 */
public class ArrayGenerator {

    /**
     * Генерирует массив случайных целых чисел в заданном диапазоне.
     *
     * @param size Размер массива.
     * @param min Минимальное значение элемента массива.
     * @param max Максимальное значение элемента массива.
     * @return Массив случайных целых чисел.
     */
    public static ArrayList<Integer> generateRandomArray(int size, int min, int max) {
        ArrayList<Integer> arr = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr.add(random.nextInt(max - min + 1) + min); // Генерируем случайное число в диапазоне от min до max
        }
        return arr;
    }
}