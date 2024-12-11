package org.example.service;

import org.springframework.stereotype.Service;
import org.example.model.Distance;
import org.example.model.Gender;
import org.example.model.Person;
import org.example.model.Result;

import java.time.Duration;

@Service
public class ResultParser {

    private static final String SEPARATOR = ",";

    /**
     * Распарсить строку из файла в {@link Result}.
     * <p>
     * Результаты хранятся в формате: Иван Иванов, М, 10 км, 55:20
     */
    public Result parseResult(String line) {
        var resultParts = line.split(SEPARATOR);

        var name = resultParts[0];
        var gender = Gender.of(resultParts[1]);
        var distance = Distance.of(resultParts[2]);
        var time = parseTime(resultParts[3]);

        var person = new Person(name, gender);
        return new Result(person, distance, time);
    }

    /**
     * Распарсить строку MM:SS в {@link Duration}.
     * <p>
     * Предполагаем, что все спортсмены уложились в один час в целях упрощения парсинга.
     */
    private Duration parseTime(String time) {
        var timeParts = time.split(":");

        // Минуты умножаем на 60 и добавляем секунды
        var totalSecond = Integer.parseInt(timeParts[0]) * 60 + Integer.parseInt(timeParts[1]);
        return Duration.ofSeconds(totalSecond);
    }
}
