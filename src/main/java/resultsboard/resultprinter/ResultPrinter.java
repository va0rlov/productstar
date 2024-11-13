package resultsboard.resultprinter;

import resultsboard.ResultsBoard;
import resultsboard.StudentScore;

import java.util.List;

/**
 * Класс для вывода результатов.
 */
public class ResultPrinter {

    /**
     * Выводит результаты ResultsBoard и топ-3 студентов с иконками для первых трех мест и средним баллом.
     *
     * @param resultsBoard Объект ResultsBoard с заполненными данными.
     */
    public void printResults(ResultsBoard resultsBoard) {
        // Получаем топ-3 студентов
        List<StudentScore> top3 = resultsBoard.top3();

        // Выводим результаты
        System.out.println(resultsBoard);
        System.out.println("\nTop 3 Students:");

        // Выводим первое место с иконкой 🏆 и средним баллом
        if (!top3.isEmpty()) {
            System.out.println("1st place: 🏆 " + top3.getFirst().name() + " (Score: " + top3.getFirst().score() + ")");
        }

        // Выводим второе место с иконкой 🥈 и средним баллом
        if (top3.size() > 1) {
            System.out.println("2nd place: 🥈 " + top3.get(1).name() + " (Score: " + top3.get(1).score() + ")");
        }

        // Выводим третье место с иконкой 🥉 и средним баллом
        if (top3.size() > 2) {
            System.out.println("3rd place: 🥉 " + top3.get(2).name() + " (Score: " + top3.get(2).score() + ")");
        }
    }
}