package org.example;

import org.apache.camel.spring.Main;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CamelSpringMain {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/camel-kafka.xml");
        main.setApplicationContext(context);
        main.run();
    }
}
