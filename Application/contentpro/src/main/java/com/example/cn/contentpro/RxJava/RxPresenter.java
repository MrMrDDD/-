package com.example.cn.contentpro.RxJava;

import ModelViewPresenter.Basepresenter;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RxPresenter<T> extends Basepresenter<IRxView> {

    private IRxView rxView;
    private RxMode mode = new RxMode();

    public RxPresenter(IRxView rxView) {

        this.rxView = rxView;
    }

    public void fetchText() {
        DataManager dataManager = new DataManager();
        Subscription subscription = dataManager
                .Getsearch("金瓶梅", null, "0", "1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BookInfo bookInfo) {
                        rxView.ShowText(bookInfo.toString());


                    }
                });


    }

}
