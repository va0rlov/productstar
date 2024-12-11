package org.example.model;

import java.util.Objects;
import java.util.stream.Stream;

public enum Distance {
    FIVE_KM("5 km"),
    TEN_KM("10 km");

    private final String code;

    Distance(String code) {
        this.code = code;
    }

    /**
     * Возвращает дистанцию по коду из протокола.
     * <p>
     * 5 км -> {@link Distance#FIVE_KM}
     * 10 км -> {@link Distance#TEN_KM}
     *
     * @param code код из протокола.
     * @return дистанция.
     * @throws IllegalArgumentException если дистанция не найдена.
     */
    public static Distance of(String code) {
        // Ищем дистанцию по коду
        return Stream.of(values())
                .filter(d -> Objects.equals(d.code, code)) // Фильтруем по совпадению кода
                .findFirst() // Находим первый элемент
                .orElseThrow(() -> new IllegalArgumentException("Неизвестная дистанция: " + code)); // Бросаем исключение, если не найдено
    }
}
