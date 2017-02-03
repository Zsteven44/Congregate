package com.example.stevenzafrani.congregate.interactors;


import android.net.Uri;
import android.os.AsyncTask;

import com.example.stevenzafrani.congregate.configs.config;
import com.example.stevenzafrani.congregate.models.ListItemYoutube;

import org.json.JSONException;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchYoutubeData extends AsyncTask<String, Void, ListItemYoutube> {

    public void getYoutubeDataFromJSON(String videoJsonString) throws JSONException {

    }


    @Override
    protected ListItemYoutube doInBackground(String... params) {
        if (params.length ==0 ){
            return null;
        }

        HttpURLConnection urlConnection = null;
        BufferedReader bufferedReader  =null;

        String dataJsonString = null;
        String sort_by = params[0];

        try {
            final String YOUTUBE_BASE_URL = "https://www.googleapis.com/youtube/v3/videos";
            final String SORT_BY_PARAM = "sort_by"; // This needs to be corrected to the actual parameter name.
            final String APP_ID_PARAM = "api_key";

            Uri builtUri = Uri.parse(YOUTUBE_BASE_URL).buildUpon()
                    .appendPath((params[0]))
                    .appendQueryParameter(APP_ID_PARAM, config.YOUTUBE_API_KEY)
                    .build();
            URL url = new URL(builtUri.toString());



        }
        return null;
    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    /*
    @Override
    protected void onPostExecute(Movie[] result) {
        if (result != null) {
            movieAdapter.clear();
            for(Movie movie : result) {
                movieAdapter.add(movie);

            }
            movieAdapter.notifyDataSetChanged();
        } else {
            CharSequence text = "There seems to be an error, please check your network connectivity.";
            int duration = Toast.LENGTH_SHORT;
            Toast.makeText(getActivity(), text, duration).show();
        }
    }
    */
}
