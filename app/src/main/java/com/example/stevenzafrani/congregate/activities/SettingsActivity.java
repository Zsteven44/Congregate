package com.example.stevenzafrani.congregate.activities;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import com.example.stevenzafrani.congregate.R;
import com.example.stevenzafrani.congregate.fragments.YoutubeSettingsFragment;

import static com.example.stevenzafrani.congregate.R.id.container;

public class SettingsActivity extends PreferenceActivity implements Preference.OnPreferenceChangeListener {
    public SettingsActivity() {
        getFragmentManager().beginTransaction().add(container, new YoutubeSettingsFragment()).commit();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_settings);
    }


    @Override
    public boolean onPreferenceChange(Preference preference, Object o) {
        return false;
    }
}
