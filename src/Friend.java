/**
 * Класс Friend представляет собой объект, описывающий друга.
 * Он содержит поля для имени, возраста, признака друга из школы, времени, проведенного вместе за последнюю неделю и марки машины.
 */
public class Friend {
    /**
     * Имя друга.
     */
    private final String name;

    /**
     * Возраст друга.
     */
    private final int age;

    /**
     * Признак друга из школы.
     */
    private final boolean isFriendFromSchool;

    /**
     * Время, проведенное вместе за последнюю неделю.
     */
    private final float hoursSpentTogetherLastWeek;

    /**
     * Марка машины друга.
     */
    private final String carBrand;

    /**
     * Конструктор класса Friend.
     *
     * @param name                       Имя друга.
     * @param age                        Возраст друга.
     * @param isFriendFromSchool         Признак друга из школы.
     * @param hoursSpentTogetherLastWeek Время, проведенное вместе за последнюю неделю.
     * @param carBrand                   Марка машины друга.
     */
    public Friend(String name, int age, boolean isFriendFromSchool, float hoursSpentTogetherLastWeek, String carBrand) {
        // Инициализация полей класса Friend
        this.name = name;
        this.age = age;
        this.isFriendFromSchool = isFriendFromSchool;
        this.hoursSpentTogetherLastWeek = hoursSpentTogetherLastWeek;
        this.carBrand = carBrand;
    }

    /**
     * Точка входа в программу.
     *
     * @param args Аргументы командной строки.
     */
    public static void main(String[] args) {
        // Инициализация массива на этапе объявления
        // Создание массива объектов Friend и инициализация его элементов
        Friend[] friends = new Friend[]{
                new Friend("Иван", 25, true, 10.5f, "Toyota"),
                new Friend("Петр", 30, false, 5.0f, "Honda"),
                new Friend("Сергей", 28, true, 8.0f, "Ford")
        };

        // Вывод данных на экран
        // Цикл для вывода информации о друзьях
        for (Friend friend : friends) {
            // Вывод информации о каждом друге
            System.out.println(friend.toString());
        }

        // Добавление еще нескольких друзей в массив
        // Создание нового массива объектов Friend с увеличенным размером
        Friend[] newFriends = new Friend[friends.length + 2];
        // Копирование элементов из исходного массива в новый
        System.arraycopy(friends, 0, newFriends, 0, friends.length);
        // Добавление новых друзей в конец массива
        newFriends[friends.length] = new Friend("Алексей", 22, false, 6.0f, null);
        newFriends[friends.length + 1] = new Friend("Дмитрий", 35, true, 12.0f, "BMW");

        // Вывод новых добавленных данных на экран
        // Цикл для вывода информации о новых друзьях
        for (Friend friend : newFriends) {
            // Вывод информации о каждом друге
            System.out.println(friend.toString());
        }
    }

    /**
     * Переопределенный метод toString для вывода информации о друге.
     *
     * @return Строка с информацией о друге.
     */
    @Override
    public String toString() {
        // Формирование строки с информацией о друге
        if (carBrand == null) {
            return "Имя: " + name + ", Возраст: " + age + ", Друг из школы: " + isFriendFromSchool + ", Время, проведенное вместе за последнюю неделю: " + hoursSpentTogetherLastWeek + " часов, Машины нет";
        } else {
            return "Имя: " + name + ", Возраст: " + age + ", Друг из школы: " + isFriendFromSchool + ", Время, проведенное вместе за последнюю неделю: " + hoursSpentTogetherLastWeek + " часов, Марка машины: " + carBrand;
        }
    }
}
