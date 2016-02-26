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

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return data != null ? data.get(position) : 0;
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    /**
     * @see android.widget.Adapter#getView(int, View, ViewGroup)
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        return createViewFromResource(inflater, position, convertView, parent, R.layout.item_person_summary);
    }


    private View createViewFromResource(LayoutInflater inflater, int position, View convertView,
                                        ViewGroup parent, int resource) {
        View v;
        if (convertView == null) {
            v = inflater.inflate(resource, parent, false);
        } else {
            v = convertView;
        }

        bindView(position, v);

        return v;
    }

    private void bindView(int position, View view) {
        final Person person
                = data.get(position);
        if (person == null) {
            return;
        }

        if (person.isFavorited()) {
            view.setBackgroundColor(Color.BLUE);
        } else {
            view.setBackgroundColor(position % 2 == 0 ? Color.BLACK : Color.WHITE);
        }
        ((TextView) view.findViewById(R.id.tvFirstName)).setText(person.getFirstName());
        ((TextView) view.findViewById(R.id.tvLastName)).setText(person.getLastName());
        ImageView avatar = (ImageView) view.findViewById(R.id.ivAvatarPerson);
        Picasso.with(context).load(person.getPhotoUrl()).into(avatar);

    }

    //// FIXME: 2/26/16 I will check it later
    public static class ViewHolder {

        public TextView tvFirstName;
        public TextView tvLastName;
        public ImageView ivAvatarPerson;

        public ViewHolder(View view) {
        }
    }
}
