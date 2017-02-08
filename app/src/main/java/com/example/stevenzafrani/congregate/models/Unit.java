package com.example.stevenzafrani.congregate.models;


import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class Unit extends View {
    /**
     *  This is a representative model for displaying algorithmic units, nodes, etc..
     *
     */

    private double value;
    private View unitView;


    public Unit(Context context) {
        super(context);
    }

    public Unit(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Unit(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Unit(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public View getUnitView() {
        return unitView;
    }

    public void setUnitView(View unitView) {
        this.unitView = unitView;
    }
}
