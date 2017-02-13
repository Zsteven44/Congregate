package com.example.stevenzafrani.congregate.algorithms.sort;


import android.app.Activity;
import android.support.annotation.NonNull;

public abstract class BaseSort {
    protected Activity activity;

    public BaseSort(@NonNull final Activity activity) {
        this.activity=activity;
    }
}
