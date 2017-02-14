package com.example.stevenzafrani.congregate.algorithms.sort;

import android.app.Activity;

import com.example.stevenzafrani.congregate.R;
import com.example.stevenzafrani.congregate.models.AlgorithmLogSort;
import com.example.stevenzafrani.congregate.models.AlgorithmPassSort;

import java.util.Arrays;

public class BubbleSort extends BaseSort {
    private AlgorithmLogSort algorithmLog = new AlgorithmLogSort();
    private String DESCRIPTION = String.valueOf(R.string.description_bubble_sort);

    public BubbleSort(final Activity activity,
                      final int array[]) {
        super(activity);

        int n = array.length;
        int k;

        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < n - 1; j++) {
                k = j + 1;
                if (array[j] > array[k]) {
                    swapNumbers(j, k, array);

                }
            }
            int[] tempArray = Arrays.copyOf(array, array.length);
            AlgorithmPassSort algorithmPass = new AlgorithmPassSort(n-i, tempArray);
            algorithmLog.add(algorithmPass);
        }
    }

    public AlgorithmLogSort getAlgorithmLog() {
        return algorithmLog;
    }


    public void swapNumbers(final int j,
                            final int k,
                            final int array[]) {
        int temp = array[k];
        array[k] = array[j];
        array[j] = temp;


    }



}
