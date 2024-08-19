package org.example;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultCamelContext;
import org.example.route.InvokeBeanRoute;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MockTest {

    @Autowired
    private InvokeBeanRoute invokeBeanRoute;

    @Test
    public void testMock() throws Exception {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:start")
                        .process(exchange -> System.out.println("Exchange body: " + exchange.getIn().getBody().toString()))
                        .to("mock:result");
            }
        });
        context.start();

        MockEndpoint mock = context.getEndpoint("mock:result", MockEndpoint.class);
        mock.expectedBodiesReceived("Hello World!");
        ProducerTemplate producerTemplate = context.createProducerTemplate();
        producerTemplate.sendBody("direct:start", "Hello World!");

        mock.assertIsSatisfied();

        context.stop();
    }

    @Test
    public void testMockBean() throws Exception {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(invokeBeanRoute);

        context.start();

        MockEndpoint mock = context.getEndpoint("mock:result", MockEndpoint.class);
        mock.expectedBodiesReceived("Hello World!");
        ProducerTemplate producerTemplate = context.createProducerTemplate();
        producerTemplate.sendBody("direct:hello", "World!");

        mock.assertIsSatisfied();

        context.stop();
    }

}
