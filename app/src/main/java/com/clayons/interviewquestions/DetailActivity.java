package com.clayons.interviewquestions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.clayons.interviewquestions.Model.Person;
import com.squareup.picasso.Picasso;


public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean initialStatus;
    private Person person;
    private Button buttonLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        if (getIntent() == null || getIntent().getParcelableExtra(ContactFragment.KEY_PERSON_DETAIL) == null) {
            throw new RuntimeException("You must pass the person object");
        }

        person = getIntent().getParcelableExtra(ContactFragment.KEY_PERSON_DETAIL);

        ImageView ivAvatar = (ImageView) findViewById(R.id.ivAvatar);
        TextView tvFristName = (TextView) findViewById(R.id.tvFristName);
        TextView tvLastName = (TextView) findViewById(R.id.tvLastName);
        TextView tvAge = (TextView) findViewById(R.id.tvAge);
        TextView tvPhoneNum = (TextView) findViewById(R.id.tvPhoneNum);

        Picasso.with(this).load(person.getPhotoUrl()).into(ivAvatar);
        tvFristName.setText(person.getFirstName());
        tvLastName.setText(person.getLastName());
        tvAge.setText(String.valueOf(person.getAge()));
        tvPhoneNum.setText(person.getPhoneNum());

        buttonLike = (Button) findViewById(R.id.btnLike);
        initialStatus = person.isFavorited();
        buttonLike.setText(initialStatus ? getString(R.string.unlike) : getString(R.string.like));
        buttonLike.setOnClickListener(this);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        person.setFavorited(!person.isFavorited());
        buttonLike.setText(person.isFavorited() ? getString(R.string.unlike) : getString(R.string.like));

    }

    @Override
    public void onBackPressed() {
        if (person.isFavorited() != initialStatus) {
            setResult(RESULT_OK);
            finish();
        } else {
            super.onBackPressed();
        }

    }
}
