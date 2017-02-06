package com.example.stevenzafrani.congregate.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.stevenzafrani.congregate.R;
import com.example.stevenzafrani.congregate.fragments.AlgorithmFragment;
import com.example.stevenzafrani.congregate.fragments.HomeFragment;
import com.example.stevenzafrani.congregate.fragments.YoutubeFeedFragment;

import static com.example.stevenzafrani.congregate.R.id.container;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {


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
        Button youtubeButton = (Button) findViewById(R.id.button_select_youtube);
        Button algorithmButton = (Button) findViewById(R.id.button_select_algorithm);
        Button homeButton = (Button) findViewById(R.id.button_select_home);
        youtubeButton.setOnClickListener(this);
        algorithmButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_select_home:
                getSupportFragmentManager().beginTransaction().replace(container, new HomeFragment()).commit();
                break;
            case R.id.button_select_algorithm:
                getSupportFragmentManager().beginTransaction().replace(container, new AlgorithmFragment()).commit();
                break;
            case R.id.button_select_youtube:
                getSupportFragmentManager().beginTransaction().replace(container, new YoutubeFeedFragment()).commit();
                break;
            default:
                break;
        }
    }
}
