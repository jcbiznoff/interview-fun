package com.clayons.interviewquestions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.clayons.interviewquestions.Model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * A list of person objects is given. Show the data to the user and render that on fragment A. Every other item contains a completely different background color. Ex) first white, second black, third white, etc.
 * Clicking on the "Like" button from the detail page should reflect in the main page with a transparent blue color background
 - must support older devices
 - must be able to present the list in a linear recycler view.
 - clicking on one item should show a fragment with detail page and same info presented on a large layout
 - layout file structure
 - bonus points for using MVP structure.
 - bonus points for fancy animation and page transitions.
 - bonus points for using libraries + dependency injection frameworks
 */
public class MainActivity extends AppCompatActivity{

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setHooks();
        super.onCreate(savedInstanceState);
        mPresenter = new MainPresenter(new MainModel(), new MainView());
        mPresenter.onCreate(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume(this);
    }
}
