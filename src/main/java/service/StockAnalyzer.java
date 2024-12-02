package service;

import model.StockData;

import java.util.Comparator;
import java.util.List;

public class StockAnalyzer {

    public static void findMaxMinClose(List<StockData> stockDataList) {
        StockData maxCloseData = stockDataList.stream()
                .max(Comparator.comparingDouble(StockData::getClose))
                .orElseThrow(() -> new RuntimeException("No data found"));

        StockData minCloseData = stockDataList.stream()
                .min(Comparator.comparingDouble(StockData::getClose))
                .orElseThrow(() -> new RuntimeException("No data found"));

        System.out.println("Max Close: " + maxCloseData);
        System.out.println("Min Close: " + minCloseData);
    }
}