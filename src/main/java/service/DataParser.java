package service;

import model.StockData;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

    /**
     * Method parses the string data and converts it to a list of objects StockData.
     * The string data must contain a header and a list of values separated by commas.
     * Each string in the list must contain 6 values: date, open, high, low, close, volume.
     * The order of the values must match the order in the header.
     * The method throws a RuntimeException if the data is invalid.
     *
     * @param data string data
     * @return list of objects StockData
     */
    public static List<StockData> parseData(String data) {
        List<StockData> stockDataList = new ArrayList<>();
        String[] lines = data.split("\n");
        for (int i = 1; i < lines.length; i++) { // Skip the header
            String[] parts = lines[i].split(",");
            if (parts.length != 6) {
                throw new RuntimeException("Invalid data format");
            }
            String date = parts[0];
            double open;
            double high;
            double low;
            double close;
            int volume;
            try {
                open = Double.parseDouble(parts[1]);
                high = Double.parseDouble(parts[2]);
                low = Double.parseDouble(parts[3]);
                close = Double.parseDouble(parts[4]);
                volume = Integer.parseInt(parts[5]);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid data format", e);
            }
            stockDataList.add(new StockData(date, open, high, low, close, volume));
        }
        return stockDataList;
    }
}