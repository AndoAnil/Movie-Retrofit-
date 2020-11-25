package com.example.moviesretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApiCall {

    @GET("v3/6360ab61-dfcf-4af1-b7b2-ee52d9081d7a")
    Call<JsonResponse> getMovie();
}
