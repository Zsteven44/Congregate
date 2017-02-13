package com.example.stevenzafrani.congregate.algorithms.sort;

import android.app.Activity;
import android.util.Log;

import com.example.stevenzafrani.congregate.models.AlgorithmLog;
import com.example.stevenzafrani.congregate.models.AlgorithmPass;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort extends BaseSort {
    private AlgorithmLog algorithmLog = new AlgorithmLog();

    public BubbleSort(final Activity activity,
                      final int array[]) {
        super(activity);
        Log.v(BubbleSort.class.getSimpleName(), Arrays.toString(array));

        int n = array.length;
        int k;
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < n - 1; j++) {
                k = j + 1;
                if (array[j] > array[k]) {
                    swapNumbers(j, k, array);

                }
            }
            algorithmLog.add(new AlgorithmPass(i, array));
            Log.v(BubbleSort.class.getSimpleName(), "Pass " + Integer.toString(n-i) + " " + Arrays.toString(array));
        }
        printResult(array);

    }
    public AlgorithmLog getAlgorithmLog() {
        return algorithmLog;
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

    }

}
