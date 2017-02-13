package com.example.stevenzafrani.congregate.activities;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import com.example.stevenzafrani.congregate.R;


public class SettingsActivity extends PreferenceActivity implements Preference.OnPreferenceChangeListener {
    public SettingsActivity() {


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String settingsName = intent.getStringExtra("settingsName");
        switch (settingsName) {
            case (("Youtube")):
                addPreferencesFromResource(R.xml.preferences_youtube);
                break;
            default:
                break;

        }


    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object o) {
        return false;
    }
}
