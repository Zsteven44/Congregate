package com.example.stevenzafrani.congregate.activities;


import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.example.stevenzafrani.congregate.R;
import com.example.stevenzafrani.congregate.fragments.AlgorithmFragment;

public class AlgorithmActivity extends BaseActivity {
    TabItem youtubeButton;
    TabItem algorithmButton;
    TabItem homeButton;
    TabLayout homeTab;
    ViewPager viewPager;

    public AlgorithmActivity() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_algorithm);
        if (savedInstanceState ==null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new AlgorithmFragment()).commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

}
