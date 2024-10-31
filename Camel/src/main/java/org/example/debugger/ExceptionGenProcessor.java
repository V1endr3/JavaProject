package org.example.debugger;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ExceptionGenProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        throw new RuntimeException("模拟执行异常");
    }
}
