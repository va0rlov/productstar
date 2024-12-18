import org.example.model.Distance;
import org.example.model.Gender;
import org.example.model.Person;
import org.example.model.Result;
import org.example.service.ResultsProcessor;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultsProcessorTest {

    @Test
    public void testGetFastest() {
        var results = List.of(new Result(new Person("Иван Иванов", Gender.MALE), Distance.TEN_KM, Duration.ofSeconds(3320)), new Result(new Person("Петр Петров", Gender.MALE), Distance.TEN_KM, Duration.ofSeconds(3300)), new Result(new Person("Мария Иванова", Gender.FEMALE), Distance.TEN_KM, Duration.ofSeconds(3400)));

        var processor = new ResultsProcessor(results);
        var fastest = processor.getFastest(Gender.MALE, Distance.TEN_KM, 2);

        assertEquals(2, fastest.size());
        assertEquals("Петр Петров", fastest.get(0).person().name());
        assertEquals("Иван Иванов", fastest.get(1).person().name());
    }
}