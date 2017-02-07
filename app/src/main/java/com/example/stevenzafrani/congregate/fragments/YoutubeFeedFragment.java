package com.example.stevenzafrani.congregate.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.stevenzafrani.congregate.R;
import com.example.stevenzafrani.congregate.activities.HomeActivity;
import com.example.stevenzafrani.congregate.adapters.AdapterYoutube;
import com.example.stevenzafrani.congregate.interactors.FetchYoutubeData;
import com.example.stevenzafrani.congregate.models.YoutubeVideo;

public class YoutubeFeedFragment extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private AdapterYoutube adapterYoutube;
    private ImageView settingsButton;

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View rootView = inflater.inflate(R.layout.fragment_youtube, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_youtube);
        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterYoutube = new AdapterYoutube(getActivity().getPackageManager(), new YoutubeVideo[11]);
        recyclerView.setAdapter(adapterYoutube);
        settingsButton = (ImageView) rootView.findViewById(R.id.imageView_settings);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeActivity)getActivity()).startSettingsActivity();
            }
        });
        return rootView;

    }

    @Override
    public void onStart() {
        super.onStart();
        adapterYoutube.notifyDataSetChanged();
        updateVideos();
    }
    public void updateVideos() {
        FetchYoutubeData fetchYoutubeData = new FetchYoutubeData(adapterYoutube);
        fetchYoutubeData.execute("Hello");
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}
