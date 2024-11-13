package org.example.students;

import org.example.students.exceptions.ItemNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class StudentsExaminationTest {

    protected StudentsExamination examination;

    @BeforeEach
    void setUp() {

        examination = new StudentsExamination();

        Score score1 = new Score("John Smith", "Mathematics", 5);
        Score score2 = new Score("Michael Johnson", "Physics", 5);
        Score score3 = new Score("David Brown", "History", 5);
        Score score4 = new Score("James Wilson", "History", 5);
        Score score5 = new Score("Robert Taylor", "History", 4);
        Score score6 = new Score("James Wilson", "Physics", 5);
        Score score7 = new Score("Michael Johnson", "History", 4);
        Score score8 = new Score("Michael Johnson", "Mathematics", 5);
        Score score9 = new Score("William Davis", "Biology", 4);
        Score score10 = new Score("Richard Miller", "Physical Education", 5);
        Score score11 = new Score("Charles Wilson", "Physical Education", 5);
        Score score12 = new Score("Thomas Moore", "Chemistry", 5);
        Score score13 = new Score("Joseph Anderson", "Geography", 4);
        Score score14 = new Score("Daniel Jackson", "Art", 5);
        Score score15 = new Score("Matthew White", "Music", 4);
        Score score16 = new Score("Christopher Harris", "English", 5);
        Score score17 = new Score("Andrew Martin", "Computer Science", 5);
        Score score18 = new Score("Brian Thompson", "Economics", 4);
        Score score19 = new Score("Kevin Garcia", "Sociology", 5);
        Score score20 = new Score("Jason Martinez", "Psychology", 4);

        List<Score> scores = List.of(
                score1, score2, score3, score4, score5, score6, score7, score8, score9, score10,
                score11, score12, score13, score14, score15, score16, score17, score18, score19, score20
        );

        examination.putAllItems(scores);

    }

    /**
     * Test that the method {@link StudentsExamination#getScore(String, String)} correctly throws
     * {@link ItemNotFoundException} when the student and subject pair does not exist, and correctly
     * returns the score when the student and subject pair exists.
     *
     * @throws ItemNotFoundException if the student and subject pair does not exist.
     */
    @Test
    void getScoreTest() throws ItemNotFoundException {

        Assertions.assertThrows(ItemNotFoundException.class, () -> examination.getScore("Ivan Below", "Russian").score());
        Assertions.assertEquals(5, examination.getScore("John Smith", "Mathematics").score());

    }

    /**
     * Tests that the method {@link StudentsExamination#getAverageForSubject(String)} correctly computes
     * the average score for the given subject. The average is calculated only from the scores that are
     * currently stored in the examination. If the subject does not exist, 0 will be returned.
     */
    @Test
    void getAverageForSubject() {

        double expected = (double) (5 + 5 + 4 + 4) / 4;
        Assertions.assertEquals(expected, examination.getAverageForSubject("History"));

    }

    /**
     * Test that the method {@link StudentsExamination#getAverageForSubject(String)} correctly caches the result
     * if the same subject is requested multiple times.
     */
    @Test
    void callManyTimesForRepeatingRequests() {

        examination.getAverageForSubject("History");
        examination.getAverageForSubject("History");
        examination.getAverageForSubject("History");

    }

    /**
     * Tests that the method {@link StudentsExamination#multipleSubmissionsStudentNames()} correctly
     * retrieves the names of students who have submitted more than one score for any subject.
     * The students will be returned in a set, so the order is not guaranteed.
     */
    @Test
    void multipleSubmissionsStudentNames() {

        Set<String> expected = new HashSet<>(List.of("Michael Johnson", "James Wilson"));
        Assertions.assertEquals(expected, examination.multipleSubmissionsStudentNames());

    }

    /**
     * Tests that the method {@link StudentsExamination#lastFiveStudentsWithExcellentMarkOnAnySubject()} correctly
     * retrieves the names of the last five students who have submitted a score of 5 for any subject.
     * The students will be returned in a set, so the order is not guaranteed.
     */
    @Test
    void lastFiveStudentsWithExcellentMarkOnAnySubject() {

        Set<String> expected = new LinkedHashSet<>(List.of("John Smith", "David Brown", "James Wilson", "Michael Johnson", "Richard Miller"));

        Set<String> result = examination.lastFiveStudentsWithExcellentMarkOnAnySubject();

        Assertions.assertEquals(5, result.size());
        Assertions.assertEquals(expected, result);

    }

    /**
     * Tests that the method {@link StudentsExamination#getAllScores()} correctly
     * retrieves all scores from the examination.
     * The scores will be returned in a collection, where each element is a
     * Score object containing the student's name, subject, and score.
     */
    @Test
    void getAllScores() {

        Collection<Score> result = examination.getAllScores();
        Assertions.assertEquals(20, result.size());
        System.out.println(result);

    }

    /**
     * Tests that the method {@link StudentsExamination#putAllItems(List)} correctly adds all scores from
     * the provided list to the examination records. Verifies that if a student and subject combination
     * already exists, the new score replaces the existing one.
     */
    @Test
    void putAllItems() {

        Assertions.assertTrue(examination.containsItem(new Score("John Smith", "Mathematics", 5)));
        Assertions.assertTrue(examination.containsItem(new Score("Michael Johnson", "Physics", 5)));
        Assertions.assertTrue(examination.containsItem(new Score("David Brown", "History", 5)));

    }

    /**
     * Tests that the method {@link StudentsExamination#getAllItems()} correctly retrieves
     * all student scores from the examination.
     * The scores are returned in a map, where the key is an instance of NameAndSubject
     * representing the student and subject pair, and the value is the corresponding score.
     * Verifies that the map contains the expected number of entries.
     */
    @Test
    void getAllItems() {

        Map<NameAndSubject, Integer> expected = examination.getAllItems();
        Assertions.assertEquals(20, expected.size());
        System.out.println(expected);

    }

    /**
     * Tests that the method {@link StudentsExamination#removeItem(String, String)} correctly removes the
     * score for the given student and subject from the examination records.
     * <p>
     * Verifies that if the student and subject pair does not exist, an {@link ItemNotFoundException}
     * will be thrown.
     * <p>
     * Verifies that the removed item is correctly returned.
     *
     * @throws ItemNotFoundException if the student and subject pair does not exist.
     */
    @Test
    void removeItem() throws ItemNotFoundException {

        Score removedItem = examination.removeItem("John Smith", "Mathematics");
        Assertions.assertFalse(examination.containsItem(new Score("John Smith", "Mathematics", 5)));
        Assertions.assertTrue(examination.containsItem(new Score("Michael Johnson", "Physics", 5)));
        Assertions.assertTrue(examination.containsItem(new Score("David Brown", "History", 5)));
        Assertions.assertEquals(new Score("John Smith", "Mathematics", 5), removedItem);

        Assertions.assertThrows(ItemNotFoundException.class, () -> examination.removeItem("Ivan Below", "Russian"));

    }

}