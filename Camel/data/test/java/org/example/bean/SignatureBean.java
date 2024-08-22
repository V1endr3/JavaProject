package org.example.bean;

import cn.hutool.core.date.DateTime;
import cn.hutool.crypto.SecureUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SignatureBean implements Processor {
    private final static String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.setPattern(ExchangePattern.InOut);

        Message in = exchange.getIn();
        validate(in);
        Map<String, Object> oldHeaders = in.getHeaders();
        String timestamp = DateTime.now().toString(TIME_FORMAT);
        String appMethod = in.getHeader("appMethod", String.class);
        Map<String, Object> headers = buildHeaders(appMethod);
        headers.put("signature", signature(appMethod, timestamp));
        headers.forEach((k, v) -> exchange.getIn().setHeader(k, v));
    }

    private void validate(Message in) {
        // TODO
        log.info("Enter into signature validator");
    }

    public Map<String, Object> buildHeaders(String appMethod) {
        Map<String, Object> headers = new HashMap<>();

        headers.put("requestId", "1");
        headers.put("version", "v1.0");
        headers.put("appMethod", appMethod);
        headers.put("format", "json");
        headers.put("Content-Type", "application/json;charset=UTF-8");
        return headers;
    }

    private String signature(String appMethod, String timestamp) {
        String signStr = "v1.0" +
                appMethod +
                timestamp +
                "json";
        return SecureUtil.md5(signStr);
    }
}
