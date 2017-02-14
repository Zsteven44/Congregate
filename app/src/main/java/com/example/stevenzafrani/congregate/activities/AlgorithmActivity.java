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
    TabItem algorithmButton;
    TabItem sortButton;
    TabItem searchButton;
    TabLayout algorithmTab;
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

        algorithmButton = (TabItem) this.findViewById(R.id.button_select_algorithm);
        sortButton = (TabItem) this.findViewById(R.id.button_select_sort);
        searchButton = (TabItem) this.findViewById(R.id.button_select_search);
        algorithmTab = (TabLayout) this.findViewById(R.id.tab_algorithm);
        viewPager = (ViewPager) this.findViewById(R.id.viewpager_algorithm);
        algorithmViewPagerSetup(viewPager);

        algorithmTab.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void algorithmViewPagerSetup(ViewPager viewpager) {

    }
}
