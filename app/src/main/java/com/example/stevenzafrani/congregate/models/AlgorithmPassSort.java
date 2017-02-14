package com.example.stevenzafrani.congregate.models;



public class AlgorithmPassSort {
    public int passNumber;
    public int[] arrayValues;

    public AlgorithmPassSort(int passNumber, int[] array) {
        this.passNumber = passNumber;
        this.arrayValues = array;
    }

    public int getPassNumber() {
        return passNumber;
    }

    public int[] getArrayValues() {
        return arrayValues;
    }
}
