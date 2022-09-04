package com.example.apiapi;

import com.example.apiapi.models.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApi {
 @GET("v2/top-headlines?country=eg&category=business&apiKey=a51db7b6e0874bf4935ce66771636cc9")
 Call<Example>getNews();

 @GET("v2/top-headlines?apiKey=a51db7b6e0874bf4935ce66771636cc9")
 Call<Example>getNews(@Query("country")String country
                      ,@Query("category")String category);

}
