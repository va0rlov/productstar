import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Класс FizzBuzz реализует известную задачу "FizzBuzz".
 * Программа запрашивает у пользователя положительное целое число и выводит числа от 0 до этого числа,
 * заменяя числа, кратные 3, на "fizz", кратные 5 — на "buzz", а числа, кратные и 3, и 5 — на "fizzbuzz".
 * Для нуля выводится "0".
 */
public class FizzBuzz {

    /**
     * Основной метод программы, который запускает процесс ввода и вывода.
     *
     * @param args Аргументы командной строки (не используются в данной программе).
     */
    public static void main(String[] args) {
        // Создаем объект Scanner для чтения ввода с консоли
        Scanner scanner = new Scanner(System.in);
        int n;

        try {
            // Запрашиваем у пользователя ввод положительного целого числа
            System.out.print("Введите положительное целое число: ");
            n = scanner.nextInt();

            // Проверяем, что введенное число положительное
            if (n <= 0) {
                throw new IllegalArgumentException("Ошибка: Введено не положительное число. Требуется положительное целое число.");
            }
        } catch (InputMismatchException e) {
            // Обрабатываем исключение, если пользователь ввел некорректные данные
            System.out.print("Ошибка: Введено некорректное значение. Требуется положительное целое число.");
            scanner.close();
            return;
        } catch (IllegalArgumentException e) {
            // Обрабатываем исключение, если пользователь ввел не положительное число
            System.out.print(e.getMessage());
            scanner.close();
            return;
        } finally {
            // Закрываем Scanner, чтобы избежать утечек ресурсов
            scanner.close();
        }

        // Цикл для перебора чисел от 0 до n
        for (int i = 0; i <= n; i++) {
            // Используем методы класса Number для определения вывода
            if (i == 0) {
                System.out.print(i);
            } else if (Number.isDivisibleBy3And5(i)) {
                System.out.print("fizzbuzz");
            } else if (Number.isDivisibleBy3(i)) {
                System.out.print("fizz");
            } else if (Number.isDivisibleBy5(i)) {
                System.out.print("buzz");
            } else {
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }
}

/**
 * Класс Number содержит статические методы для проверки делимости чисел.
 */
class Number {

    /**
     * Проверяет, делится ли число на 3.
     *
     * @param number Число для проверки.
     * @return true, если число делится на 3, иначе false.
     */
    public static boolean isDivisibleBy3(int number) {
        return number % 3 == 0;
    }

    /**
     * Проверяет, делится ли число на 5.
     *
     * @param number Число для проверки.
     * @return true, если число делится на 5, иначе false.
     */
    public static boolean isDivisibleBy5(int number) {
        return number % 5 == 0;
    }

    /**
     * Проверяет, делится ли число на 3 и на 5.
     *
     * @param number Число для проверки.
     * @return true, если число делится на 3 и на 5, иначе false.
     */
    public static boolean isDivisibleBy3And5(int number) {
        return isDivisibleBy3(number) && isDivisibleBy5(number);
    }
}