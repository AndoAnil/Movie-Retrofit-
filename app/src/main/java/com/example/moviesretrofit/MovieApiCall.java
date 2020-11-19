package com.example.moviesretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApiCall {

    @GET("v3/36c40d90-14ea-4381-a39e-28b54d71e1d4")
    Call<List<Movie>> getMovie();
}
