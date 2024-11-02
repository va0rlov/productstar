package main;

import listperformance.ListAccessTimer;
import listperformance.ListCreator;
import listperformance.ListFiller;

import java.util.List;

/**
 * Главный класс для запуска программы.
 */
public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр для создания списков
        ListCreator creator = new ListCreator();
        List<Integer>[] lists = creator.createLists();

        // Создаем экземпляр для заполнения списков
        ListFiller filler = new ListFiller();
        filler.fillLists(lists);

        // Создаем экземпляр для замера времени доступа
        ListAccessTimer timer = new ListAccessTimer();

        // Замеряем время доступа к элементам в ArrayList
        long arrayListTime = timer.measureArrayListAccessTime(lists[0]);
        System.out.println("Время доступа к элементам в ArrayList: " + arrayListTime + " нс");

        // Замеряем время доступа к элементам в LinkedList
        long linkedListTime = timer.measureLinkedListAccessTime(lists[1]);
        System.out.println("Время доступа к элементам в LinkedList: " + linkedListTime + " нс");
    }
}
