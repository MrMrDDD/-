package com.example.cn.contentpro.RxJava;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RxMode {

    public String GetBooKInfo() {

//        配置好Retrofit信息
//        1.BaseUrl
//        2.转换工厂（Gson）
//        3.添加Rxjava适配器
//
//        Retrofit mRetrofit = new Retrofit.Builder()
//                .baseUrl("https://api.douban.com/v2/")
//                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        NetBook netBook = mRetrofit.create(NetBook.class);
//        没有使用RxJava的方式
//        Call<BookInfo> call = netBook.Getsearch("金瓶梅", null, "0", "1");
//
//        call.enqueue(getCallback());
//        Observable<BookInfo> observable=netBook.Getsearch("金瓶梅", null, "0", "1");
//        observable.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<BookInfo>() {
//                    @Override
//                    public void onCompleted() {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onNext(BookInfo bookInfo) {
//
//                    }
//                });





        return "xx";
    }



}
