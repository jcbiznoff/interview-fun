package com.clayons.interviewquestions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.clayons.interviewquestions.Model.Person;
import com.squareup.picasso.Picasso;


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        final Person person = (Person) getIntent().getExtras().getParcelable(getString(R.string.person));
        setUpDetailsLayout(person);
    }

    public void setUpDetailsLayout(final Person person) {
        ImageView avatar = (ImageView) findViewById(R.id.ivAvatar);
        Picasso.with(this).load(person.getPhotoUrl()).into(avatar);

        TextView firstNameTV = (TextView) findViewById(R.id.tvFristName);
        firstNameTV.setText(person.getFirstName());

        TextView lastNameTV = (TextView) findViewById(R.id.tvLastName);
        lastNameTV.setText(person.getLastName());

        TextView ageTV = (TextView) findViewById(R.id.tvAge);
        ageTV.setText(person.getAge());

        TextView phoneNumTV = (TextView) findViewById(R.id.tvPhoneNum);
        phoneNumTV.setText(person.getPhoneNum());

        Button likeButton = (Button) findViewById(R.id.btnLike);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person.setIsLiked(true);
            }
        });
    }
}
