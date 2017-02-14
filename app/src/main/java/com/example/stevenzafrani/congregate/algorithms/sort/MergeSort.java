package com.example.stevenzafrani.congregate.algorithms.sort;

import android.app.Activity;
import android.util.Log;

import com.example.stevenzafrani.congregate.models.AlgorithmLog;
import com.example.stevenzafrani.congregate.models.AlgorithmPass;

import java.util.Arrays;

public class MergeSort extends BaseSort {
    private AlgorithmLog algorithmLog = new AlgorithmLog();
    int[] array;
    int[] tempArray;
    int length;
    int mergeCounter =0;
    public MergeSort(Activity activity, int[] array) {
        super(activity);
        this.array = array;
        this.length =array.length;
        this.tempArray = new int[length];
        Log.v(MergeSort.class.getSimpleName(), "Starting " + Arrays.toString(array));
        mergeSort(0, length-1);
    }

    public void mergeSort(int lowerIndex, int higherIndex) {
        Log.v(MergeSort.class.getSimpleName(), "Processing " + Arrays.toString(array));
        if (lowerIndex < higherIndex) {
            int middle =  lowerIndex + (higherIndex-lowerIndex)/2;
            mergeSort(lowerIndex, middle);
            mergeSort(middle+1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);

            int[] displayArray = Arrays.copyOf(array, array.length);
            AlgorithmPass algorithmPass = new AlgorithmPass(mergeCounter, displayArray);
            algorithmLog.add(algorithmPass);
            mergeCounter+=1;
        }


    }

    public void mergeParts(int lowerIndex, int midIndex, int highIndex) {
        for (int i = lowerIndex; i <= highIndex; i++) {
            tempArray[i]= array[i];

        }
        int i = lowerIndex;
        int j = midIndex + 1;
        int k = lowerIndex;
        while (i<= midIndex && j <= highIndex) {
            if (tempArray[i]<= tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }
        while (i <= midIndex) {
            array[k] = tempArray[i];
            k++;
            i++;
        }
        int[] displayArray = Arrays.copyOf(array, array.length);
        AlgorithmPass algorithmPass = new AlgorithmPass(mergeCounter, displayArray);
        algorithmLog.add(algorithmPass);
    }

    public AlgorithmLog getAlgorithmLog() {
        return algorithmLog;
    }

}
