package com.example.stevenzafrani.congregate.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.stevenzafrani.congregate.R;
import com.example.stevenzafrani.congregate.canvas.AlgorithmCanvas;
import com.example.stevenzafrani.congregate.models.AlgorithmLogSort;

import java.util.Arrays;

public class SearchFragment extends BaseFragment {

    private int[] myArray;
    private int[] newArray;
    private int[] finishedArray;
    private boolean inProgress =false;

    private AlgorithmLogSort algorithmLog;
    int i;
    private ImageView drawableCanvas;
    Handler handler = new Handler();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        final Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinner_algorithm_search);
        myArray = new int[20];
        newArray = new int[20];
        finishedArray = new int[20];
        algorithmLog = new AlgorithmLogSort();

        drawableCanvas= (ImageView) getActivity().findViewById(R.id.imageView_algorithm_search);

        spinner.setSelection(1, false);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int j, long l) {

                drawableCanvas.setImageDrawable(new AlgorithmCanvas(myArray,newArray, finishedArray));
                algorithmLog.clear();
                switch (j) {
                    case 0:
                        generateMyArray();
                        setArrayData();
                        break;
                    case 1:
                        generateMyArray();
                        setArrayData();
                        break;
                    case 2:
                        generateMyArray();
                        setArrayData();
                        break;
                    case 3:
                        generateMyArray();
                        setArrayData();
                        break;
                    case 4:
                        generateMyArray();
                        setArrayData();
                        break;
                    case 5:
                        generateMyArray();
                        setArrayData();
                        break;
                    default:
                        break;
                }
                if (j !=0) {
                    inProgress = true;
                    spinner.setEnabled(!inProgress);
                    runSimulation(algorithmLog,spinner);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.algorithm_search_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void runSimulation(@NonNull final AlgorithmLogSort algoLog, final Spinner spinner) {
        i =0;
        if (algoLog.size()>1) {
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {

                    newArray = algoLog.get(i).getArrayValues();
                    drawableCanvas.setImageDrawable(new AlgorithmCanvas(myArray, newArray, finishedArray));

                    i++;
                    if (i < algoLog.size()) {
                        handler.postDelayed(this, 500);
                    } else {
                        spinner.setEnabled(true);
                    }

                }
            };
            handler.post(runnable);
        }
    }
    private void setArrayData() {
        newArray = Arrays.copyOf(myArray, myArray.length);
        finishedArray = Arrays.copyOf(myArray, myArray.length);
        drawableCanvas.setImageDrawable(new AlgorithmCanvas(myArray,newArray,finishedArray));
    }
    private void generateMyArray() {
        for (int i = 0; i <myArray.length; i++) {
            myArray[i] = (int)(Math.random()*100);
        }
    }

}
