package com.example.stevenzafrani.congregate.algorithms.search;


import android.app.Activity;
import android.support.annotation.NonNull;

import com.example.stevenzafrani.congregate.models.AlgorithmLogSort;

public class LinearSearch extends BaseSearch {
    private AlgorithmLogSort algorithmLog = new AlgorithmLogSort();

    public LinearSearch(@NonNull final Activity activity,
                        int[] array,
                        int key) {
        super(activity);

        performSearch(array, key);


    }


     private int performSearch(int[] array, int key) {
        int size = array.length;
        for (int i = 0; i<size; i++) {
            if ((array[i]) == key) {
                return i;
            }
        }
        return -1;
    }


}
