package com.collections.students;

public class Command {
    private final Action action;
    private String data;

    public Command(Action action, String data) {
        this.action = action;
        this.data = data;
    }

    public Command(Action action) {
        this.action = action;
    }


    /**
     * Возвращает тип действия, которое хранится в этом объекте
     *
     * @return тип действия
     */
    public Action getAction() {
        return action;
    }

    /**
     * Возвращает строку, которая хранится в этом объекте
     *
     * @return строка, хранящаяся в этом объекте
     */
    public String getData() {
        return data != null ? data : "";
    }
}