package com.example.developerslife.database;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService mInstance;
    private static final String BASE_URL = "https://developerslife.ru";
    private Retrofit mRetrofit;
    private final DevelopersLifeApi mJSONApi;

    public NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mJSONApi = mRetrofit.create(DevelopersLifeApi.class);
    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }

    public DevelopersLifeApi getJSONApi() {
        return mJSONApi;
    }

    public static NetworkService from(Context context) {
        return ApplicationModified.from(context).getApis();
    }
}
