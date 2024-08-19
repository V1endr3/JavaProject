package org.example.bean;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {
    public String hello(String name) {
        return String.format("Hello %s", name);
    }
}
