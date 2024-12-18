package com.example.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ResultsProcessorTest {

    @InjectMocks
    private ResultsProcessor resultsProcessor;

    @Before
    public void setUp() {
        // Создаем экземпляр ResultsProcessor с нужными параметрами
        resultsProcessor = new ResultsProcessor(1, 2, 3);
    }

    @Test
    public void testCalculateTotalPoints() {
        String keysFilePath = "src/test/resources/test_keys.txt";
        String answersFilePath = "src/test/resources/test_answers.txt";

        int totalPoints = resultsProcessor.calculateTotalPoints(keysFilePath, answersFilePath);
        assertEquals(18, totalPoints);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAnswer() {
        String keysFilePath = "src/test/resources/test_keys.txt";
        String answersFilePath = "src/test/resources/test_invalid_answers.txt";

        resultsProcessor.calculateTotalPoints(keysFilePath, answersFilePath);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMismatchedAnswers() {
        String keysFilePath = "src/test/resources/test_keys.txt";
        String answersFilePath = "src/test/resources/test_mismatched_answers.txt";

        resultsProcessor.calculateTotalPoints(keysFilePath, answersFilePath);
    }
}