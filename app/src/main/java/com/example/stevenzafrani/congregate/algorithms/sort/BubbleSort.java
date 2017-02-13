package com.example.stevenzafrani.congregate.algorithms.sort;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import com.example.stevenzafrani.congregate.models.AlgorithmPass;

import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {
    ArrayList<AlgorithmPass> algorithmLog = new ArrayList<>();
    public BubbleSort(final Context context,
                      final int array[],
                      final ImageView canvas){
        Log.v(BubbleSort.class.getSimpleName(), Arrays.toString(array));
        algorithmLog.clear();
        int n = array.length;
        int k;
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < n - 1; j++) {
                k = j + 1;
                if (array[j] > array[k]) {
                    swapNumbers(j, k, array);

                    // Testing Log
                    algorithmLog.add(new AlgorithmPass(i, array));
                }
            }
            Log.v(BubbleSort.class.getSimpleName(), "Pass " + Integer.toString(n-i) + " " + Arrays.toString(array));
        }
        printResult(array);
        for (int z =0; z<algorithmLog.size(); z++) {
            final AlgorithmPass tempAlgorithmPass = new AlgorithmPass(algorithmLog.get(z).getPassNumber(),algorithmLog.get(z).getArrayValues());
            Handler handler1 = new Handler();
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    runSimulation(tempAlgorithmPass, array);
                }
            }, 1000);

        }



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

    public void runSimulation(AlgorithmPass algorithmPass, int[] array) {

        array = algorithmPass.getArrayValues();

    }
}
