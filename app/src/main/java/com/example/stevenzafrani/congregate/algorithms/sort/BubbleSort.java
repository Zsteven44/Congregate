package com.example.stevenzafrani.congregate.algorithms.sort;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import java.util.Arrays;

public class BubbleSort {

    public BubbleSort(final Context context,
                      final int array[],
                      final ImageView canvas){
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


    public void swapNumbers(final int j,
                            final int k,
                            final int array[]) {
        int temp = array[k];
        array[k] = array[j];
        array[j] = temp;
        /*
        Log.v(BubbleSort.class.getSimpleName(), "About to run handler with postDelayed.")
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 100);
        */

    }

    public void printResult(int array[]) {
        Log.v(BubbleSort.class.getSimpleName(), Arrays.toString(array));
    }

}
