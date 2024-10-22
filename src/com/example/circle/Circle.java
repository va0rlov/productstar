package com.example.circle;

public class Circle {
    private double radius;

    // Конструктор, который заполняет поле radius
    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть больше нуля");
        }
        this.radius = radius;
    }

    // Геттер для радиуса
    public double getRadius() {
        return radius;
    }

    // Сеттер для радиуса с проверкой на положительность
    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть больше нуля");
        }
        this.radius = radius;
    }

    // Метод для вычисления площади круга
    public double getArea() {
        return Math.PI * radius * radius;
    }
}