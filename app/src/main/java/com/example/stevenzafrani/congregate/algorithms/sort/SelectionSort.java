package com.example.stevenzafrani.congregate.algorithms.sort;


import android.app.Activity;
import android.util.Log;

import java.util.Arrays;

public class SelectionSort extends BaseSort{

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
            Log.v(SelectionSort.class.getSimpleName(), "Pass " + i + " " + Arrays.toString(array));
        }



    }
}
