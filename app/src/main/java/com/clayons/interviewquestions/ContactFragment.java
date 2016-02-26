package com.clayons.interviewquestions;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.clayons.interviewquestions.Model.Person;

import java.util.ArrayList;


/**
 * A list of person objects is given.
 * Show first name, last name, and avatar as a list on MainActivity.
 * Show all information on DetailActivity.
 * First name and last name should be editable. add a save button for storing this information.
 * Create an interface class to store the data in a persistent storage.
 * Create an interface to sync database with a server.
 * <p>
 * Condition:
 * Alternate the background color for the list on MainActivity - first white, second black, third white, etc.
 * "Like" button on the detail page should override the background color on the main page with a blue color background.
 * bonus points for using MVP structure.
 * bonus points for suggesting/using up-to-date animation and transition effects.
 * bonus points for using well known libraries.
 */
public class ContactFragment extends Fragment implements AdapterView.OnItemClickListener {

    public static final String KEY_PERSON_LIST = "keyPersonList";
    public static final int REQUEST_SHOW_DETAIL = 20;
    public static final String KEY_PERSON_DETAIL = "keyPersonDetail";
    private ArrayList<Person> personArrayList;
    private Person currentPerson;
    private ContactListViewAdapter adapter;

    public static ContactFragment newInstance(ArrayList<Person> personList) {

        Bundle args = new Bundle();
        args.putParcelableArrayList(KEY_PERSON_LIST, personList);
        ContactFragment fragment = new ContactFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initValue();

    }

    private void initValue() {
        if (getArguments() == null || getArguments().getParcelableArrayList(KEY_PERSON_LIST) == null) {
            throw new RuntimeException("You have to pass the contact list.");
        }
        personArrayList = getArguments().getParcelableArrayList(KEY_PERSON_LIST);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact_list, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView contactListView = (ListView) view.findViewById(R.id.list_contact);
        contactListView.setOnItemClickListener(this);
        adapter = new ContactListViewAdapter(getActivity(), personArrayList);
        contactListView.setAdapter(adapter);
    }

    /**
     * Callback method to be invoked when an item in this AdapterView has
     * been clicked.
     * <p>
     * Implementers can call getItemAtPosition(position) if they need
     * to access the data associated with the selected item.
     *
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        currentPerson = personArrayList.get(position);
        Intent showDetailIntent = new Intent(getActivity(), DetailActivity.class);
        showDetailIntent.putExtra(KEY_PERSON_DETAIL, currentPerson);
        startActivityForResult(showDetailIntent, REQUEST_SHOW_DETAIL);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SHOW_DETAIL && resultCode == Activity.RESULT_OK) {
            currentPerson.setFavorited(!currentPerson.isFavorited());
            adapter.notifyDataSetChanged();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }


    }
}
