package com.example.stevenzafrani.congregate.models;


import java.util.ArrayList;
import java.util.Collection;

public class AlgorithmLog extends ArrayList<AlgorithmPass> {
    public AlgorithmLog(int initialCapacity) {
        super(initialCapacity);
    }

    public AlgorithmLog() {
    }

    public AlgorithmLog(Collection<? extends AlgorithmPass> c) {
        super(c);
    }

    @Override
    public AlgorithmPass get(int index) {
        return super.get(index);
    }
}
