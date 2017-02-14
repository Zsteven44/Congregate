package com.example.stevenzafrani.congregate.interactors;


import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.example.stevenzafrani.congregate.adapters.AdapterYoutube;
import com.example.stevenzafrani.congregate.configs.config;
import com.example.stevenzafrani.congregate.models.YoutubeVideo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchYoutubeData extends AsyncTask<String, Void, YoutubeVideo[]> {
    private final String LOG_TAG = FetchYoutubeData.class.getSimpleName();
    public final int NUMBER_VIDEOS_RETURNED = 25;
    AdapterYoutube adapterYoutube;


    public FetchYoutubeData(AdapterYoutube adapter) {
        this.adapterYoutube = adapter;
        Log.v(LOG_TAG, "FetchYoutubeData created.");
    }

    public YoutubeVideo[] getYoutubeDataFromJSON(String dataJsonString) throws JSONException {
        String OWM_ITEMS = "items";
        String OWM_SNIPPET = "snippet";
        String OWM_THUMBNAIL = "thumbnails";

        String OWM_ID = "id";
        String OWM_TITLE = "title";
        String OWM_DESCRIPTION = "description";
        String OWM_LINK = "link";
        String OWM_DEFAULT = "default";
        String OWM_MEDIUM = "medium";
        String OWM_HIGH = "high";
        String OWM_STANDARD = "standard";
        String OWM_THUMBNAIL_URL = "url";

        JSONObject jsonObject = new JSONObject(dataJsonString);
        Log.v(LOG_TAG, "Reiterate the jsonObject: " + jsonObject.toString());
        JSONArray jsonArray = jsonObject.getJSONArray(OWM_ITEMS);
        YoutubeVideo[] youtubeItems = new YoutubeVideo[jsonArray.length()];
        for (int i =0; i<jsonArray.length();i++) {
            String videoTitle;
            String videoDescription;
            String videoId;
            String videoLink;
            String videoThumbnailDefault;
            String videoThumbnailMedium;
            String videoThumbnailHigh;
            String videoThumbnailStandard;
            JSONObject videoItem = jsonArray.getJSONObject(i);
            Log.v(LOG_TAG, "THe json video indiividual item: " + videoItem.toString());
            videoId                 = videoItem.getString(OWM_ID);
            Log.v(LOG_TAG, "The video id: " + videoId);
            videoTitle              = videoItem.getJSONObject(OWM_SNIPPET).getString(OWM_TITLE);
            Log.v(LOG_TAG, "The video title: " + videoTitle);
            videoDescription        = videoItem.getJSONObject(OWM_SNIPPET).getString(OWM_DESCRIPTION);
            Log.v(LOG_TAG, "The video Description: " + videoDescription);
            videoLink               = "http://youtube.com/watch?v=" + videoId;
            Log.v(LOG_TAG, "The video link: " + videoLink);


            videoThumbnailDefault   = videoItem.getJSONObject(OWM_SNIPPET).getJSONObject(OWM_THUMBNAIL).getJSONObject(OWM_DEFAULT).getString(OWM_THUMBNAIL_URL);
            videoThumbnailMedium    = videoItem.getJSONObject(OWM_SNIPPET).getJSONObject(OWM_THUMBNAIL).getJSONObject(OWM_MEDIUM).getString(OWM_THUMBNAIL_URL);
            videoThumbnailHigh      = videoItem.getJSONObject(OWM_SNIPPET).getJSONObject(OWM_THUMBNAIL).getJSONObject(OWM_HIGH).getString(OWM_THUMBNAIL_URL);




            youtubeItems[i] = new YoutubeVideo(videoTitle, videoDescription, videoId, videoLink,
                    videoThumbnailDefault, videoThumbnailMedium, videoThumbnailHigh, null);

        }
        for (YoutubeVideo item: youtubeItems){
            Log.v(LOG_TAG, "Video entry: " + item);
        }
        return youtubeItems;
    }


    @Override
    protected YoutubeVideo[] doInBackground(String... params) {
        if (params.length ==0 ){
            return null;
        }
        Log.v(LOG_TAG, "doInBackground running.");
        HttpURLConnection urlConnection = null;
        BufferedReader reader  =null;

        String dataJsonString = null;
        String sort_by = params[0];

        try {
            final String YOUTUBE_BASE_URL = "https://www.googleapis.com/youtube/v3/videos";
            final String PART_PARAM =  "part";
            final String CHART_PARAM = "chart"; // This needs to be corrected to the actual parameter name.
            final String CATEGORY_PARAM = "videoCategoryId";
            final String APP_ID_PARAM = "key";

            final String PART_QUERY = "player,snippet";
            final String CHART_QUERY = "mostPopular";
            final String CATERGORY_QUERY = "1";

            Uri builtUri = Uri.parse(YOUTUBE_BASE_URL).buildUpon()
                    .appendQueryParameter(PART_PARAM, PART_QUERY)
                    .appendQueryParameter(CHART_PARAM,CHART_QUERY)
                    .appendQueryParameter(CATEGORY_PARAM,CATERGORY_QUERY)
                    .appendQueryParameter(APP_ID_PARAM, config.YOUTUBE_API_KEY)
                    .build();
            URL url = new URL(builtUri.toString());

            Log.v(LOG_TAG, "Built URI " + builtUri.toString());

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            if (inputStream == null) {
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0){
                return null;
            }
            dataJsonString = buffer.toString();
            Log.v(LOG_TAG, "JSON youtube video String: " + dataJsonString);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error ", e);
            return null;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        if (reader != null) {
            try {
                reader.close();
            } catch (final IOException e) {
                Log.e(LOG_TAG, "Error closing stream", e);
            }
        }
        try {
            return getYoutubeDataFromJSON(dataJsonString);
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
            e.printStackTrace();
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


    @Override
    protected void onPostExecute(YoutubeVideo[] result) {

        if (result != null) {
            Log.v(LOG_TAG, result.toString());
            adapterYoutube.setData(result);


            adapterYoutube.notifyDataSetChanged();
        } else {
            Log.v(LOG_TAG,"No data acquired for the recyclerview adapter from the youtube data.");
        }

    }


}
