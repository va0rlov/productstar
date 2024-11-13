package resultsboard.studentscore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentScoreTest {

    /**
     * Tests the contract of the toString() method.
     * Given a StudentScore object, the toString() method should return a string representation of the object
     * in the format "StudentScore[name=<name>, score=<score>]", where <name> is the name of the student and <score> is the score of the student.
     *
     */
    @Test
    public void testToString() {
        StudentScore studentScore = new StudentScore("Juan", 3.5f);
        String expectedOutput = "StudentScore[name=Juan, score=3.5]";
        assertEquals(expectedOutput, studentScore.toString());
    }

    /**
     * Tests the contract of the compareTo() method.
     * Given two StudentScore objects, the compareTo() method should return a negative value if the score of the first object is less than the score of the second object,
     * a positive value if the score of the first object is greater than the score of the second object,
     * and 0 if the scores of both objects are equal.
     * If the scores of both objects are equal, the compareTo() method should return a negative value if the first object's name is lexicographically less than the second object's name,
     * a positive value if the first object's name is lexicographically greater than the second object's name,
     * and 0 if the names of both objects are equal.
     */
    @Test
    public void testCompareTo() {
        StudentScore student1 = new StudentScore("Juan", 3.5f);
        StudentScore student2 = new StudentScore("Sérgio", 5.0f);
        StudentScore student3 = new StudentScore("Mariana", 3.5f);

        // Проверка сравнения по оценке
        assertTrue(student1.compareTo(student2) < 0);
        assertTrue(student2.compareTo(student1) > 0);

        // Проверка сравнения по имени, когда оценки равны
        assertTrue(student1.compareTo(student3) < 0);
        assertTrue(student3.compareTo(student1) > 0);

        // Проверка равенства
        assertEquals(0, student1.compareTo(new StudentScore("Juan", 3.5f)));
    }

        /**
         * Tests the contract of the equals() method.
         * Given two StudentScore objects that are equal, the equals() method should return true.
         * Given two StudentScore objects that are not equal, the equals() method should return false.
         */
    @Test
    public void testEquals() {
        StudentScore student1 = new StudentScore("Juan", 3.5f);
        StudentScore student2 = new StudentScore("Juan", 3.5f);
        StudentScore student3 = new StudentScore("Sérgio", 5.0f);

        assertEquals(student1, student2);
        assertNotEquals(student1, student3);
    }

        /**
         * Tests the contract of the hashCode() method.
         * Given two StudentScore objects that are equal, their hash codes
         * should be equal.
         * Given two StudentScore objects that are not equal, their hash
         * codes should not be equal.
         */
        @Test
    public void testHashCode() {
        StudentScore student1 = new StudentScore("Juan", 3.5f);
        StudentScore student2 = new StudentScore("Juan", 3.5f);
        StudentScore student3 = new StudentScore("Sérgio", 5.0f);

        assertEquals(student1.hashCode(), student2.hashCode());
        assertNotEquals(student1.hashCode(), student3.hashCode());
    }
}