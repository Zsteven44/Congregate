package com.example.stevenzafrani.congregate.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.stevenzafrani.congregate.R;

public abstract class BaseActivity extends AppCompatActivity {
    FragmentManager fragmentManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.fragmentManager = getSupportFragmentManager();
    }

    @Nullable
    public Fragment getTopFragment() {
        return fragmentManager.findFragmentById(R.id.container);
    }
}
