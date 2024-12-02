package service;

import model.StockData;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

    public static List<StockData> parseData(String data) {
        List<StockData> stockDataList = new ArrayList<>();
        String[] lines = data.split("\n");
        for (int i = 1; i < lines.length; i++) { // Пропускаем заголовок
            String[] parts = lines[i].split(",");
            if (parts.length == 6) {
                String date = parts[0];
                double open = Double.parseDouble(parts[1]);
                double high = Double.parseDouble(parts[2]);
                double low = Double.parseDouble(parts[3]);
                double close = Double.parseDouble(parts[4]);
                int volume = Integer.parseInt(parts[5]);
                stockDataList.add(new StockData(date, open, high, low, close, volume));
            }
        }
        return stockDataList;
    }
}