package com.example.test.first;

import android.util.Log;

import z1w3.mvp.support.BasePresenter;

public class FirstPresenterImpl extends BasePresenter implements FirstPresenter{
    private FirstViewAPI firstViewAPI;

    private int number = 0;
    private SinglePresenter singlePresenter;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "FirstPresenterImpl >> onCreate()" + "context=" + getContext());
        final Object viewAPI = getViewAPI();
        if (viewAPI != null) {
            if (viewAPI instanceof FirstViewAPI) {
                firstViewAPI = (FirstViewAPI) viewAPI;
            }
        }
        singlePresenter = getOtherPresenterAPI(SinglePresenter.class);
        Log.e("TAG", "singlePresenter="+singlePresenter);
        final Object value = singlePresenter.getValue();
        number = value != null ? (Integer)value : 0;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "FirstPresenterImpl >> onDestroy()" + "context=" + getContext());
    }


    @Override
    public void fetchText() {

        if (firstViewAPI != null) {
            ++number;
            firstViewAPI.setText("触发了 MyPresenter#fetchText() Fragment" + number);
            singlePresenter.setValue(number);
        }
    }
}