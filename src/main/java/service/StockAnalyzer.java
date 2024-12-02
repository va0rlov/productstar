package service;

import model.StockData;

import java.util.Comparator;
import java.util.List;

public class StockAnalyzer {

    /**
     * Find the stock data points with the maximum and minimum close values.
     *
     * @param stockDataList the list of stock data points
     */
    public static void findMaxMinClose(List<StockData> stockDataList) {
        // Find the maximum close using a stream
        StockData maxCloseData = stockDataList.stream()
                .max(Comparator.comparingDouble(StockData::getClose))
                .orElseThrow(() -> new RuntimeException("No data found"));

        // Find the minimum close using a stream
        StockData minCloseData = stockDataList.stream()
                .min(Comparator.comparingDouble(StockData::getClose))
                .orElseThrow(() -> new RuntimeException("No data found"));

        // Print the results
        System.out.println("Max Close: " + maxCloseData);
        System.out.println("Min Close: " + minCloseData);
    }
}