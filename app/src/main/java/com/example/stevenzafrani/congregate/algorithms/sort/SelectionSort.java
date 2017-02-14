package com.example.stevenzafrani.congregate.algorithms.sort;


import android.app.Activity;
import android.util.Log;

import com.example.stevenzafrani.congregate.models.AlgorithmLog;
import com.example.stevenzafrani.congregate.models.AlgorithmPass;

import java.util.Arrays;

public class SelectionSort extends BaseSort{
    private AlgorithmLog algorithmLog =new AlgorithmLog();
    public SelectionSort(Activity activity, int[] array) {
        super(activity);
        int n = array.length;
        int index;
        int temp;
        Log.v(SelectionSort.class.getSimpleName(), Arrays.toString(array));
        for (int i = 0; i < n; i++) {
            index = i;
            for (int j = i; j<n; j++) {
                if (array[j] < array[index]) {
                    index = j;

                }
            }
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
            int[] tempArray = Arrays.copyOf(array, array.length);
            AlgorithmPass algorithmPass = new AlgorithmPass(i, tempArray);
            algorithmLog.add(algorithmPass);
        }



    }
}
