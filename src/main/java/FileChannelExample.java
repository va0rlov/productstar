import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelExample {

    private static final String fileName = "text.txt";

    // Метод для записи текста в файл
    private static void write() {
        Path filePath = Paths.get(fileName);

        // Создание файла и получение канала для записи
        try (FileChannel fileChannel = FileChannel.open(
                filePath,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE
        )) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // Бесконечный цикл для ввода текста
            while (true) {
                String input = System.console().readLine();
                // Проверка на пустую строку
                if (input.isEmpty()) {
                    break;
                }

                // Добавляем перевод строки после каждого введенного текста
                input += System.lineSeparator();

                buffer.clear();
                buffer.put(input.getBytes());
                buffer.flip();

                // Запись текста в файл
                while (buffer.hasRemaining()) {
                    fileChannel.write(buffer);
                }

                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для чтения текста из файла
    private static void read() {
        Path filePath = Paths.get(fileName);

        // Получение канала для чтения
        try (FileChannel fileChannel = FileChannel.open(
                filePath,
                StandardOpenOption.READ
        )) {
            // Получение размера файла
            long fileSize = fileChannel.size();

            // Создание буфера для чтения
            ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);

            // Чтение данных из файла в буфер
            fileChannel.read(buffer);

            // Подготовка буфера для чтения
            buffer.flip();

            // Преобразование байтов в строку и вывод на консоль
            System.out.println(new String(buffer.array()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        write();
        read();
    }
}