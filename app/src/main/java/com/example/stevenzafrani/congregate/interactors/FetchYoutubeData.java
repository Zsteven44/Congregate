package com.example.stevenzafrani.congregate.interactors;


import android.os.AsyncTask;

import com.example.stevenzafrani.congregate.models.ListItemYoutube;

import org.json.JSONException;

public class FetchYoutubeData extends AsyncTask<String, Void, ListItemYoutube> {

    public void getYoutubeDataFromJSON(String videoJsonString) throws JSONException {

    }


    @Override
    protected ListItemYoutube doInBackground(String... params) {
        if (params.length ==0 ){
            return null;
        }

        H
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
