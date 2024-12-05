package com.example.groovyconfig;

public class SingletonBean {
    public SingletonBean() {
        System.out.println("SingletonBean created");
    }

    @Override
    public String toString() {
        return "SingletonBean@" + Integer.toHexString(hashCode());
    }
}