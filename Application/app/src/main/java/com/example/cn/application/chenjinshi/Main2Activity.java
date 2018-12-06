package com.example.cn.application.chenjinshi;

import android.animation.Animator;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;

import com.example.cn.application.R;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "Main_test2";
    AppCompatImageButton bt;
    Handler handler=new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_NO_TITLE|Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        LOG("onCreate");

        ViewGroup
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    Animator animator= ViewAnimationUtils.createCircularReveal(bt,0,0,0,bt.getHeight());
//                    animator.setDuration(2000);
//                    animator.setInterpolator(new AccelerateInterpolator());
//                    animator.start();
                }

            }
        });
    }

    private void start() {
        ActivityOptionsCompat optionsCompat=
        ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                Pair.<View, String>create(bt,"bt"));
        startActivity(new Intent(this,Main3Activity.class),optionsCompat.toBundle());
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
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LOG("onCreate");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LOG("onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LOG("onRestoreInstanceState");

    }

    private void LOG(String msg) {
        Log.d(TAG, msg);
    }
}
