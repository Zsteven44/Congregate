package com.example.stevenzafrani.congregate.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import com.example.stevenzafrani.congregate.R;

import static com.example.stevenzafrani.congregate.R.id.container;

public class SettingsActivity extends PreferenceActivity implements Preference.OnPreferenceChangeListener {
    public SettingsActivity(Fragment fragment) {
        getFragmentManager().beginTransaction().add(container, fragment).commit();


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
