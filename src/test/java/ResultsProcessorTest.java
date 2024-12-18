import org.example.model.Distance;
import org.example.model.Gender;
import org.example.model.Person;
import org.example.model.Result;
import org.example.service.ResultsProcessor;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResultsProcessorTest {

    @Test
    public void testEmptyResultsCollection() {
        // Проверяем, что конструктор выбрасывает исключение при передаче пустой коллекции
        assertThrows(IllegalArgumentException.class, () -> {
            new ResultsProcessor(Collections.emptyList());
        });
    }

    @Test
    public void testInvalidLimit() {
        // Создаем коллекцию с результатами
        List<Result> results = List.of(
                new Result(new Person("John Smith", Gender.MALE), Distance.TEN_KM, Duration.ofSeconds(30 * 60 + 29))
        );

        // Создаем ResultsProcessor
        ResultsProcessor processor = new ResultsProcessor(results);

        // Проверяем, что метод getFastest выбрасывает исключение при limit <= 0
        assertThrows(IllegalArgumentException.class, () -> {
            processor.getFastest(Gender.MALE, Distance.TEN_KM, 0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            processor.getFastest(Gender.MALE, Distance.TEN_KM, -1);
        });
    }

    @Test
    public void testGetFastest() {
        // Создаем коллекцию с результатами
        List<Result> results = List.of(
                new Result(new Person("John Smith", Gender.MALE), Distance.TEN_KM, Duration.ofSeconds(30 * 60 + 29)),
                new Result(new Person("Jane Doe", Gender.FEMALE), Distance.TEN_KM, Duration.ofSeconds(31 * 60 + 15)),
                new Result(new Person("Alex Brown", Gender.MALE), Distance.TEN_KM, Duration.ofSeconds(29 * 60 + 50)),
                new Result(new Person("Emily White", Gender.FEMALE), Distance.TEN_KM, Duration.ofSeconds(30 * 60 + 45))
        );

        // Создаем ResultsProcessor
        ResultsProcessor processor = new ResultsProcessor(results);

        // Получаем 2 самых быстрых мужчин на 10 км
        List<Result> fastestMen = processor.getFastest(Gender.MALE, Distance.TEN_KM, 2);

        // Проверяем результат
        assertEquals(2, fastestMen.size());
        assertEquals("Alex Brown", fastestMen.get(0).person().name());
        assertEquals("John Smith", fastestMen.get(1).person().name());

        // Получаем 1 самую быструю женщину на 10 км
        List<Result> fastestWomen = processor.getFastest(Gender.FEMALE, Distance.TEN_KM, 1);

        // Проверяем результат
        assertEquals(1, fastestWomen.size());
        assertEquals("Emily White", fastestWomen.get(0).person().name());
    }
}