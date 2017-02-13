package com.example.stevenzafrani.congregate.algorithms.sort;


import android.content.Context;
import android.util.Log;

import java.util.Arrays;

public class QuickSort {
    int temp;
    int[] array;
    public QuickSort(Context context,int[] array) {
        this.array = array;
        int minIndex = 0;
        int maxIndex = array.length-1;

        Log.v(QuickSort.class.getSimpleName(), "Starting " + Arrays.toString(array));
        quickSorting(minIndex, maxIndex);
    }

    public void quickSorting(int minIndex, int maxIndex) {
        int i = minIndex;
        int j = maxIndex;
        int centerIndex = (int)(minIndex+(maxIndex-minIndex)/2);
        int centerValue = array[centerIndex];

        while (i <= j) {
            while (array[i] < centerValue) {
                i++;
            }
            while (array[j] > centerValue) {
                j--;
            }

            if (i <= j) {
                exchangeNumbers(i,j);
                i++;
                j--;
            }
            Log.v(QuickSort.class.getSimpleName(), "Looping " + Arrays.toString(array));
        }

        if (minIndex < j) {
            quickSorting(minIndex, j);
        }

        if (i < maxIndex) {
            quickSorting(i, maxIndex);
        }
    }

    public void exchangeNumbers(int i, int j) {
        temp = array[j];
        array[j] = array[i];
        array[i] = temp;


    }



}
