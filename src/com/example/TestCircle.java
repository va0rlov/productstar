package com.example;

import com.example.circle.Circle;

public class TestCircle {

    private boolean compareDouble(double a, double b) {
        double EPSILON = 0.00001;
        return Math.abs(a - b) < EPSILON;
    }

    private void testCreateCircle() {
        Circle circle = new Circle(10);
        double radius = circle.getRadius();
        if (compareDouble(radius, 10.0)) {
            System.out.println("testCreateCircle: OK");
        } else {
            System.out.println("testCreateCircle: FAILURE");
        }
    }

    private void testSetRadius() {
        Circle circle = new Circle(1);
        if (!compareDouble(circle.getRadius(), 1)) {
            System.out.println("testSetRadius: FAILURE: expected getRadius() = 1, got " + circle.getRadius());
            return;
        }
        circle.setRadius(2.0);
        if (!compareDouble(circle.getRadius(), 2)) {
            System.out.println("testSetRadius: FAILURE: expected r = 2, got " + circle.getRadius());
        } else {
            System.out.println("testSetRadius: OK");
        }
    }

    private void testGetArea() {
        Circle circle = new Circle(2);
        if (compareDouble(circle.getArea(), Math.PI * 4)) {
            System.out.println("testGetArea: OK");
        } else {
            System.out.println("testGetArea: FAILURE");
        }
    }

    private void testCreateCircleWithNegativeRadius() {
        try {
            Circle circle = new Circle(-10);
            System.out.println("testCreateCircleWithNegativeRadius: FAILURE: Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("testCreateCircleWithNegativeRadius: OK");
        }
    }

    private void testSetNegativeRadius() {
        Circle circle = new Circle(1);
        try {
            circle.setRadius(-2.0);
            System.out.println("testSetNegativeRadius: FAILURE: Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("testSetNegativeRadius: OK");
        }
    }

    private void testSetZeroRadius() {
        Circle circle = new Circle(1);
        try {
            circle.setRadius(0);
            System.out.println("testSetZeroRadius: FAILURE: Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("testSetZeroRadius: OK");
        }
    }

    public void test() {
        testCreateCircle();
        testSetRadius();
        testGetArea();
        testCreateCircleWithNegativeRadius();
        testSetNegativeRadius();
        testSetZeroRadius();
    }

    public static void main(String[] args) {
        TestCircle testCircle = new TestCircle();
        testCircle.test();
    }
}