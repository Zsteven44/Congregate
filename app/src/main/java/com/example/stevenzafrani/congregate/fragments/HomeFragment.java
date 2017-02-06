package com.example.stevenzafrani.congregate.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stevenzafrani.congregate.R;
import com.example.stevenzafrani.congregate.adapters.AdapterYoutube;
import com.example.stevenzafrani.congregate.interactors.FetchYoutubeData;
import com.example.stevenzafrani.congregate.models.YoutubeVideo;

public class HomeFragment extends Fragment {
    public String video_id = "EGy39OMyHzw";
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private AdapterYoutube adapterYoutube;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView_youtube);

        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapterYoutube = new AdapterYoutube(getActivity().getPackageManager(), new YoutubeVideo[11]);
        recyclerView.setAdapter(adapterYoutube);







        /* This needs to be moved to the youtube adapter binding.
        YouTubePlayerSupportFragment youTubePlayerSupportFragment = YouTubePlayerSupportFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.placeholder_youtube, youTubePlayerSupportFragment).commit();
        youTubePlayerSupportFragment.initialize(config.YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
                if (!wasRestored) {
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    player.loadVideo(video_id);
                    player.play();
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {
                String errorMessage = error.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });
        */



        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
}
