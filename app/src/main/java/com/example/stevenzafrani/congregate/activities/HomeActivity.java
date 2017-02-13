package com.example.stevenzafrani.congregate.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.stevenzafrani.congregate.R;
import com.example.stevenzafrani.congregate.adapters.AdapterHomeViewPager;
import com.example.stevenzafrani.congregate.fragments.AlgorithmFragment;
import com.example.stevenzafrani.congregate.fragments.HomeFragment;
import com.example.stevenzafrani.congregate.fragments.YoutubeFeedFragment;

import static com.example.stevenzafrani.congregate.R.id.container;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    TabItem youtubeButton;
    TabItem algorithmButton;
    TabItem homeButton;
    TabLayout homeTab;
    ViewPager viewPager;

    public HomeActivity() {



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_home);

        if (savedInstanceState ==null) {
            getSupportFragmentManager().beginTransaction().add(container, new HomeFragment()).commit();


        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        youtubeButton = (TabItem) this.findViewById(R.id.button_select_youtube);
        algorithmButton = (TabItem) this.findViewById(R.id.button_select_algorithm);
        homeButton = (TabItem) this.findViewById(R.id.button_select_home);
        homeTab = (TabLayout) this.findViewById(R.id.tab_home);
        viewPager = (ViewPager) this.findViewById(R.id.viewpager_home);
        homeViewPagerSetup(viewPager);

        homeTab.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    public void homeViewPagerSetup(ViewPager viewpager) {
        AdapterHomeViewPager homeViewPagerAdapter = new AdapterHomeViewPager(getSupportFragmentManager());
        homeViewPagerAdapter.addFragment(new HomeFragment(), "HOME");
        homeViewPagerAdapter.addFragment(new YoutubeFeedFragment(), "YOUTUBE");
        homeViewPagerAdapter.addFragment(new AlgorithmFragment(), "ALGORITHM");
        viewpager.setAdapter(homeViewPagerAdapter);

    }

    public void startSettingsActivity(String settingsName) {
            Intent intent = new Intent(this, SettingsActivity.class);
            intent.putExtra("settingsName", settingsName);
            startActivity(intent);

    }

    @Override
    public void onClick(View view) {

    }
}
