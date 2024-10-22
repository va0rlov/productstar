/**
 * Исключение, которое выбрасывается, если имя аккаунта не совпадает с ожидаемым.
 */
class AccessDeniedException extends RuntimeException {

    /**
     * Конструктор по умолчанию.
     */
    public AccessDeniedException() {
    }

    /**
     * Конструктор с сообщением об ошибке.
     *
     * @param message Сообщение об ошибке.
     */
    public AccessDeniedException(String message) {
        super(message);
    }
}
