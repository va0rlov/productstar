package com.rollingaverage;

import java.util.ArrayList;
import java.util.List;

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
        // Переменные для аргументов функций
        int arraySize = 25; // Размер массива
        int minValue = 1;   // Минимальное значение элемента массива
        int maxValue = 9;   // Максимальное значение элемента массива
        int windowSize = 5; // Длина окна для вычисления скользящего среднего

        // Создаем массив из 25 случайных целых чисел от 1 до 9
        ArrayList<Integer> arr = ArrayGenerator.generateRandomArray(arraySize, minValue, maxValue);

        // Вывод примера тест кейса
        System.out.println("\nМассив случайных цифр");
        System.out.println();
        System.out.println("arr = " + arr + ", k = " + windowSize);
        System.out.println();

        // Вычисление скользящего среднего
        List<Double> res = RollingAverage.getRollingAverage(arr, windowSize);

        // Вывод результата
        System.out.println("Получаем");
        System.out.println();
        System.out.println("res = " + res);
    }
}