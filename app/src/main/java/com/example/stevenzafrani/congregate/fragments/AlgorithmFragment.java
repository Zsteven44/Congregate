package com.example.stevenzafrani.congregate.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.stevenzafrani.congregate.R;
import com.example.stevenzafrani.congregate.algorithms.sort.BubbleSort;
import com.example.stevenzafrani.congregate.algorithms.sort.InsertionSort;
import com.example.stevenzafrani.congregate.algorithms.sort.MergeSort;
import com.example.stevenzafrani.congregate.algorithms.sort.QuickSort;
import com.example.stevenzafrani.congregate.algorithms.sort.SelectionSort;

public class AlgorithmFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_algorithm, container, false);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinner_algorithm_sort);
        final int myArray[] = new int[20];


        spinner.setSelection(1, false);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int j, long l) {

                for (int i = 0; i <myArray.length; i++) {
                    myArray[i] = (int)(Math.random()*100);
                }

                switch (j) {
                    case 0:
                        break;
                    case 1:
                        new BubbleSort(getContext(), myArray);
                        break;
                    case 2:
                        new MergeSort(getContext(), myArray);
                        break;
                    case 3:
                        new InsertionSort(getContext(), myArray);
                        break;
                    case 4:
                        new SelectionSort(getContext(), myArray);
                        break;
                    case 5:
                        new QuickSort(getContext(), myArray);
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.algorithm_sort_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }




}
