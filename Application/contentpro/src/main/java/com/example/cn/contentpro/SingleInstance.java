package com.example.cn.contentpro;

import android.content.Context;

public class SingleInstance {

    private Context context;
    private static SingleInstance instance;

    private SingleInstance(Context context) {

        this.context = context;
    }

    public static SingleInstance getInstance(Context context) {
        if (instance == null) {
            instance = new SingleInstance(context);
        }
        return instance;
    }
}
