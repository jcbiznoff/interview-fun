package com.clayons.interviewquestions.adapters;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.clayons.interviewquestions.DetailActivity;
import com.clayons.interviewquestions.Model.Person;
import com.clayons.interviewquestions.R;

import java.util.List;

/**
 * Created by pranavbhalla on 11/17/15.
 */
public class PersonRecyclerAdapter extends RecyclerView.Adapter<PersonRecyclerAdapter.PersonView> implements View.OnClickListener {

    private final List<Person> personList;
    private final AppCompatActivity activity;
    int[] colors = new int[]{android.R.color.holo_red_dark, android.R.color.holo_orange_dark};
    private int colorPosition = 0;

    public PersonRecyclerAdapter(final AppCompatActivity activity, @NonNull List<Person> personList) {
        this.personList = personList;
        this.activity = activity;
    }

    public Person getItem(int position) {
        return personList.get(position);
    }

    @Override
    public PersonRecyclerAdapter.PersonView onCreateViewHolder(ViewGroup viewGroup, int i) {
        final View personView = LayoutInflater.from(activity).inflate(R.layout.layout_person, viewGroup);
        return new PersonView ((LinearLayout) personView);
    }

    @Override
    public void onBindViewHolder(PersonRecyclerAdapter.PersonView personView, int i) {
        final Person person = getItem(i);
        setPersonName(personView, person);
        setPersonBackgroundColor(personView, person);
        personView.personLayout.setTag(person);
        personView.personLayout.setOnClickListener(this);
    }

    private void setPersonBackgroundColor(PersonView personView, Person person) {
        if(person.isLiked()) {
            personView.personLayout.setBackgroundColor(ContextCompat.getColor(activity, android.R.color.holo_blue_bright));
        } else {
            personView.personLayout.setBackgroundColor(ContextCompat.getColor(activity, colors[getColorPosition()]));
        }
    }

    private void setPersonName(PersonView personView, Person person) {
        if(person.getFirstName() != null && !person.getFirstName().isEmpty()) {
            personView.personFirstNameTV.setText(person.getFirstName());
        } else {
            personView.personFirstNameTV.setText("No name");
        }
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public int getColorPosition() {
        return (colorPosition == 0) ? 1 : 0;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void performLollipopTransition(View v, Person person, Intent personDetailIntent) {
        final TextView sharedView = (TextView) v.findViewById(R.id.person_view_first_name);
        ActivityOptions transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(activity, sharedView, sharedView.getTransitionName());
        activity.startActivity(personDetailIntent, transitionActivityOptions.toBundle());
    }

    @Override
    public void onClick(View v) {
        final Person person = (Person) v.getTag();
        final Intent personDetailIntent = new Intent(activity, DetailActivity.class);
        personDetailIntent.putExtra(activity.getString(R.string.person), person);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            performLollipopTransition(v, person, personDetailIntent);
        } else {
            activity.startActivity(personDetailIntent);
        }
    }

    public class PersonView extends RecyclerView.ViewHolder {
        LinearLayout personLayout;
        TextView personFirstNameTV;

        public PersonView(LinearLayout personViewLayout) {
            super(personViewLayout);
            personLayout = (LinearLayout) personViewLayout.findViewById(R.id.person_view_layout);
            personFirstNameTV = (TextView) personViewLayout.findViewById(R.id.person_view_first_name);
        }
    }
}
