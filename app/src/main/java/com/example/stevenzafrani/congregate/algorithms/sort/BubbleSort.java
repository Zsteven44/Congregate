package com.example.stevenzafrani.congregate.algorithms.sort;

import android.content.Context;
import android.util.Log;

import java.util.Arrays;

public class BubbleSort {

    public BubbleSort(Context context, int array[]){
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
            Log.v(BubbleSort.class.getSimpleName(), "Pass " + Integer.toString(n-i) + " " + Arrays.toString(array));
        }
        printResult(array);
    }


    public void swapNumbers(int j, int k, int array[]) {
        int temp = array[k];
        array[k] = array[j];
        array[j] = temp;
    }

    public void printResult(int array[]) {
        Log.v(BubbleSort.class.getSimpleName(), Arrays.toString(array));

    }

}