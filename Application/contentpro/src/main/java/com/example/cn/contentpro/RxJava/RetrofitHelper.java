package com.example.cn.contentpro.RxJava;

import android.content.Context;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static RetrofitHelper instance;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient = new OkHttpClient();
    private GsonConverterFactory gsonConverterFactory = GsonConverterFactory
            .create(new GsonBuilder().create());

    public static RetrofitHelper getInstance() {
        if (instance == null) {
            instance = new RetrofitHelper();
        }
        return instance;
    }

    private RetrofitHelper() {
        init();
    }

    private void init() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public NetBook getNetBook() {
        return retrofit.create(NetBook.class);
    }


}
