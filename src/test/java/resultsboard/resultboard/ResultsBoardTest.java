// src/test/java/resultsboard/ResultsBoardTest.java

package resultsboard.resultboard;

import org.junit.jupiter.api.Test;
import resultsboard.studentscore.StudentScore;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResultsBoardTest {

    /**
     * Тест для метода addStudent.
     *
     * <p>Убеждаемся, что после добавления одного студента в ResultsBoard
     * количество студентов в нем равно 1.
     */
    @Test
    public void testAddStudent() {
        ResultsBoard resultsBoard = new ResultsBoard();
        resultsBoard.addStudent("John Doe", 4.5f);
        assertEquals(1, resultsBoard.getStudents().size());
    }

    /**
     * Тест для метода top3.
     *
     * <p>Проверяет, что метод top3 возвращает корректный список из трех студентов
     * с наивысшими оценками в правильном порядке. Убеждаемся, что результаты
     * включают только три студента и что они расположены по убыванию их оценок.
     */
    @Test
    public void testTop3() {
        ResultsBoard resultsBoard = new ResultsBoard();
        resultsBoard.addStudent("John Doe", 4.5f);
        resultsBoard.addStudent("Jane Doe", 4.8f);
        resultsBoard.addStudent("Bob Smith", 4.2f);
        resultsBoard.addStudent("Alice Johnson", 4.9f);
        List<StudentScore> top3 = resultsBoard.top3();
        assertEquals(3, top3.size());
        assertEquals("Alice Johnson", top3.get(0).name());
        assertEquals("Jane Doe", top3.get(1).name());
        assertEquals("John Doe", top3.get(2).name());
    }

    /**
     * Тест для метода top3.
     *
     * <p>Проверяет, что метод top3 возвращает пустой список, если ResultsBoard
     * пуст.
     */
    @Test
    public void testTop3EmptyBoard() {
        ResultsBoard resultsBoard = new ResultsBoard();
        List<StudentScore> top3 = resultsBoard.top3();
        assertTrue(top3.isEmpty());
    }

    /**
     * Тест для метода getStudents.
     *
     * <p>Проверяет, что метод getStudents возвращает список из всех студентов
     * ResultsBoard. Убеждаемся, что результаты включают всех студентов и
     * что они расположены в том порядке, в котором они были добавлены.
     */
    @Test
    public void testGetStudents() {
        ResultsBoard resultsBoard = new ResultsBoard();
        resultsBoard.addStudent("John Doe", 4.5f);
        resultsBoard.addStudent("Jane Doe", 4.8f);
        List<StudentScore> students = resultsBoard.getStudents();
        assertEquals(2, students.size());
        assertEquals("John Doe", students.get(0).name());
        assertEquals("Jane Doe", students.get(1).name());
    }

    /**
     * Тест для метода toString.
     *
     * <p>Убеждаемся, что результат метода toString содержит информацию
     * обо всех студентах ResultsBoard, включая их имена и оценки.
     */
    @Test
    public void testToString() {
        ResultsBoard resultsBoard = new ResultsBoard();
        resultsBoard.addStudent("John Doe", 4.5f);
        resultsBoard.addStudent("Jane Doe", 4.8f);
        String toString = resultsBoard.toString();
        assertNotNull(toString);
        assertTrue(toString.contains("John Doe"));
        assertTrue(toString.contains("Jane Doe"));
    }
}