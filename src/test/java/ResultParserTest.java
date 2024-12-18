import org.example.model.Distance;
import org.example.model.Gender;
import org.example.model.Result;
import org.example.service.ResultParser;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultParserTest {

    private final ResultParser parser = new ResultParser();

    @Test
    public void testParseResult() {
        String line = "John Smith,M,10 km,29:01";
        Result result = parser.parseResult(line);

        assertEquals("John Smith", result.person().name());
        assertEquals(Gender.MALE, result.person().gender());
        assertEquals(Distance.TEN_KM, result.distance());
        assertEquals(Duration.ofSeconds(29 * 60 + 1), result.time());
    }

    @Test
    public void testParseTime() {
        String time = "29:01";
        Duration duration = parser.parseTime(time);

        assertEquals(Duration.ofSeconds(29 * 60 + 1), duration);
    }
}