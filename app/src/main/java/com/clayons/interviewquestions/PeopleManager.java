package com.clayons.interviewquestions;

import com.clayons.interviewquestions.Model.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pranavbhalla on 11/19/15.
 */
public class PeopleManager {
    private static PeopleManager sInstance;

    private List<Person> mPeople = Arrays.asList(
            new Person("John", "Doe", 20, "111-222-3333", "http://i58.tinypic.com/2z6fa6t.jpg"),
            new Person("Jane", "Kish", 30, "111-222-3334", "http://i58.tinypic.com/2z6fdsl.jpg"),
            new Person("Sam", "Jackson", 24, "111-222-3335", "http://i60.tinypic.com/2z6fdbr.jpg"),
            new Person("Pete", "Dorey", 15, "111-222-3336", "http://i57.tinypic.com/2z6fb0p.jpg"),
            new Person("George", "Mime", 5, "111-222-3337", "http://i59.tinypic.com/2z6fakl.jpg"));

    public static PeopleManager instance() {
        if (sInstance == null) {
            sInstance = new PeopleManager();
        }

        return sInstance;
    }

    public List<Person> getPeople() {
        return mPeople;
    }

    public void likePerson(int index) {
        mPeople.get(index).setIsLiked(true);
    }

    public void unlikePerson(int index) {
        mPeople.get(index).setIsLiked(false);
    }
}
