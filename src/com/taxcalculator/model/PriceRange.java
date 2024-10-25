package com.taxcalculator.model;

/**
 * Класс, представляющий диапазон цен и соответствующий налог.
 */
public class PriceRange {
    private final double minPrice;
    private final double maxPrice;
    private final double taxRate;

    /**
     * Конструктор для создания объекта PriceRange.
     *
     * @param minPrice Минимальная цена диапазона.
     * @param maxPrice Максимальная цена диапазона.
     * @param taxRate  Процент налога для данного диапазона.
     */
    public PriceRange(double minPrice, double maxPrice, double taxRate) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.taxRate = taxRate;
    }

    /**
     * Проверяет, попадает ли цена в данный диапазон.
     *
     * @param price Цена для проверки.
     * @return true, если цена попадает в диапазон, иначе false.
     */
    public boolean isInRange(double price) {
        return price > minPrice && price <= maxPrice;
    }

    /**
     * Возвращает процент налога для данного диапазона.
     *
     * @return Процент налога.
     */
    public double getTaxRate() {
        return taxRate;
    }
}