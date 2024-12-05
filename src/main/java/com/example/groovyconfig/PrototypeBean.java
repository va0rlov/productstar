package com.example.groovyconfig;

public class PrototypeBean {
    public PrototypeBean() {
        System.out.println("PrototypeBean created");
    }

    @Override
    public String toString() {
        return "PrototypeBean@" + Integer.toHexString(hashCode());
    }
}