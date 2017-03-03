package com.example.stevenzafrani.congregate.algorithms.search;


import android.app.Activity;
import android.support.annotation.NonNull;

import com.example.stevenzafrani.congregate.models.AlgorithmLogSearch;
import com.example.stevenzafrani.congregate.models.AlgorithmPassSearch;

public class LinearSearch extends BaseSearch {
    private AlgorithmLogSearch algorithmLog = new AlgorithmLogSearch();
    private int counter = 0;

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
                AlgorithmPassSearch algorithmPassSearch = new AlgorithmPassSearch(counter, i, array[i], true, array);
                algorithmLog.add(algorithmPassSearch);
                return i;
            }
            AlgorithmPassSearch algorithmPassSearch = new AlgorithmPassSearch(counter, i, array[i], false,array);
            algorithmLog.add(algorithmPassSearch);
            counter++;
        }
        return -1;
    }

    public AlgorithmLogSearch getAlgorithmLog() {
        return algorithmLog;
    }

}
