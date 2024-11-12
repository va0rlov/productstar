package org.example.students;

import java.util.Collection;
import java.util.Set;

public interface Examination {
    void addScore(Score score);

    Score getScore(String name, String subject);

    double getAverageForSubject(String subject);

    Set<String> multipleSubmissionsStudentNames();

    Set<String> lastFiveStudentsWithExcellentMarkOnAnySubject();

    Collection<Score> getAllScores();
}
