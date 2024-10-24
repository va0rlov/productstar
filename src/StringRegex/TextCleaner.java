// src/StringRegex/TextCleaner.java

package StringRegex;

public class TextCleaner {
    public static String removeLettersAndSpaces(String text) {
        return text.replaceAll("[a-zA-Zа-яА-Я\\s]", "");
    }
}
