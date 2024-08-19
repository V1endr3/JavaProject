package org.example.route;

import org.apache.camel.builder.RouteBuilder;
import org.example.bean.HelloBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InvokeBeanRoute extends RouteBuilder {
    @Autowired
    private HelloBean helloBean;

    @Override
    public void configure() throws Exception {
        from("direct:hello")
                .bean(helloBean, "hello")
                .process(exchange -> System.out.println(exchange.getIn().getBody()))
                .to("mock:result");
    }
}
