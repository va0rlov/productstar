package resultsboard.studentscore;

import java.util.Objects;

public record StudentScore(String name, Float score) implements Comparable<StudentScore> {

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "StudentScore[" +
                "name=" + name + ", " +
                "score=" + score + ']';
    }

    /**
     * Compares this StudentScore object with the specified StudentScore object for order.
     * Returns a negative integer, zero, or a positive integer if this object is less than,
     * equal to, or greater than the specified object.
     * <p>
     * The comparison is based on the score first, and if the scores are equal,
     * it falls back to comparing the names lexicographically.
     *
     * @param o the StudentScore object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than,
     *         equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(StudentScore o) {
        if (Objects.equals(this.score, o.score)) {
            return this.name.compareTo(o.name);
        }
        return this.score.compareTo(o.score);
    }
}