package com.example.stevenzafrani.congregate.models;


import java.util.ArrayList;
import java.util.Collection;

public class AlgorithmLogSort extends ArrayList<AlgorithmPassSort> {
    public AlgorithmLogSort(int initialCapacity) {
        super(initialCapacity);
    }

    public AlgorithmLogSort() {
    }

    public AlgorithmLogSort(Collection<? extends AlgorithmPassSort> c) {
        super(c);
    }

    @Override
    public AlgorithmPassSort get(int index) {
        return super.get(index);
    }
}
