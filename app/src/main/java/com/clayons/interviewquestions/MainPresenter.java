package com.clayons.interviewquestions;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.clayons.interviewquestions.Model.Person;

/**
 * Created by pranavbhalla on 11/19/15.
 */
public class MainPresenter {
    private final MainModel mModel;
    private final MainView mView;

    private Context mContext;

    private final OnItemSelected mOnItemSelected = new OnItemSelected() {
        @Override
        public void onSelected(int index) {
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra(DetailActivity.KEY_INDEX, index);
            mContext.startActivity(intent);
        }
    };

    public MainPresenter(final MainModel model, final MainView view) {
        mModel = model;
        mView = view;
    }

    public void onCreate(final AppCompatActivity activity) {
        mContext = activity;
        mView.onCreate(activity);
        mView.setOnItemSelectedListener(mOnItemSelected);
    }

    public void onResume(MainActivity mainActivity) {
        render();
    }

    private void render() {
        mView.drawPeopleList(mModel.getPeople());
    }
}
