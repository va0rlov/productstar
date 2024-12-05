package com.example.xmlconfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigApp {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

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