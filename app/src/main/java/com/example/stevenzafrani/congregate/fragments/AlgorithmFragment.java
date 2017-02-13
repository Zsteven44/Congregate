package com.example.stevenzafrani.congregate.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.stevenzafrani.congregate.R;
import com.example.stevenzafrani.congregate.algorithms.sort.BubbleSort;
import com.example.stevenzafrani.congregate.algorithms.sort.InsertionSort;
import com.example.stevenzafrani.congregate.algorithms.sort.MergeSort;
import com.example.stevenzafrani.congregate.algorithms.sort.QuickSort;
import com.example.stevenzafrani.congregate.algorithms.sort.SelectionSort;
import com.example.stevenzafrani.congregate.models.AlgorithmCanvas;
import com.example.stevenzafrani.congregate.models.AlgorithmLog;

import java.util.Arrays;

public class AlgorithmFragment extends BaseFragment {
    private int[] myArray;
    private int[] newArray;
    private AlgorithmLog algorithmLog;
    int i;
    private ImageView drawableCanvas;
    Handler handler = new Handler();

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
        myArray = new int[20];
        newArray = new int[20];
        algorithmLog = new AlgorithmLog();

        drawableCanvas= (ImageView) getActivity().findViewById(R.id.imageView_algorithm);

        spinner.setSelection(1, false);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int j, long l) {

                drawableCanvas.setImageDrawable(new AlgorithmCanvas(myArray,newArray));
                switch (j) {
                    case 0:
                        for (int i = 0; i <myArray.length; i++) {
                            myArray[i] = (int)(Math.random()*100);
                        }
                        algorithmLog.clear();
                        break;
                    case 1:
                        algorithmLog = new BubbleSort(getActivity(), myArray).getAlgorithmLog();

                        break;
                    case 2:
                        new MergeSort(getActivity(), myArray);
                        break;
                    case 3:
                        new InsertionSort(getActivity(), myArray);
                        break;
                    case 4:
                        new SelectionSort(getActivity(), myArray);
                        break;
                    case 5:
                        new QuickSort(getActivity(), myArray);
                        break;
                    default:
                        break;
                }
                if (algorithmLog.size()>0) {
                    runSimulation(algorithmLog);
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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void runSimulation(@NonNull final AlgorithmLog algoLog) {
        i =0;
        drawableCanvas.setImageDrawable(new AlgorithmCanvas(myArray,newArray));
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {

                newArray = algoLog.get(i).getArrayValues();
                Log.v(AlgorithmFragment.class.getSimpleName(), "newArray " + i + ", " + Arrays.toString(newArray));

                i++;
                if(i < algoLog.size()) {
                    handler.postDelayed(this, 500);
                }
            }
        };

        handler.post(runnable);

    }
}
