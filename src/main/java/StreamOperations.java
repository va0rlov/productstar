import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamOperations {

    /**
     * Returns a list of strings containing some fruit names.
     *
     * @return a list of strings with sample fruit names, including duplicates
     */
    public static List<String> getStringList() {
        return List.of("apple", "banana", "apple", "orange", "banana", "grape");
    }


    /**
     * Returns a list of integers containing some sample numbers.
     *
     * @return a list of integers with sample numbers
     */
    public static List<Integer> getIntegerList() {
        return List.of(10, 5, 8, 20, 15, 30, 25);
    }

    /**
     * Removes all duplicate elements from the given list.
     *
     * @param list the list to remove duplicates from
     * @return a list of strings without duplicates
     */
    public static List<String> removeDuplicates(List<String> list) {
        // Use stream operation to remove duplicates
        return list.stream()
                // Remove duplicates by keeping only distinct elements
                .distinct()
                // Collect the stream into a list
                .collect(Collectors.toList());
    }

    /**
     * Returns the number of strings in the given list that start with the given letter.
     *
     * @param list the list of strings to search in
     * @param letter the letter to search for
     * @return the number of strings that start with the given letter
     */
    public static long countStringsStartingWith(List<String> list, char letter) {
        // Use stream operation to count the number of strings that start with the given letter
        return list.stream()
                // Filter the strings that start with the given letter
                .filter(s -> s.startsWith(String.valueOf(letter)))
                // Count the number of strings that satisfy the condition
                .count();
    }

    /**
     * Returns the second-largest number in the given list.
     *
     * @param list the list of numbers to find the second largest in
     * @return the second-largest number in the list, or empty if the list has less than 2 elements
     */
    public static Optional<Integer> findSecondLargest(List<Integer> list) {
        return list.stream()
                // Sort the list of numbers in descending order
                .sorted((a, b) -> b - a)
                // Skip the first element (the largest number)
                .skip(1)
                // Find the first element in the remaining list (the second-largest number)
                .findFirst();
    }

    /**
     * The main method demonstrating the usage of stream operations on lists.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        // Retrieve a list of strings with duplicates
        List<String> listWithDuplicates = getStringList();
        // Remove duplicates from the list
        List<String> uniqueList = removeDuplicates(listWithDuplicates);
        System.out.println("Список без дубликатов: " + uniqueList);

        // Retrieve a list of strings
        List<String> listOfStrings = getStringList();
        // Define the letter to search for
        char letter = 'a';
        // Count the number of strings starting with the given letter
        long count = countStringsStartingWith(listOfStrings, letter);
        System.out.println("Количество строк, начинающихся с буквы '" + letter + "': " + count);

        // Retrieve a list of integers
        List<Integer> listOfIntegers = getIntegerList();
        // Find the second-largest number in the list
        Optional<Integer> secondLargest = findSecondLargest(listOfIntegers);
        // Print the second-largest number if present
        secondLargest.ifPresent(value -> System.out.println("Второй по величине элемент: " + value));
    }
}