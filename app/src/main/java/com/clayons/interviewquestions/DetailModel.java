package com.clayons.interviewquestions;

import com.clayons.interviewquestions.Model.Person;

/**
 * Created by pranavbhalla on 11/19/15.
 */
public class DetailModel {
    private static final int NONE = -1;

    private final PeopleManager mPeopleManager = PeopleManager.instance();

    private int mIndex = NONE;

    public void onCreate(DetailActivity detailActivity) {
        mIndex = detailActivity.getIntent().getIntExtra(DetailActivity.KEY_INDEX, NONE);
    }

    public Person getPerson() {
        if (mIndex != NONE) {
            return mPeopleManager.getPeople().get(mIndex);
        } else {
            return null;
        }
    }
}
