package com.example.test.first;

import android.util.Log;

import z1w3.mvp.support.BasePresenter;
import z1w3.mvp.support.annotations.Singleton;

@Singleton
public class SinglePresenterImpl extends BasePresenter implements SinglePresenter{

    private Object value;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "SinglePresenterImpl >> onCreate()" + "context=" + getContext());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "SinglePresenterImpl >> onDestroy()" + ", context=" + getContext());
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }
}