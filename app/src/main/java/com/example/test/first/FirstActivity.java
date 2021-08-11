package com.example.test.first;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.test.BaseActivity;
import com.example.test.R;

import z1w3.mvp.support.annotations.InjectPresenter;


@InjectPresenter(value = {SinglePresenterImpl.class, FirstPresenterImpl.class})
public class FirstActivity extends BaseActivity implements FirstViewAPI {
    private TextView textView;
    private Button fragmentBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_first);
        textView = findViewById(R.id.text_view);
        findViewById(R.id.finish_btn).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });
        fragmentBtn = findViewById(R.id.fragment_btn);
        fragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenterAPI(FirstPresenter.class).fetchText();
            }
        });
    }

    @Override
    public void setText(String content) {
        textView.setText(content);
    }
}