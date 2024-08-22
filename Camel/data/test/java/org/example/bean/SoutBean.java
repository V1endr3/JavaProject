package org.example.bean;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class SoutBean implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println(exchange.getIn().getBody());
    }
}
