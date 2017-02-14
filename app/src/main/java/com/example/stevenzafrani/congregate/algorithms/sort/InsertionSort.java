package com.example.stevenzafrani.congregate.algorithms.sort;


import android.app.Activity;

import com.example.stevenzafrani.congregate.models.AlgorithmLogSort;
import com.example.stevenzafrani.congregate.models.AlgorithmPassSort;

import java.util.Arrays;

public class InsertionSort extends BaseSort {
    private AlgorithmLogSort algorithmLog = new AlgorithmLogSort();

    public InsertionSort(Activity activty, int[] array) {
        super(activty);
        int n = array.length;
        int temp;
        for (int i = 1; i < n; i++) {
            for (int j = i; j>0; j--) {
                if (array[j] < array[j-1]) {
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
            int[] displayArray = Arrays.copyOf(array, array.length);
            AlgorithmPassSort algorithmPass = new AlgorithmPassSort(i, displayArray);
            algorithmLog.add(algorithmPass);

        }
    }


    public AlgorithmLogSort getAlgorithmLog() {
        return algorithmLog;
    }
}
