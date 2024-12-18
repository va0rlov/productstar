package org.example.service;

import org.example.model.Distance;
import org.example.model.Gender;
import org.example.model.Result;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultsProcessor {

    private final Collection<Result> results;

    public ResultsProcessor(Collection<Result> results) {
        // Проверка на пустую коллекцию
        if (results == null || results.isEmpty()) {
            throw new IllegalArgumentException("Results collection cannot be null or empty");
        }
        this.results = results;
    }

    /**
     * Позволяет определить N самых быстрых мужчин или женщин на дистанции 5 или 10 км.
     * </p>
     * Пример запроса - найти 3 самых быстрых женщин на дистанции 10 км.
     */
    public List<Result> getFastest(Gender gender, Distance distance, int limit) {
        // Проверка на корректное значение limit
        if (limit <= 0) {
            throw new IllegalArgumentException("Limit must be greater than zero");
        }

        return results.stream()
                .filter(result -> result.hasDistance(distance) && result.hasGender(gender))
                .sorted(Comparator.comparing(Result::time))
                .limit(limit)
                .collect(Collectors.toList());
    }
}