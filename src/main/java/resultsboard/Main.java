package resultsboard;

import resultsboard.datainitializer.DataInitializer;
import resultsboard.resultboard.ResultsBoard;
import resultsboard.resultprinter.ResultPrinter;

/**
 * Главный класс приложения, который инициализирует данные и выводит результаты.
 */
public class Main {

    /**
     * Точка входа в программу.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        DataInitializer dataInitializer = new DataInitializer();
        ResultPrinter resultPrinter = new ResultPrinter();

        // Инициализируем данные
        ResultsBoard resultsBoard = dataInitializer.initializeData();

        // Выводим результаты
        resultPrinter.printResults(resultsBoard);
    }
}