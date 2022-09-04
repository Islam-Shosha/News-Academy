package com.example.apiapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.apiapi.models.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //https://newsapi.org/v2/top-headlines?country=eg&category=business&apiKey=a51db7b6e0874bf4935ce66771636cc9
    //base Url : https://newsapi.org/
    //end Url : v2/top-headlines?country=eg&category=business&apiKey=a51db7b6e0874bf4935ce66771636cc9
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv_news);

//        Retrofit retrofit =new Retrofit.Builder()
//                .baseUrl("https://newsapi.org/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        IApi iApi = RetrofitClient.getInstance().create(IApi.class);
        RetrofitClient.getInstance().getNews("eg","science").enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                NewsAdapter newsAdapter = new NewsAdapter(response.body().getArticles());
                recyclerView.setAdapter(newsAdapter);

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                System.out.println(t.getLocalizedMessage());

            }
        });

    }
}