package com.example.stevenzafrani.congregate.models;



public class AlgorithmPass {
    public int passNumber;
    public int[] arrayValues;

    public AlgorithmPass(int passNumber, int[] array) {
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
