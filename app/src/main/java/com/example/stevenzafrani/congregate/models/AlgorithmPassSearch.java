package com.example.stevenzafrani.congregate.models;

public class AlgorithmPassSearch {
    public int passNumber;
    public int passIndex;
    public int passValue;
    public boolean target;
    public int[] arrayValues;


    public AlgorithmPassSearch(int passNumber, int index, int value, boolean target, int[] array) {
        this.passNumber = passNumber;
        this.passIndex = index;
        this.passValue = value;
        this.target = target;
        this.arrayValues = array;

    }

    public int[] getArrayValues() {
        return arrayValues;
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

    public boolean isTarget() {
        return target;
    }

}
