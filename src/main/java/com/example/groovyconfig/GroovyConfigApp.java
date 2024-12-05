package com.example.groovyconfig;

import org.springframework.context.support.GenericGroovyApplicationContext;

public class GroovyConfigApp {

    public static void main(String[] args) {
        GenericGroovyApplicationContext context = new GenericGroovyApplicationContext("classpath:applicationContext.groovy");

        SingletonBean singletonBean1 = context.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = context.getBean(SingletonBean.class);
        System.out.println("Singleton Bean 1: " + singletonBean1);
        System.out.println("Singleton Bean 2: " + singletonBean2);

        PrototypeBean prototypeBean1 = context.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean2 = context.getBean(PrototypeBean.class);
        System.out.println("Prototype Bean 1: " + prototypeBean1);
        System.out.println("Prototype Bean 2: " + prototypeBean2);

        context.close();
    }
}