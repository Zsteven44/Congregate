package com.example.stevenzafrani.congregate.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.stevenzafrani.congregate.R;
import com.example.stevenzafrani.congregate.adapters.AdapterHomeViewPager;
import com.example.stevenzafrani.congregate.clickListeners.DrawerItemClickListener;
import com.example.stevenzafrani.congregate.fragments.AlgorithmFragment;
import com.example.stevenzafrani.congregate.fragments.HomeFragment;
import com.example.stevenzafrani.congregate.fragments.YoutubeFeedFragment;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    // Tab Layout
    TabItem youtubeButton;
    TabItem algorithmButton;
    TabItem homeButton;
    TabLayout homeTab;
    ViewPager viewPager;

    // Navigation Drawer
    private String[] mActivityTitles;
    private String mTitle;
    private String mDrawerTitle;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    // Action Bar
    private Toolbar myToolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    public HomeActivity() {



    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_home);
        if (savedInstanceState ==null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new HomeFragment()).commit();
        }
        mTitle = mDrawerTitle = getTitle().toString();
        mActivityTitles = getResources().getStringArray(R.array.navigationDrawerHome);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mActivityTitles));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener(this));

        // Action bar
        myToolbar = (Toolbar) findViewById(R.id.activity_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);

        mDrawerToggle =new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                myToolbar,             /* Toolbar */
                R.string.menu_drawer_open,  /* "open drawer" description for accessibility */
                R.string.menu_drawer_close  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {

                getSupportActionBar().setTitle("Home");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle("Home");
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        /**
         *         enable ActionBar app icon to behave as action to toggle nav drawer
         *         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         *         getSupportActionBar().setHomeButtonEnabled(true);

         *
         */


    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
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
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

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
