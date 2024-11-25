import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HighlightSubstring {

    // ANSI escape codes для цвета текста
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java HighlightSubstring <substring>");
            return;
        }

        String substring = args[0];

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Подсвечиваем все вхождения подстроки
                String highlightedLine = line.replaceAll(substring, ANSI_RED + substring + ANSI_RESET);
                System.out.println(highlightedLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}