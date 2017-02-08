package com.example.stevenzafrani.congregate.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.stevenzafrani.congregate.R;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmFragment extends Fragment {
    private List<TextView> nodeList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_algorithm, container, false);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        TextView textview;
        nodeList.clear();
        float randomVal;

        for (int i=0; i<20; i++) {
            ViewGroup parent = (ViewGroup) getActivity().findViewById(R.id.container_units);
            textview = new TextView(((getContext())));
            textview.setBackgroundColor(getResources().getColor(R.color.colorNode));
            randomVal = ((float) Math.random()*10);
            textview.setTextSize(randomVal);
            textview.setText(String.format("%.2f", randomVal));

            parent.addView(textview);
            nodeList.add(textview);
        }

    }
}
