package com.example.stevenzafrani.congregate.clickListeners;


import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

public class DrawerItemClickListener implements AdapterView.OnItemClickListener {
    Activity activity;
    public DrawerItemClickListener(Context context) {
        this.activity = (Activity) context;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {

        }

        /*
        Intent intent = new Intent();
        activity.startActivity();
        */
    }
}
