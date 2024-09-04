package org.example;

import org.apache.camel.spring.Main;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class CamelSpringMain {
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("file:/local/camel-run.xml");
        main.setApplicationContext(context);
        main.run();
    }
}
