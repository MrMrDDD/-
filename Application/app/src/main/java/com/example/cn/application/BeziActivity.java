package com.example.cn.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.cn.application.View.MyGradientView;
import com.example.cn.application.View.ProgressView;
import com.example.cn.application.View.WaveView;

public class BeziActivity extends AppCompatActivity {

    WaveView bz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezi);
//        MyGradientView gradientView=new MyGradientView(this);
//        setContentView(new ProgressView(this));
//        setContentView(R.layout.activity_bezi);
//        bz=findViewById(R.id.bz);
//        bz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                bz.startAnimation();
//            }
//        });
    }
}
