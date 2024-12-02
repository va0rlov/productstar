

import model.StockData;
import service.DataLoader;
import service.DataParser;
import service.StockAnalyzer;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            String url = "https://raw.githubusercontent.com/productstar-team/javaTwo/master/resources/monthly_IBM.csv";
            String data = DataLoader.loadDataFromUrl(url);
            List<StockData> stockDataList = DataParser.parseData(data);
            StockAnalyzer.findMaxMinClose(stockDataList);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred", e);
        }
    }
}