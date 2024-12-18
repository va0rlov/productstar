package com.example;

import com.example.config.AppConfig;
import com.example.service.ResultsProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ResultsProcessor processor = context.getBean(ResultsProcessor.class);

        String keysFilePath = "src/main/resources/keys.txt";
        String answersFilePath = "src/main/resources/answers.txt";

        int totalPoints = processor.calculateTotalPoints(keysFilePath, answersFilePath);
        System.out.println("Total points: " + totalPoints);
    }
}