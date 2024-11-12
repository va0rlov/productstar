package org.example.students;

import org.example.students.exceptions.ItemNotFoundException;

import java.util.*;


public class StudentsExamination implements Examination {

    private static final int INITIAL_CAPACITY = 256;
    private final Map<NameAndSubject, Integer> examinations = new LinkedHashMap<>(INITIAL_CAPACITY);
    private final LRUCache<String, Double> cache = new LRUCache<>(2);


    /**
     * Add a score to the list of scores.
     * If the student and subject already exist, the new score is stored instead.
     *
     * @param score the score to add
     */
    @Override
    public void addScore(Score score) {

        NameAndSubject nameAndSubject = new NameAndSubject(score.name(), score.subject());
        examinations.put(nameAndSubject, score.score());

    }

    /**
     * Returns the score for a given student and subject.
     *
     * @param name    the name of the student
     * @param subject the subject of the score
     * @return the score of the student for the given subject
     * @throws ItemNotFoundException if the student and subject do not exist
     */
    @Override
    public Score getScore(String name, String subject) throws ItemNotFoundException {

        NameAndSubject nameAndSubject = new NameAndSubject(name, subject);

        if (examinations.containsKey(nameAndSubject)) {
            return new Score(name, subject, examinations.get(nameAndSubject));
        }

        throw new ItemNotFoundException(name + ' ' + subject);

    }

    /**
     * Adds a list of scores to the examination records.
     * If a student and subject combination already exists, the new score replaces the existing one.
     *
     * @param items the list of scores to add
     */
    @Override
    public void putAllItems(List<Score> items) {

        for (Score item : items) {
            addScore(item);
        }

    }

    /**
     * Removes a score from the list of scores.
     * If the student and subject do not exist, throws ItemNotFoundException.
     *
     * @param name    the name of the student
     * @param subject the subject of the score
     * @return the score of the student for the given subject
     * @throws ItemNotFoundException if the student and subject do not exist
     */
    @Override
    public Score removeItem(String name, String subject) throws ItemNotFoundException {

        NameAndSubject nameAndSubject = new NameAndSubject(name, subject);

        if (examinations.containsKey(nameAndSubject)) {
            return new Score(name, subject, examinations.remove(nameAndSubject));
        }

        throw new ItemNotFoundException(name + ' ' + subject);

    }

    /**
     * Checks if a specific score exists in the examination records.
     *
     * @param score the score object containing the student's name and subject
     * @return true if the score exists, false otherwise
     */
    @Override
    public boolean containsItem(Score score) {

        NameAndSubject nameAndSubject = new NameAndSubject(score.name(), score.subject());

        return examinations.containsKey(nameAndSubject);

    }

    /**
     * Computes the average score for a given subject.
     * This method does not cache the result and should be used only by the
     * {@link #getAverageForSubject(String)} method.
     *
     * @param subject the subject for which to compute the average score
     * @return the average score for the given subject
     */
    private double getAverageForSubjectCompute(String subject) {

        double average = 0;
        int count = 0;

        for (Map.Entry<NameAndSubject, Integer> entry : examinations.entrySet()) {
            if (entry.getKey().subject().equals(subject)) {
                average += entry.getValue();
                count++;
            }
        }
        if (count == 0) {
            return 0;
        }

        return average / count;

    }

    /**
     * Computes the average score for a given subject.
     * This method caches the result and is thread-safe.
     *
     * @param subject the subject for which to compute the average score
     * @return the average score for the given subject
     */
    @Override
    public double getAverageForSubject(String subject) {

        return cache.computeIfAbsent(subject, this::getAverageForSubjectCompute);

    }

    /**
     * Retrieves the names of students who have submitted more than one score for any subject.
     * <p>
     * The students will be returned in a set, so the order is not guaranteed.
     *
     * @return a set of the student names
     */
    @Override
    public Set<String> multipleSubmissionsStudentNames() {

        Set<String> tempNames = new HashSet<>();
        Set<String> result = new HashSet<>();

        for (Map.Entry<NameAndSubject, Integer> entry : examinations.entrySet()) {
            if (tempNames.contains(entry.getKey().name())) {
                result.add(entry.getKey().name());
            } else {
                tempNames.add(entry.getKey().name());
            }
        }

        return result;

    }

    /**
     * Retrieves the names of the last five students who have submitted a score of 5 for any subject.
     * <p>
     * The students will be returned in a set, so the order is not guaranteed.
     *
     * @return a set of the student names
     */
    @Override
    public Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject() {

        Set<String> result = new LinkedHashSet<>();
        List<String> scores = new ArrayList<>();

        if (examinations.isEmpty()) {
            return result;
        }

        for (Map.Entry<NameAndSubject, Integer> entry : examinations.entrySet()) {
            if (entry.getValue() == 5) {
                scores.add(entry.getKey().name());
            }
        }

        Collections.reverse(scores);
        for (String score : scores) {
            result.add(score);
            if (result.size() == 5) {
                break;
            }
        }

        return result;

    }

    /**
     * Retrieves a map containing all student scores.
     * <p>
     * The map's keys are instances of NameAndSubject, representing the student
     * and subject pair, while the values are the corresponding scores.
     *
     * @return a LinkedHashMap of all student and subject pairs with their scores
     */
    @Override
    public Map<NameAndSubject, Integer> getAllItems() {

        return new LinkedHashMap<>(examinations);

    }

    /**
     * Retrieves a collection of all scores.
     * <p>
     * The collection contains Score objects, each representing a student and
     * subject pair with the corresponding score.
     *
     * @return a collection of all student and subject pairs with their scores
     */
    @Override
    public Collection<Score> getAllScores() {

        List<Score> allScores = new ArrayList<>();

        for (Map.Entry<NameAndSubject, Integer> entry : examinations.entrySet()) {
            allScores.add(new Score(entry.getKey().name(), entry.getKey().subject(), entry.getValue()));
        }

        return allScores;

    }

}
