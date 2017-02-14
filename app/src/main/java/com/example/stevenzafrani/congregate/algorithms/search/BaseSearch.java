package com.example.stevenzafrani.congregate.algorithms.search;

import android.app.Activity;
import android.support.annotation.NonNull;


public class BaseSearch {
    protected Activity activity;

    public BaseSearch(@NonNull final Activity activity) {
        this.activity=activity;
    }
}
