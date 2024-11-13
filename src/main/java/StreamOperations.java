import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamOperations {

    // Метод для определения списка строк
    public static List<String> getStringList() {
        return List.of("apple", "banana", "apple", "orange", "banana", "grape");
    }

    // Метод для определения списка чисел
    public static List<Integer> getIntegerList() {
        return List.of(10, 5, 8, 20, 15, 30, 25);
    }

    // Метод для удаления дубликатов
    public static List<String> removeDuplicates(List<String> list) {
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    // Метод для подсчета строк, начинающихся с определенной буквы
    public static long countStringsStartingWith(List<String> list, char letter) {
        return list.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .count();
    }

    // Метод для поиска второго по величине элемента в списке целых чисел
    public static Optional<Integer> findSecondLargest(List<Integer> list) {
        return list.stream()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst();
    }

    public static void main(String[] args) {
        // Задание 1: Удаление всех повторяющихся элементов из списка
        List<String> listWithDuplicates = getStringList();
        List<String> uniqueList = removeDuplicates(listWithDuplicates);
        System.out.println("Список без дубликатов: " + uniqueList);

        // Задание 2: Подсчет количества строк в списке, которые начинаются с определенной буквы
        List<String> listOfStrings = getStringList();
        char letter = 'a';
        long count = countStringsStartingWith(listOfStrings, letter);
        System.out.println("Количество строк, начинающихся с буквы '" + letter + "': " + count);

        // Задание 3: Поиск второго по величине элемента в списке целых чисел
        List<Integer> listOfIntegers = getIntegerList();
        Optional<Integer> secondLargest = findSecondLargest(listOfIntegers);
        secondLargest.ifPresent(value -> System.out.println("Второй по величине элемент: " + value));
    }
}