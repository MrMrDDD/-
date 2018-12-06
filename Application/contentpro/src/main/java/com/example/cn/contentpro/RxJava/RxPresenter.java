package com.example.cn.contentpro.RxJava;

import ModelViewPresenter.Basepresenter;

public class RxPresenter<T> extends Basepresenter<IRxView> {

    private IRxView rxView;
    private RxMode mode = new RxMode();

    public RxPresenter(IRxView rxView) {

        this.rxView = rxView;
    }

    public void fetchText() {
        rxView.ShowText("load");

    }

}
