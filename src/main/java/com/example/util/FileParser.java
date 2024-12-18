package com.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileParser.class);

    private static final String VALID_ANSWERS = "АБВ"; // Допустимые ответы

    public static Map<Integer, String> parseFile(String filePath) {
        Map<Integer, String> result = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length == 2) {
                    int questionNumber = Integer.parseInt(parts[0].trim());
                    String answer = parts[1].trim().toUpperCase(); // Приводим к верхнему регистру

                    // Проверяем, что ответ допустим
                    if (!VALID_ANSWERS.contains(answer)) {
                        throw new IllegalArgumentException("Invalid answer: " + answer + " in file: " + filePath);
                    }

                    result.put(questionNumber, answer);
                }
            }
        } catch (IOException e) {
            LOGGER.error("Error parsing file", e);
        }
        return result;
    }
}