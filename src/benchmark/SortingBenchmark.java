package benchmark;

import sorting.BubbleSort;
import sorting.MergeSort;

import java.util.Arrays;
import java.util.Random;

public class SortingBenchmark {
    public static void runBenchmark() {
        int[] array = generateRandomArray(100_000);
        int[] arrayCopy;

        // Bubble Sort
        System.out.println("\nBubble Sort is in progress... ");
        arrayCopy = Arrays.copyOf(array, array.length);
        long startTime = System.currentTimeMillis();
        BubbleSort.sort(arrayCopy);
        long endTime = System.currentTimeMillis();
        System.out.println("Bubble Sort time: " + (endTime - startTime) + " ms");

        // Merge Sort
        System.out.println("\nMerge Sort is in progress... ");
        arrayCopy = Arrays.copyOf(array, array.length);
        startTime = System.currentTimeMillis();
        MergeSort.sort(arrayCopy);
        endTime = System.currentTimeMillis();
        System.out.println("Merge Sort time: " + (endTime - startTime) + " ms");

        // Arrays.sort()
        System.out.println("\nArrays.sort() is in progress... ");
        arrayCopy = Arrays.copyOf(array, array.length);
        startTime = System.currentTimeMillis();
        Arrays.sort(arrayCopy);
        endTime = System.currentTimeMillis();
        System.out.println("Arrays.sort() time: " + (endTime - startTime) + " ms");
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }
}