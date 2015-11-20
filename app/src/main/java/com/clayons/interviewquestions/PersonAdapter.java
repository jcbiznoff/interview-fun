package com.clayons.interviewquestions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.clayons.interviewquestions.Model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pranavbhalla on 11/19/15.
 */
public class PersonAdapter extends BaseAdapter {
    private final Context mContext;

    private OnItemSelected mOnItemSelected;
    private List<Person> mData = new ArrayList<>();

    public PersonAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Person item = mData.get(position);
        final TextView fullNameText;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.person_item, parent, false);
            fullNameText = (TextView) convertView.findViewById(R.id.full_name);
            convertView.setTag(fullNameText);
        } else {
            fullNameText = (TextView) convertView.getTag();
        }

        fullNameText.setText(item.getFirstName() + " " + item.getLastName());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemSelected != null) {
                    mOnItemSelected.onSelected(position);
                }
            }
        });

        return convertView;
    }

    public void setData(List<Person> data) {
        mData = data;
    }

    public void setOnItemSelectedListener(OnItemSelected mOnItemSelected) {
        this.mOnItemSelected = mOnItemSelected;
    }
}
