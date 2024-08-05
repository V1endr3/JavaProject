package org.example;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

public interface HttpbinService {
    @Multipart
    @POST("/anything/get")
    Call<Object> getAnything(@Body CommonObj common);
}
