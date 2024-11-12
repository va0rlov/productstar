package org.example.students;

import org.example.students.exceptions.ItemNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Examination {

    /**
     * Adds a score to the examination.
     * <p>
     * If the student and subject pair already exists, the score will be updated.
     *
     * @param score the score to add
     */
    void addScore(Score score);

    /**
     * Retrieves the score for a specific student and subject.
     *
     * @param name    the name of the student
     * @param subject the subject for which the score is requested
     * @return the Score object containing the student's name, subject, and score
     * @throws ItemNotFoundException if the student and subject pair does not exist
     */
    Score getScore(String name, String subject) throws ItemNotFoundException;

    /**
     * Adds all scores from the given list to the examination.
     * <p>
     * The scores will be added one by one, so if a score already exists, it will
     * be updated.
     *
     * @param items the list of scores to add
     */
    void putAllItems(List<Score> items);

    /**
     * Removes the score for the given student and subject.
     * <p>
     * If the student and subject pair does not exist, an ItemNotFoundException
     * will be thrown.
     *
     * @param name    the name of the student
     * @param subject the subject from which the score is to be removed
     * @return the Score object containing the student's name, subject, and score
     * @throws ItemNotFoundException if the student and subject pair does not exist
     */
    Score removeItem(String name, String subject) throws ItemNotFoundException;

    /**
     * Checks if the given student and subject pair already exists in the
     * examination.
     *
     * @param score the student and subject pair to check
     * @return true if the student and subject pair exists, false otherwise
     */
    boolean containsItem(Score score);

    /**
     * Retrieves the average score for the given subject.
     * <p>
     * The average will be calculated only from the scores that are currently
     * stored in the examination. If the subject does not exist, 0 will be
     * returned.
     *
     * @param subject the subject for which the average is requested
     * @return the average score for the given subject
     */
    double getAverageForSubject(String subject);

    /**
     * Retrieves the names of students who have submitted more than one score for any subject.
     * <p>
     * The students will be returned in a set, so the order is not guaranteed.
     *
     * @return a set of the student names
     */
    Set<String> multipleSubmissionsStudentNames();

    /**
     * Retrieves the names of the last five students who have submitted a score of 5 for any subject.
     * <p>
     * The students will be returned in a set, so the order is not guaranteed.
     *
     * @return a set of the student names
     */
    Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject();

    /**
     * Retrieves all scores from the examination.
     * <p>
     * The scores will be returned in a map, where the key is the student and
     * subject pair, and the value is the score.
     *
     * @return a map with all scores
     */
    Map<NameAndSubject, Integer> getAllItems();

    /**
     * Retrieves all scores from the examination.
     * <p>
     * The scores will be returned in a collection, where each element is a
     * Score object containing the student's name, subject, and score.
     *
     * @return a collection with all scores
     */
    Collection<Score> getAllScores();

}
