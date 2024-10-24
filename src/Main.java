// src/Main.java

import Constants.Constants;
import StringRegex.CountEInWords;
import StringRegex.PhoneValidator;
import StringRegex.TextCleaner;

public class Main {
    public static void main(String[] args) {
        // Задание 1: Посчитать количество букв 'е' в каждом слове
        System.out.println("Задание 1:");
        CountEInWords.countEInWords(Constants.TEXT);

        // Задание 2: Проверка телефона в международном формате
        System.out.println("\nЗадание 2:");
        System.out.println("Телефон " + Constants.VALID_PHONE_NUMBER + " валиден: " + PhoneValidator.isValidPhoneNumber(Constants.VALID_PHONE_NUMBER));
        System.out.println("Телефон " + Constants.INVALID_PHONE_NUMBER + " валиден: " + PhoneValidator.isValidPhoneNumber(Constants.INVALID_PHONE_NUMBER));

        // Задание 3: Удаление всех букв и пробелов из текста
        System.out.println("\nЗадание 3:");
        String result = TextCleaner.removeLettersAndSpaces(Constants.TEXT);
        System.out.println("Результирующая строка: " + result);
    }
}