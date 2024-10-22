/**
 * Исключение, которое выбрасывается, если на счету недостаточно средств для снятия.
 */
class InsufficientAmountException extends Exception {

    /**
     * Конструктор по умолчанию.
     */
    public InsufficientAmountException() {
    }

    /**
     * Конструктор с сообщением об ошибке.
     *
     * @param message Сообщение об ошибке.
     */
    public InsufficientAmountException(String message) {
        super(message);
    }
}
