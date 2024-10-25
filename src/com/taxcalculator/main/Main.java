package com.taxcalculator.main;

import com.taxcalculator.service.TaxCalculatorService;

import java.util.Map;

/**
 * Основной класс программы для расчета налога на основе диапазонов цен.
 */
public class Main {

    /**
     * Точка входа в программу.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        // Пример входных данных
        String[] prices = {"50", "150", "500", "1500", "5000", "15000", "20000"};

        // Создание сервиса для расчета налога
        TaxCalculatorService taxCalculatorService = new TaxCalculatorService();

        // Расчет налога
        Map<Integer, Double> taxMap = taxCalculatorService.calculateTax(prices);

        // Вывод результатов
        for (Map.Entry<Integer, Double> entry : taxMap.entrySet()) {
            System.out.println("Диапазон " + entry.getKey() + ": Налог = " + entry.getValue() + " у.е.");
        }
    }
}