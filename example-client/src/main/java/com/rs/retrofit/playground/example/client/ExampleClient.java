package com.rs.retrofit.playground.example.client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ExampleClient {

    @GET("hello")
    Call<String> sayHello();

    @GET("hi")
    Call<String> sayHiToName(@Query("name") String name);

}
