package org.example.aggregate;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePropertyKey;

import java.util.ArrayList;
import java.util.List;

public class ApplyConcreteStrategy implements AggregationStrategy {
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        String targetEndpoint = newExchange.getIn().getHeader("EipDestEndpoint", String.class);
        String endpoint = String.valueOf(newExchange.getProperty(ExchangePropertyKey.TO_ENDPOINT));
        if (targetEndpoint == null || targetEndpoint.isBlank()) {
            return appendBody(oldExchange, newExchange);
        }
        if (endpoint.equalsIgnoreCase(targetEndpoint)) {
            return appendBody(oldExchange, newExchange);
        } else {
            return oldExchange;
        }
    }

    private Exchange appendBody(Exchange oldExchange, Exchange newExchange) {
        Exchange exchange = newExchange.copy();
        List<Object> list = new ArrayList<>();
        if (oldExchange == null) {
            list.add(newExchange.getIn().getBody());
        } else {
            list = (List<Object>) oldExchange.getIn().getBody();
            list.add(newExchange.getIn().getBody());
        }
        exchange.getIn().setBody(list);
        return exchange;
    }
}
