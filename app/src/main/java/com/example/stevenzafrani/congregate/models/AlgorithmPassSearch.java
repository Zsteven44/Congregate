package com.example.stevenzafrani.congregate.models;

public class AlgorithmPassSearch {
    public int passNumber;
    public int passIndex;
    public int passValue;

    public AlgorithmPassSearch(int passNumber, int index, int value) {
        this.passNumber = passNumber;
        this.passIndex = index;
        this.passValue = value;
    }

    public int getPassNumber() {
        return passNumber;
    }

    public int getPassIndex() {
        return passIndex;
    }

    public int getPassValue() {
        return passValue;
    }
}
