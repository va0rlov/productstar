package resultsboard.datainitializer;

import resultsboard.resultboard.ResultsBoard;
import resultsboard.studentscore.StudentScore;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс для инициализации данных и вызова методов ResultsBoard.
 */
public class DataInitializer {

    /**
     * Инициализирует данные и вызывает методы ResultsBoard.
     *
     * @return Объект ResultsBoard с заполненными данными.
     */
    public ResultsBoard initializeData() {
        ResultsBoard resultsBoard = new ResultsBoard();

        // Создаем список студентов с их оценками
        List<StudentScore> students = Stream.of(
                new StudentScore("Juan", 3.5f),
                new StudentScore("Sérgio", 5.0f),
                new StudentScore("Mariana", 4.1f),
                new StudentScore("Ana", 3.5f),
                new StudentScore("Alejandro", 2.8f),
                new StudentScore("Alexandros", 3.8f),
                new StudentScore("Sofia", 4.7f),
                new StudentScore("Lars", 3.6f),
                new StudentScore("Elina", 4.9f),
                new StudentScore("Erik", 4.3f),
                new StudentScore("Ingrid", 4.0f),
                new StudentScore("Tuomas", 3.7f),
                new StudentScore("Astrid", 4.6f),
                new StudentScore("Olav", 4.1f),
                new StudentScore("Dimitrios", 4.5f),
                new StudentScore("Antonio", 4.4f),
                new StudentScore("Matti", 4.2f),
                new StudentScore("Alejandra", 4.8f),
                new StudentScore("Sergio", 3.9f),
                new StudentScore("Marian", 4.5f)
        ).collect(Collectors.toList());

        // Добавляем всех студентов в ResultsBoard
        resultsBoard.addAllStudents(students);

        return resultsBoard;
    }
}