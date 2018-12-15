package com.example.cn.bt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aispeech.ailog.AILog;
import com.aispeech.dui.dds.DDS;
import com.aispeech.dui.dds.DDSAuthListener;
import com.aispeech.dui.dds.DDSConfig;
import com.aispeech.dui.dds.DDSInitListener;
import com.aispeech.dui.dds.auth.AuthType;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt_begin;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_begin = findViewById(R.id.bt_begin);
        bt_begin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_begin:
                startDDS();
                break;
        }
    }

    private void startDDS() {
        DDS.getInstance().init(getApplicationContext(),
                new DDSConfig()
                        .addConfig(DDSConfig.K_PRODUCT_ID, "278576010")
                        .addConfig(DDSConfig.K_USER_ID, "")
                        .addConfig(DDSConfig.K_ALIAS_KEY, "test")
                        .addConfig(DDSConfig.K_AUTH_TYPE, AuthType.PROFILE)
                        .addConfig(DDSConfig.K_API_KEY,"5d2520d50b2beb650446b0b85c138ed4"),
                new DDSInitListener() {
                    @Override
                    public void onInitComplete(boolean isFull) {
                        AILog.d(TAG, "onInitComplete: " + isFull);
                    }

                    @Override
                    public void onError(int what, String msg) {
                        AILog.d(TAG, "onError: " + what + ", error: " + msg);
                    }
                }, new DDSAuthListener() {
                    @Override
                    public void onAuthSuccess() {
                        AILog.d(TAG, "onAuthSuccess");
                    }

                    @Override
                    public void onAuthFailed(String errId, String error) {
                        AILog.d(TAG, "onAuthFailed: " + errId + ", error:" + error);
                    }
                });
    }
}
