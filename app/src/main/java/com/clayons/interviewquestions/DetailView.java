package com.clayons.interviewquestions;

import android.view.View;

import com.clayons.interviewquestions.Model.Person;

/**
 * Created by pranavbhalla on 11/19/15.
 */
public class DetailView {
    private View mPhoneNumberView;

    public void drawPerson(Person person) {

    }

    public void onCreate(DetailActivity detailActivity) {
        detailActivity.setContentView(R.layout.detail_activity);

        mPhoneNumberView = detailActivity.findViewById(R.id.tvFristName);
        mPhoneNumberView = detailActivity.findViewById(R.id.tvLastName);
        mPhoneNumberView = detailActivity.findViewById(R.id.tvAge);
        mPhoneNumberView = detailActivity.findViewById(R.id.tvPhoneNum);
    }
}
