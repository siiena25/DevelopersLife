package com.example.developerslife.database;

import com.example.developerslife.models.Posts;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DevelopersLifeApi {
    @GET("https://developerslife.ru/latest/{page}?json=true")
    public Call<Posts> getLatestPostsWithPage(@Path("page") int page);
}
