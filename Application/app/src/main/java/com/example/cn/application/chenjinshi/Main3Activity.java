package com.example.cn.application.chenjinshi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.example.cn.application.R;

public class Main3Activity extends AppCompatActivity {

    private static final String TAG = "Main_test3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    @Override
    protected void onStart() {
        super.onStart();
        LOG("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LOG("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LOG("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LOG("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LOG("onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LOG("onRestart");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LOG("onSaveInstanceState");
    }

    private void LOG(String msg) {
        Log.d(TAG, msg);
    }
}
