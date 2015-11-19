package com.clayons.interviewquestions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class DetailActivity extends AppCompatActivity {
    public static final String KEY_INDEX = "detail-index";
    private DetailPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new DetailPresenter(new DetailModel(), new DetailView());
        mPresenter.onCreate(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume(this);
    }
}
