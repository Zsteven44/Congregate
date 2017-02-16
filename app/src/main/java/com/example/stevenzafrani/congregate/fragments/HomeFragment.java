package com.example.stevenzafrani.congregate.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.stevenzafrani.congregate.R;

public class HomeFragment extends BaseFragment {
    private ListView listView;
    private ArrayAdapter<String> listAdapter;
    private String[] listItems;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

    }


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        listView = (ListView) rootView.findViewById(R.id.listView_home_fragment);

        listItems = new String[4];
        listItems[0] = getString(R.string.home_fragment_section_1_item_1);
        listItems[1] = getString(R.string.home_fragment_section_1_item_1);
        listItems[2] = getString(R.string.home_fragment_section_1_item_1);
        listItems[3] = getString(R.string.home_fragment_section_1_item_1);
        listAdapter = new ArrayAdapter<String>(getActivity(),R.layout.listview_home_fragment, listItems);

        listView.setAdapter(listAdapter);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}
