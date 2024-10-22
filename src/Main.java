/**
 * Главный класс программы, который содержит логику работы с банковским аккаунтом.
 */
public class Main {

    /**
     * Имя владельца банковского аккаунта.
     */
    public static String accountName = "MyAcc";

    /**
     * Текущая сумма на банковском счету.
     */
    public static int amount = 10000;

    /**
     * Главный метод программы, который демонстрирует работу с банковским аккаунтом.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        try {
            // Снимаем небольшую сумму (успешно)
            System.out.println("Withdrawing 900 from MyAcc: " + deduct("MyAcc", 900));
        } catch (InsufficientAmountException e) {
            // Обработка исключения, если недостаточно средств на счету
            System.out.println("Error: " + e.getMessage());
        } catch (AccessDeniedException e) {
            // Обработка исключения, если имя аккаунта не совпадает
            System.out.println("Error: " + e.getMessage());
        }
        try {
            // Снимаем больше, чем осталось (Exception)
            System.out.println("Withdrawing 10000 from MyAcc: " + deduct("MyAcc", 10000));
        } catch (InsufficientAmountException e) {
            // Обработка исключения, если недостаточно средств на счету
            System.out.println("Error: " + e.getMessage());
        } catch (AccessDeniedException e) {
            // Обработка исключения, если имя аккаунта не совпадает
            System.out.println("Error: " + e.getMessage());
        }
        try {
            // Пытаемся снять с чужого аккаунта (RuntimeException)
            System.out.println("Withdrawing 100 from AnotherAcc: " + deduct("AnotherAcc", 100));
        } catch (InsufficientAmountException e) {
            // Обработка исключения, если недостаточно средств на счету
            System.out.println("Error: " + e.getMessage());
        } catch (AccessDeniedException e) {
            // Обработка исключения, если имя аккаунта не совпадает
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Метод для снятия денег со счета.
     *
     * @param accountToProcess Имя аккаунта, с которого производится снятие.
     * @param amtToCacheOut    Сумма, которую нужно снять.
     * @return Остаток на счету после снятия.
     * @throws InsufficientAmountException Если на счету недостаточно средств для снятия.
     */
    public static int deduct(String accountToProcess, int amtToCacheOut) throws InsufficientAmountException {
        // Проверка, совпадает ли имя аккаунта с переданным именем
        if (!accountName.equals(accountToProcess)) {
            // Выбрасываем исключение, если имена не совпадают
            throw new AccessDeniedException("Provided account doesn't match the target one");
        }

        // Проверка, достаточно ли средств на счету для снятия запрошенной суммы
        if (amount < amtToCacheOut) {
            // Выбрасываем исключение, если средств недостаточно
            throw new InsufficientAmountException("Not enough money to withdraw " + amtToCacheOut);
        }

        // Вычитаем запрошенную сумму из текущего баланса
        amount = amount - amtToCacheOut;

        // Возвращаем остаток на счету
        return amount;
    }
}

