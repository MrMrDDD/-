package com.example.cn.application.Service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;

import com.example.cn.application.LogUtils;

public class ServiceDemo extends Service {
    public ServiceDemo() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        // TODO: Return the communication channel to the service.
        return new LocalBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.Log("onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        LogUtils.Log("onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        LogUtils.Log("onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {

        return super.bindService(service, conn, flags);
    }

    public class LocalBinder extends Binder
    {
        public void Start()
        {
            LogUtils.Log("LocalBinderStart");
        }
        public void Stop()
        {
            LogUtils.Log("LocalBinderStop");
        }
    }
}
