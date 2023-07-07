package com.example.universitylist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("search")
    public Call<List<UniName>> getUni(@Query("country") String country );
}
