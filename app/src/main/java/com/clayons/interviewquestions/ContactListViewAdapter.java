package com.clayons.interviewquestions;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.clayons.interviewquestions.Model.Person;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ContactListViewAdapter extends BaseAdapter {


    private final LayoutInflater inflater;
    private ArrayList<Person> data;
    private Context context;

    public ContactListViewAdapter(Context context, ArrayList<Person> data) {
        this.data = data;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }


    @Override
    public Object getItem(int position) {
        return data != null ? data.get(position) : 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        ViewHolder holder;

        if (convertView == null) {

            view = inflater.inflate(R.layout.item_person_summary, null);

            holder = new ViewHolder();
            holder.tvFirstName = (TextView) view.findViewById(R.id.tvFirstName);
            holder.tvLastName = (TextView) view.findViewById(R.id.tvLastName);
            holder.ivAvatarPerson = (ImageView) view.findViewById(R.id.ivAvatarPerson);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        final Person person = data.get(position);


        if (person.isFavorited()) {
            view.setBackgroundColor(Color.BLUE);
        } else {
            view.setBackgroundColor(position % 2 == 0 ? Color.BLACK : Color.WHITE);
        }
        holder.tvFirstName.setText(person.getFirstName());
        holder.tvLastName.setText(person.getLastName());
        Picasso.with(context).load(person.getPhotoUrl()).into(holder.ivAvatarPerson);

        return view;
    }

    public static class ViewHolder {

        public TextView tvFirstName;
        public TextView tvLastName;
        public ImageView ivAvatarPerson;

    }


}
