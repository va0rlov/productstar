package com.taxcalculator.service;

import com.taxcalculator.model.PriceRange;

import java.util.HashMap;
import java.util.Map;

/**
 * Сервис для расчета налога на основе диапазонов цен.
 */
public class TaxCalculatorService {

    private final Map<Integer, PriceRange> priceRanges;

    /**
     * Конструктор для создания объекта TaxCalculatorService.
     * Инициализирует диапазоны цен и соответствующие налоги.
     */
    public TaxCalculatorService() {
        priceRanges = new HashMap<>();
        priceRanges.put(1, new PriceRange(0, 100, 0.10));
        priceRanges.put(2, new PriceRange(100, 1000, 0.20));
        priceRanges.put(3, new PriceRange(1000, 10000, 0.30));
    }

    /**
     * Рассчитывает налог для заданного массива ценников.
     *
     * @param prices Массив строк, содержащих ценники.
     * @return Карта с диапазонами и соответствующими налогами.
     */
    public Map<Integer, Double> calculateTax(String[] prices) {
        Map<Integer, Double> taxMap = new HashMap<>();

        for (String priceStr : prices) {
            // Проверка на соответствие регулярному выражению
            if (!priceStr.matches("\\d+(\\.\\d+)?")) {
                System.out.println("Неверный формат цены: " + priceStr);
                continue;
            }

            double price = Double.parseDouble(priceStr);

            // Проверка на диапазон
            if (price > 10000) {
                System.out.println("Цена " + price + " больше 10000 и не будет обработана.");
                continue;
            }

            // Расчет налога
            for (Map.Entry<Integer, PriceRange> entry : priceRanges.entrySet()) {
                PriceRange range = entry.getValue();
                if (range.isInRange(price)) {
                    double tax = price * range.getTaxRate();
                    taxMap.put(entry.getKey(), taxMap.getOrDefault(entry.getKey(), 0.0) + tax);
                    break;
                }
            }
        }

        return taxMap;
    }
}