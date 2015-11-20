package com.clayons.interviewquestions;

import com.clayons.interviewquestions.Model.Person;

import java.util.List;

/**
 * Created by pranavbhalla on 11/19/15.
 */
public class MainModel {
    private final PeopleManager mPeopleManager = PeopleManager.instance();

    public MainModel() {
    }

    public List<Person> getPeople() {
        return mPeopleManager.getPeople();
    }
}
