package resultsboard.resultboard;

import resultsboard.StudentScore;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Класс для хранения и управления результатами студентов.
 */
public class ResultsBoard {

    /**
     * Множество для хранения результатов студентов, отсортированных по оценкам.
     */
    private final NavigableSet<StudentScore> resultsBoard = new TreeSet<>();

    /**
     * Добавляет студента с указанным именем и оценкой в ResultsBoard.
     *
     * @param name  Имя студента.
     * @param score Оценка студента.
     */
    public void addStudent(String name, Float score) {
        resultsBoard.add(new StudentScore(name, score));
    }

    /**
     * Возвращает список имен и оценок топ-3 студентов с наивысшими оценками.
     *
     * @return Список имен и оценок топ-3 студентов.
     */
    public List<StudentScore> top3() {
        List<StudentScore> result = new ArrayList<>(3);

        if (resultsBoard.isEmpty()) {
            return result;
        }

        StudentScore last = resultsBoard.last();
        result.add(last);

        StudentScore secondLast = resultsBoard.lower(last);
        if (secondLast != null) {
            result.add(secondLast);
        }

        StudentScore thirdLast = resultsBoard.lower(secondLast);
        if (thirdLast != null) {
            result.add(thirdLast);
        }

        return result;
    }

    /**
     * Добавляет всех студентов из списков имен и оценок в ResultsBoard.
     *
     * @param names  Список имен студентов.
     * @param scores Список оценок студентов.
     * @throws IllegalArgumentException Если списки имеют разную длину.
     */
    public void addAllStudents(List<String> names, List<Float> scores) {
        if (names.size() != scores.size()) {
            throw new IllegalArgumentException("Списки имен и оценок должны иметь одинаковую длину.");
        }
        for (int i = 0; i < names.size(); i++) {
            addStudent(names.get(i), scores.get(i));
        }
    }

    /**
     * Добавляет всех студентов из списка StudentScore в ResultsBoard.
     *
     * @param studentScores Список объектов StudentScore.
     */
    public void addAllStudents(List<StudentScore> studentScores) {
        resultsBoard.addAll(studentScores);
    }

    /**
     * Возвращает список всех студентов в ResultsBoard.
     *
     * @return Список всех студентов.
     */
    public List<StudentScore> getStudents() {
        return new ArrayList<>(resultsBoard);
    }

    /**
     * Возвращает строковое представление ResultsBoard, где каждый студент находится на отдельной строке.
     *
     * @return Строковое представление ResultsBoard.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ResultsBoard:\n");
        for (StudentScore student : resultsBoard) {
            sb.append(student).append("\n");
        }
        return sb.toString();
    }
}