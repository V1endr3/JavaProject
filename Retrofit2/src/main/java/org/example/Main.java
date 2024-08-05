package org.example;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String url = "http://10.0.113.66:8088";
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl(url)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        HttpbinService httpbinService = retrofit.create(HttpbinService.class);
        CommonObj obj = new CommonObj();
        obj.setName("TEST-Name");
        obj.setCode(123);
        obj.setMessage("测试消息123");
        try {
            Response<Object> execute = httpbinService.getAnything(obj).execute();
            System.out.println(execute.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}