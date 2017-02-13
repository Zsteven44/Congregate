package com.example.stevenzafrani.congregate.algorithms.sort;

import android.app.Activity;
import android.util.Log;
import android.widget.ImageView;

import com.example.stevenzafrani.congregate.fragments.AlgorithmFragment;
import com.example.stevenzafrani.congregate.models.AlgorithmPass;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort extends BaseSort {
    ArrayList<AlgorithmPass> algorithmLog = new ArrayList<>();

    public BubbleSort(final Activity activity,
                      final int array[],
                      final ImageView canvas){
        super(activity);
        Log.v(BubbleSort.class.getSimpleName(), Arrays.toString(array));

        int n = array.length;
        int k;
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < n - 1; j++) {
                k = j + 1;
                if (array[j] > array[k]) {
                    swapNumbers(j, k, array);

                    // Testing Log
                    algorithmLog.add(new AlgorithmPass(i, array));
                    Log.v(BubbleSort.class.getSimpleName(), "The AlgorithmLog is currently " + algorithmLog.toString());
                }
            }
            Log.v(BubbleSort.class.getSimpleName(), "Pass " + Integer.toString(n-i) + " " + Arrays.toString(array));
        }
        printResult(array);

    }


    public void swapNumbers(final int j,
                            final int k,
                            final int array[]) {
        int temp = array[k];
        array[k] = array[j];
        array[j] = temp;


    }

    public void printResult(int array[]) {
        Log.v(BubbleSort.class.getSimpleName(), Arrays.toString(array));
    }

    public void callSimulation(ArrayList<AlgorithmPass> algoLog) {
        activity.getFragmentManager()
    }

}
