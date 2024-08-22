package org.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:bean/*.xml")
public class CamelSpringBootMain {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(CamelSpringBootMain.class, args);
    }
}
