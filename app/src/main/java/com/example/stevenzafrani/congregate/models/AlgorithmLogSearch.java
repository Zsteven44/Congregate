package com.example.stevenzafrani.congregate.models;

import java.util.ArrayList;
import java.util.Collection;

public class AlgorithmLogSearch extends ArrayList<AlgorithmPassSearch> {
    public AlgorithmLogSearch(int initialCapacity) {
        super(initialCapacity);
    }

    public AlgorithmLogSearch() {
    }

    public AlgorithmLogSearch(Collection<? extends AlgorithmPassSearch> c) {
        super(c);
    }

    @Override
    public AlgorithmPassSearch get(int index) {
        return super.get(index);
    }
}
