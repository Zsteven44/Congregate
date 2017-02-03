package com.example.stevenzafrani.congregate.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.stevenzafrani.congregate.R;
import com.example.stevenzafrani.congregate.fragments.HomeFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_home);
        if (savedInstanceState ==null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new HomeFragment()).commit();

        }
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
