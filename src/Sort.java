import java.util.Arrays;

/**
 * Класс Sort содержит методы для работы с динамическим массивом целых чисел.
 * Методы включают добавление элементов, сортировку массива и вывод его содержимого.
 */
public class Sort {
    // Начальная емкость массива, изначально установлена на 2
    static int initialCapacity = 2;
    // Текущий размер массива, изначально равен 0
    static int currentSize = 0;
    // Массив для хранения данных
    static int[] data = new int[initialCapacity];

    /**
     * Основной метод программы, демонстрирующий добавление элементов в массив,
     * сортировку и вывод содержимого массива.
     *
     * @param args Аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Добавляем элементы в массив с использованием метода add
        add(4);
        add(3);
        add(1);
        add(5);
        add(2);
        add(7);
        add(6);
        add(8);
        add(9);
        add(0);

        // Выводим содержимое массива до сортировки
        System.out.println("Массив до сортировки:");
        print(); // Ожидаемый вывод: [ 4 3 1 5 2 7 6 8 9 0 ]

        // Сортируем массив
        sort();

        // Выводим содержимое массива после сортировки
        System.out.println("Массив после сортировки:");
        print(); // Ожидаемый вывод: [ 0 1 2 3 4 5 6 7 8 9 ]
    }

    /**
     * Метод сортировки массива целых чисел с использованием алгоритма сортировки пузырьком.
     * Сортировка происходит в порядке возрастания.
     */
    static void sort() {
        boolean swapped;
        for (int i = 0; i < currentSize - 1; i++) {
            swapped = false;
            for (int j = 0; j < currentSize - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Метод вывода содержимого массива на экран.
     * Выводит элементы массива в квадратных скобках, разделенные пробелами.
     */
    static void print() {
        if (currentSize == 0) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < currentSize; i++) {
            if (i > 0) {
                sb.append(" ");
            }
            sb.append(data[i]);
        }
        sb.append(" ]");
        System.out.println(sb);
    }

    /**
     * Метод добавления элемента в массив.
     * Если массив заполнен, увеличивает его размер.
     *
     * @param value Значение, которое нужно добавить в массив
     */
    static void add(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Значение не может быть отрицательным");
        }
        if (currentSize >= data.length) {
            initialCapacity *= 2;
            int[] temp = Arrays.copyOf(data, currentSize);
            data = new int[initialCapacity];
            System.arraycopy(temp, 0, data, 0, temp.length);
        }
        data[currentSize] = value;
        currentSize++;
    }
}