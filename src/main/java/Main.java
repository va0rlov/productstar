

import model.StockData;
import service.DataLoader;
import service.DataParser;
import service.StockAnalyzer;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    /**
     * Entry point of the program.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        try {
            // Download the data from the URL
            String url = "https://raw.githubusercontent.com/productstar-team/javaTwo/master/resources/monthly_IBM.csv";
            String data = DataLoader.loadDataFromUrl(url);

            // Parse the data
            List<StockData> stockDataList = DataParser.parseData(data);

            // Find the stock data points with the maximum and minimum close values.
            StockAnalyzer.findMaxMinClose(stockDataList);
        } catch (Exception e) {
            // Log the error
            logger.log(Level.SEVERE, "An error occurred", e);
        }
    }
}