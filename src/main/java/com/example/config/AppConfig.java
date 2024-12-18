package com.example.config;

import com.example.service.ResultsProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${points.group1}")
    private int group1Points;

    @Value("${points.group2}")
    private int group2Points;

    @Value("${points.group3}")
    private int group3Points;

    @Bean
    public ResultsProcessor resultsProcessor() {
        return new ResultsProcessor(group1Points, group2Points, group3Points);
    }
}