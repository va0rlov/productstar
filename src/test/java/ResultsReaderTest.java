import org.example.model.Distance;
import org.example.model.Gender;
import org.example.model.Result;
import org.example.service.ResultParser;
import org.example.service.ResultsReader;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultsReaderTest {

    @Test
    public void testReadFromFile() {
        // Используем реальный ResultParser
        ResultParser parser = new ResultParser();

        // Создаем ResultsReader с реальным парсером
        var reader = new ResultsReader(parser);
        var results = reader.readFromFile(Paths.get("src/test/resources/results200.csv"));

        // Проверяем результат
        assertEquals(190, results.size()); // Убедимся, что все 190 строк были прочитаны

        // Проверяем первый результат
        Result firstResult = results.get(0);
        assertEquals("Lillian Cote", firstResult.person().name());
        assertEquals(Gender.FEMALE, firstResult.person().gender());
        assertEquals(Distance.TEN_KM, firstResult.distance());
        assertEquals(Duration.ofSeconds(33 * 60 + 57), firstResult.time());

        // Проверяем второй результат
        Result secondResult = results.get(1);
        assertEquals("Nathan Beatty", secondResult.person().name());
        assertEquals(Gender.MALE, secondResult.person().gender());
        assertEquals(Distance.TEN_KM, secondResult.distance());
        assertEquals(Duration.ofSeconds(30 * 60 + 29), secondResult.time());

        // Проверяем последний результат
        Result lastResult = results.get(results.size() - 1);
        assertEquals("Océane Bouchard", lastResult.person().name());
        assertEquals(Gender.FEMALE, lastResult.person().gender());
        assertEquals(Distance.FIVE_KM, lastResult.distance());
        assertEquals(Duration.ofSeconds(16 * 60 + 29), lastResult.time());
    }
}