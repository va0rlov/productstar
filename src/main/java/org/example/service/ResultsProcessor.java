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
        this.results = results;
    }

    /**
     * Получить список самых быстрых результатов для заданного пола и дистанции.
     *
     * @param gender пол участников.
     * @param distance дистанция участия.
     * @param limit количество результатов для возврата.
     * @return список самых быстрых результатов.
     */
    public List<Result> getFastest(Gender gender, Distance distance, int limit) {
        // Фильтруем результаты по дистанции и полу
        return results.stream()
                .filter(result -> result.hasDistance(distance) && result.hasGender(gender))
                .sorted(Comparator.comparing(Result::time))
                .limit(limit)
                .collect(Collectors.toList());
    }
}
