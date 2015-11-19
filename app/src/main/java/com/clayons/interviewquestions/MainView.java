package com.clayons.interviewquestions;

import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.clayons.interviewquestions.Model.Person;

import java.util.List;

/**
 * Created by pranavbhalla on 11/19/15.
 */
public class MainView {
    private AppCompatActivity mActivity;

    private ListView mListView;
    private PersonAdapter mAdapter;

    public void onCreate(AppCompatActivity activity) {
        mActivity = activity;
        mActivity.setContentView(R.layout.main_activity);
        mListView = (ListView) mActivity.findViewById(R.id.list_view);
        mAdapter = new PersonAdapter(mActivity);
        mListView.setAdapter(mAdapter);
    }

    public void drawPeopleList(List<Person> people) {
        mAdapter.setData(people);
        mAdapter.notifyDataSetChanged();
    }

    public void setOnItemSelectedListener(OnItemSelected listener) {
        mAdapter.setOnItemSelectedListener(listener);
    }
}
