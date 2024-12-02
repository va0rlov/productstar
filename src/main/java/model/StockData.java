package model;

public class StockData {
    private final String date;
    private final double close;

    public StockData(String date, double open, double high, double low, double close, int volume) {
        this.date = date;
        this.close = close;
    }

    public String getDate() {
        return date;
    }

    public double getClose() {
        return close;
    }

    @Override
    public String toString() {
        return "StockData{" +
                "date='" + date + '\'' +
                ", close=" + close +
                '}';
    }
}