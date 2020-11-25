package com.example.moviesretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //https://run.mocky.io/v3/36c40d90-14ea-4381-a39e-28b54d71e1d4
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private List<Movie> movieList;
    private Context context=MainActivity.this;


    /*new apk
    //https://run.mocky.io/v3/38f55cac-d1a6-483e-9cdf-55435c80e109
   */

    /* Nested object
    https://run.mocky.io/v3/6360ab61-dfcf-4af1-b7b2-ee52d9081d7a
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        movieList=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        //Interface instances
        MovieApiCall movieApiCall=retrofit.create(MovieApiCall.class);


        Call<JsonResponse> call=movieApiCall.getMovie();

        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                JsonResponse jsonResponse=response.body();
                movieList=new ArrayList<>(Arrays.asList(jsonResponse.getMoviz()));
                putDataIntoRecyclerView(movieList);
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    /*    Call<List<movies>> call=movieApiCall.getMovie();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(response.code() !=200)
                {
                    //handle error and display it
                    return;
                }

                List<Movie> movies=response.body();
                for(Movie movie:movies)
                {
                    movieList.add(movie);
                }

                /*adapter=new Adapter(context,movieList);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

                putDataIntoRecyclerView(movieList);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
         */


    }


    private void putDataIntoRecyclerView(List<Movie> movieList) {
        MovieAdapter movieAdapter=new MovieAdapter(context,movieList);
        recyclerView.setAdapter(movieAdapter);
        movieAdapter.notifyDataSetChanged();
    }
}