import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Scanner;

public class FileLoader {

    /**
     * Основной метод для загрузки и сохранения файлов.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод данных от пользователя
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();

        System.out.print("Введите директорию: ");
        String directory = scanner.nextLine();

        System.out.print("Введите текст для сохранения: ");
        String text = scanner.nextLine();

        // Валидация входных данных
        if (fileName.isEmpty() || directory.isEmpty() || text.isEmpty()) {
            System.out.println("Ошибка: все поля должны быть заполнены.");
            return;
        }

        // Создание пути к файлу
        Path filePath;
        try {
            filePath = Paths.get(directory, fileName);
        } catch (InvalidPathException e) {
            System.out.println("Ошибка: некорректный путь к файлу: " + e.getMessage());
            return;
        }

        try {
            // Создание директории, если она не существует
            Files.createDirectories(filePath.getParent());

            // Запись текста в файл
            Files.write(filePath, text.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

            // Получение размера файла и времени записи
            long fileSize = Files.size(filePath);
            FileTime fileTime = Files.getLastModifiedTime(filePath);
            LocalDateTime lastModifiedTime = LocalDateTime.ofInstant(fileTime.toInstant(), ZoneId.systemDefault());

            // Вывод информации о сохраненном файле
            System.out.println("Файл успешно сохранен.");
            System.out.println("Размер файла: " + fileSize + " байт");
            System.out.println("Время записи: " + lastModifiedTime);

            // Поиск файла и чтение его содержимого
            System.out.print("Хотите прочитать содержимое файла? (да/нет): ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("да")) {
                // Проверка наличия файла
                if (Files.exists(filePath)) {
                    // Чтение содержимого файла
                    String content = new String(Files.readAllBytes(filePath));
                    System.out.println("Содержимое файла:");
                    System.out.println(content);
                } else {
                    System.out.println("Файл не найден.");
                }
            }

        } catch (IOException e) {
            // Обработка ошибок ввода-вывода
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        } catch (SecurityException e) {
            // Обработка ошибок безопасности
            System.out.println("Ошибка безопасности: " + e.getMessage());
        }
    }
}