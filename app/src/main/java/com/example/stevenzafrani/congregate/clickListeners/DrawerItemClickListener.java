package com.example.stevenzafrani.congregate.clickListeners;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.example.stevenzafrani.congregate.activities.AlgorithmActivity;
import com.example.stevenzafrani.congregate.activities.ApiActivity;
import com.example.stevenzafrani.congregate.activities.HomeActivity;

public class DrawerItemClickListener implements AdapterView.OnItemClickListener {
    private Activity activity;
    public DrawerItemClickListener(Context context) {
        this.activity = (Activity) context;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Class nextActivity;

        switch (i) {
            case 0:
                nextActivity = HomeActivity.class;
                break;
            case 1:
                nextActivity = AlgorithmActivity.class;
                break;
            case 2:
                nextActivity = ApiActivity.class;
                break;
            default:
                nextActivity = null;
                break;
        }

        Intent intent = new Intent(activity, nextActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        selectItem(intent);





    }

    public void selectItem(Intent intent) {
        if (intent.getComponent().getClassName() != null && intent.getComponent().getClassName() != activity.getClass().getName() )
        {
            activity.startActivity(intent);
        }

    }
}
