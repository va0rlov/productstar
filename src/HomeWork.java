import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        final int MIN_AGE = 1;
        final int MAX_AGE = 123;

        Scanner scanner = new Scanner(System.in);

        int choice = 1; // Объявляем переменную choice вне цикла
        do {
            System.out.println("Расскажите о вашем друге");
            System.out.print("Как зовут вашего друга: ");
            String name = scanner.nextLine();
            if (name == null || name.isEmpty()) {
                System.out.println("Нужно ввести имя.");
                continue;
            }

            int age = 0;
            boolean isValidAge = false;
            do {
                try {
                    System.out.print("Сколько лет вашему другу: ");
                    age = scanner.nextInt();
                    scanner.nextLine(); // Очистить ввод
                    if (age < MIN_AGE || age > MAX_AGE) {
                        System.out.println("Нужно число от " + MIN_AGE + " до " + MAX_AGE + ".");
                    } else {
                        isValidAge = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Нужно число от " + MIN_AGE + " до " + MAX_AGE + ".");
                    scanner.next(); // Очистить ввод
                }
            } while (!isValidAge);

            System.out.println("Моему другу по имени '" + name + "' сейчас полных лет: " + age + ".");

            do {
                System.out.print("Хотите запустить программу заново? (0 - окончание, 1 - заново): ");
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Очистить ввод
                    if (choice != 0 && choice != 1) {
                        System.out.println("Нужно ввести 0 или 1.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Нужно ввести 0 или 1.");
                    scanner.next(); // Очистить ввод
                    choice = -1;
                }
            } while (choice != 0 && choice != 1);
        } while (choice == 1);
        scanner.close();
    }
}
