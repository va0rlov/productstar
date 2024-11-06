package com.rollingaverage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Основной класс для запуска программы и демонстрации вычисления скользящего среднего.
 */
public class Main {

    /**
     * Точка входа в программу.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        // Создаем массив из 100 случайных целых чисел от 1 до 9
        ArrayList<Integer> arr = generateRandomArray(100, 1, 9);

        int k = 5; // Пример длины окна

        List<Double> res = RollingAverage.getRollingAverage(arr, k);

        // Выводим первые 10 элементов результата для демонстрации
        System.out.println("Первые 10 элементов скользящего среднего:");
        for (int i = 0; i < 10; i++) {
            System.out.println(res.get(i));
        }
    }

    /**
     * Генерирует массив случайных целых чисел в заданном диапазоне.
     *
     * @param size Размер массива.
     * @param min Минимальное значение элемента массива.
     * @param max Максимальное значение элемента массива.
     * @return Массив случайных целых чисел.
     */
    private static ArrayList<Integer> generateRandomArray(int size, int min, int max) {
        ArrayList<Integer> arr = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr.add(random.nextInt(max - min + 1) + min); // Генерируем случайное число в диапазоне от min до max
        }
        return arr;
    }
}