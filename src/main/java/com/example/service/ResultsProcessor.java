package com.example.service;

import com.example.util.FileParser;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("ResultsProcessor")
public class ResultsProcessor {

    // Конструктор по умолчанию
    public ResultsProcessor() {
        this(1, 2, 3); // Устанавливаем значения по умолчанию
    }

    private final int group1Points;
    private final int group2Points;
    private final int group3Points;

    public ResultsProcessor(int group1Points, int group2Points, int group3Points) {
        this.group1Points = group1Points;
        this.group2Points = group2Points;
        this.group3Points = group3Points;
    }

    public int calculateTotalPoints(String keysFilePath, String answersFilePath) {
        Map<Integer, String> keys = FileParser.parseFile(keysFilePath);
        Map<Integer, String> answers = FileParser.parseFile(answersFilePath);

        // Проверяем, что количество ответов совпадает
        if (keys.size() != answers.size()) {
            throw new IllegalArgumentException("Number of answers does not match the number of keys.");
        }

        int totalPoints = 0;

        for (Map.Entry<Integer, String> entry : answers.entrySet()) {
            int questionNumber = entry.getKey();
            String answer = entry.getValue();
            String correctAnswer = keys.get(questionNumber);

            if (answer.equalsIgnoreCase(correctAnswer)) {
                if (questionNumber >= 1 && questionNumber <= 4) {
                    totalPoints += group1Points;
                } else if (questionNumber >= 5 && questionNumber <= 8) {
                    totalPoints += group2Points;
                } else if (questionNumber >= 9 && questionNumber <= 10) {
                    totalPoints += group3Points;
                }
            }
        }

        return totalPoints;
    }
}