// src/StringRegex/CountEInWords.java
package StringRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountEInWords {
    public static void countEInWords(String text) {
        System.out.println("Текст для анализа: " + text); // Добавленный вывод
        Pattern pattern = Pattern.compile("\\b[а-яёА-ЯЁ]+\\b", Pattern.UNICODE_CHARACTER_CLASS); // Обновленное регулярное выражение для русских слов
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String word = matcher.group();
            int count = countEInWord(word);
            System.out.println("Слово: " + word + ", Количество 'е': " + count);
        }
    }

    private static int countEInWord(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c == 'е' || c == 'Е') {
                count++;
            }
        }
        return count;
    }
}