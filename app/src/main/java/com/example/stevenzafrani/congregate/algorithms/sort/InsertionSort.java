package com.example.stevenzafrani.congregate.algorithms.sort;


import android.app.Activity;
import android.util.Log;

import java.util.Arrays;

public class InsertionSort extends BaseSort {


    public InsertionSort(Activity activty, int[] array) {
        super(activty);
        int n = array.length;
        int temp;
        Log.v(SelectionSort.class.getSimpleName(), Arrays.toString(array));
        for (int i = 1; i < n; i++) {
            for (int j = i; j>0; j--) {
                if (array[j] < array[j-1]) {
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
            Log.v(SelectionSort.class.getSimpleName(), "Pass " + i + " " + Arrays.toString(array));
        }



    }
}
