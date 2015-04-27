package com.alejandrocelaya.fragments2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.alejandrocelaya.fragments2.entities.Email;

import java.util.Arrays;
import java.util.List;

/**
 * Created by cta on 27/04/2015.
 */
public class ListFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        List<Email> emails = Arrays.asList(
            new Email("Pepe", "First message", "Body one"),
            new Email("Luis", "Very urgent!!", "Body two"),
            new Email("Juan", "Hello!!", "You have won an iPad")
        );

        super.onActivityCreated(savedInstanceState);
    }

    private class EmailsAdapter extends ArrayAdapter<Email> {

        public EmailsAdapter(Context context, int resource, List<Email> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
//            LayoutInflater inflater = (LayoutInflater)
//                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View row = inflater.inflate(R.layout.list_item, parent, false);
//
//            return row;
            return super.getView(position, convertView, parent);
        }
    }
}
