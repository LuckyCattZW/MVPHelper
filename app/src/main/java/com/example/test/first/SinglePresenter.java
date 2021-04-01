package com.example.test.first;

import z1w3.mvp.support.annotations.PresenterAPI;

@PresenterAPI
public interface SinglePresenter {

    Object getValue();
    void setValue(Object content);
}
