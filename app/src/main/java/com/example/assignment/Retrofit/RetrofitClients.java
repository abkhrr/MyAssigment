package com.example.assignment.Retrofit;

import com.example.assignment.networks.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClients {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://abkhrr.com/assesment/";

    public static Api getService() {

        if (retrofit == null) {

            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Api.class);
    }
}
