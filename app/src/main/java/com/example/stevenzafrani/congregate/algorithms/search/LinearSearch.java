package com.example.stevenzafrani.congregate.algorithms.search;


import android.app.Activity;
import android.support.annotation.NonNull;

import com.example.stevenzafrani.congregate.models.AlgorithmLogSort;

public class LinearSearch extends BaseSearch {
    private AlgorithmLogSort algorithmLog = new AlgorithmLogSort();

    public LinearSearch(@NonNull final Activity activity,
                        int[] array,
                        int valueZ) {
        super(activity);

        performSearch(array, valueZ);


    }


     private int performSearch(int[] array, int valueZ) {

        for (int i = 0; i<array.length; i++) {
            if (Integer.valueOf(array[i]) == valueZ) {
                return i;
            }
        }
        return -1;
    }


}
