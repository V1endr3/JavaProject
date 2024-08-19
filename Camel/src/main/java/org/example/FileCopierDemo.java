package org.example;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FileCopierDemo {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                from("file:Camel/data/inbox?noop=true")
                        .choice()
                        .when(simple("${header.CamelFileName} ends with 'xml'"))
                        .log("Receive XML file: ${header.CamelFileName}")
                        .when(simple("${header.CamelFileName} ends with 'csv'"))
                        .log("Receive CSV file: ${header.CamelFileName}")
                        .to("file:Camel/data/outbox");
            }
        });

        context.start();
        Thread.sleep(10000);

        context.stop();
    }
}
