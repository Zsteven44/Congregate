package com.example.stevenzafrani.congregate.algorithms.search;


import android.app.Activity;
import android.support.annotation.NonNull;

import com.example.stevenzafrani.congregate.models.AlgorithmLogSearch;
import com.example.stevenzafrani.congregate.models.AlgorithmPassSearch;

public class BinarySearch extends BaseSearch {
    private AlgorithmLogSearch algorithmLogSearch = new AlgorithmLogSearch();
    private int counter = 0 ;

    public BinarySearch(@NonNull final Activity activity, int[] array, int key) {
        super(activity);
        performSearch(array, key);
    }

    public int performSearch(int[] array, int key) {
        int max = array.length+1;
        int min = 0;
        int guess;
        int counter= 0;

        while (max >= min) {
            counter++;
            guess = (int) Math.floor(min+max/2);
            if (array[guess] == key) {
                AlgorithmPassSearch algorithmPassSearch = new AlgorithmPassSearch(counter, guess, array[guess], true, array);
                algorithmLogSearch.add(algorithmPassSearch);
                return guess;
            } else if (array[guess] > key) {
                min = guess+1;
            } else {
                max = guess-1;
            }
        }
        return -1;
    }


    public AlgorithmLogSearch getAlgorithmLog() {
        return algorithmLogSearch;
    }
}
