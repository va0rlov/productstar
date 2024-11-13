package resultsboard.datainitializer;

import org.junit.jupiter.api.Test;
import resultsboard.ResultsBoard;
import resultsboard.StudentScore;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Тестовый класс для DataInitializer.
 */
public class DataInitializerTest {

    /**
     * Тест для метода initializeData.
     */
    @Test
    public void testInitializeData() {
        DataInitializer dataInitializer = new DataInitializer();
        ResultsBoard resultsBoard = dataInitializer.initializeData();

        // Ожидаемый список студентов
        List<StudentScore> expectedStudents = List.of(
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
        );

        // Получаем список студентов из ResultsBoard
        List<StudentScore> actualStudents = resultsBoard.getStudents();

        // Проверяем, что списки студентов совпадают, игнорируя порядок
        assertTrue(actualStudents.containsAll(expectedStudents));
        assertTrue(expectedStudents.containsAll(actualStudents));
    }
}