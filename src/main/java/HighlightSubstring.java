import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class HighlightSubstring {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    /**
     * Главный метод программы для выделения подстроки красным цветом в тексте, читаемом с ввода.
     *
     * @param args Аргументы командной строки, где первый аргумент - это подстрока для выделения
     */
    public static void main(String[] args) {
        // Проверяем, передана ли подстрока в аргументах
        if (args.length < 1) {
            System.out.println("Usage: java HighlightSubstring <substring>");
            return;
        }

        String substring = args[0];

        // Используем BufferedReader для чтения строк из стандартного ввода
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            // Читаем строки по одной и выделяем подстроку красным цветом
            while ((line = reader.readLine()) != null) {
                // Заменяем каждое вхождение подстроки на выделенную красным
                String highlightedLine = line.replaceAll(substring, ANSI_RED + substring + ANSI_RESET);
                System.out.println(highlightedLine);
            }
        } catch (IOException e) {
            // Логируем исключения ввода-вывода
            Logger.getLogger(HighlightSubstring.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
    }
}