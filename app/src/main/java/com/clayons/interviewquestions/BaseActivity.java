package com.clayons.interviewquestions;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by pranavbhalla on 11/19/15.
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (Hook hook : mHooks) {
            hook.onCreate(this, savedInstanceState);
        }
    }
}
