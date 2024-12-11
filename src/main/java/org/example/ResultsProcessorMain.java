package org.example;

import org.example.config.ResultsProcessorConfig;
import org.example.model.Distance;
import org.example.model.Gender;
import org.example.model.Result;
import org.example.service.ResultsProcessor;
import org.example.service.ResultsReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;

public class ResultsProcessorMain {

    public static void main(String[] args) throws IOException {
        var applicationContext = new AnnotationConfigApplicationContext(ResultsProcessorConfig.class);

        var resultsReader = applicationContext.getBean(ResultsReader.class);
        var filePath = new ClassPathResource("results200.csv").getFile().toPath();
        var results = resultsReader.readFromFile(filePath);

        var resultsProcessor = new ResultsProcessor(results);

        // Мужчины на 10 км
        List<Result> fastestMen10Km = resultsProcessor.getFastest(Gender.MALE, Distance.TEN_KM, 3);
        // Мужчины на 5 км
        List<Result> fastestMen5Km = resultsProcessor.getFastest(Gender.MALE, Distance.FIVE_KM, 3);
        // Женщины на 10 км
        List<Result> fastestWomen10Km = resultsProcessor.getFastest(Gender.FEMALE, Distance.TEN_KM, 3);
        // Женщины на 5 км
        List<Result> fastestWomen5Km = resultsProcessor.getFastest(Gender.FEMALE, Distance.FIVE_KM, 3);

        printResults("Fastest Men on 10 km Distance", fastestMen10Km);
        printResults("Fastest Men on 5 km Distance", fastestMen5Km);
        printResults("Fastest Women on 10 km Distance", fastestWomen10Km);
        printResults("Fastest Women on 5 km Distance", fastestWomen5Km);
    }

    private static void printResults(String title, List<Result> results) {
        System.out.println("+--------------------------------------------------+");
        System.out.printf("| %-46s |%n", title);
        System.out.println("+--------------------------------------------------+");
        System.out.printf("| %-20s | %-10s | %-10s |%n", "Name", "Gender", "Time");
        System.out.println("+--------------------------------------------------+");

        for (Result result : results) {
            String time = String.format("%d:%02d", result.time().toMinutes(), result.time().toSecondsPart());
            System.out.printf("| %-20s | %-10s | %-10s |%n", result.person().name(), result.person().gender(), time);
        }

        System.out.println("+--------------------------------------------------+");
    }
}