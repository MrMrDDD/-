package com.example.cn.contentpro.RxJava;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.Toast;

import ModelViewPresenter.BaseActivity;

public class RxActivity extends BaseActivity<IRxView, RxPresenter<IRxView>> implements IRxView {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.fetchText();
        ImageView view = new ImageView(this);
        view.setOnClickListener(v->{

        });
    }

    @Override
    public void ShowText(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected RxPresenter createpresenter() {
        return new RxPresenter(this);
    }
}
