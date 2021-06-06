package com.example.developerslife.database;

import android.app.Application;
import android.content.Context;

public class ApplicationModified extends Application {

    private NetworkService networkService;

    @Override
    public void onCreate() {
        super.onCreate();
        networkService = new NetworkService();
    }

    public NetworkService getApis() {
        return networkService;
    }

    public static ApplicationModified from(Context context) {
        return (ApplicationModified) context.getApplicationContext();
    }
}
