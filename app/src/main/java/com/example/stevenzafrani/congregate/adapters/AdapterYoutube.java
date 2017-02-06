package com.example.stevenzafrani.congregate.adapters;


import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.stevenzafrani.congregate.R;
import com.example.stevenzafrani.congregate.models.YoutubeVideo;

public class AdapterYoutube extends RecyclerView.Adapter<AdapterYoutube.ViewHolder> {
    private YoutubeVideo[] youtubeVideos;
    private static int ITEM_TYPE = 1;
    public AdapterYoutube(PackageManager packageManager, YoutubeVideo[] videos) {
        this.youtubeVideos = videos;
    }

    public void setData(YoutubeVideo[] videos) {
        this.youtubeVideos = videos;
    }
    @Override
    public AdapterYoutube.YoutubeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new YoutubeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_youtube, parent, false));
    }

    @Override
    public void onBindViewHolder(AdapterYoutube.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemViewType(int position) {
        return ITEM_TYPE;
    }

    @Override
    public int getItemCount() {
        return youtubeVideos.length;
    }


    abstract class ViewHolder extends RecyclerView.ViewHolder {

        private ViewHolder(@NonNull final View itemView) {
            super(itemView);
        }

        protected abstract void bind(final int position);
    }

    private class YoutubeViewHolder extends ViewHolder{
        private TextView titleTextView;
        private TextView descriptionTextView;
        private TextView idTextView;
        private TextView linkTextView;

        public YoutubeViewHolder(View v) {
            super(v);
            titleTextView = (TextView) v.findViewById(R.id.recyclerview_youtube_title);
            descriptionTextView = (TextView) v.findViewById(R.id.recyclerview_youtube_description);
            idTextView = (TextView) v.findViewById(R.id.recyclerview_youtube_id);
            linkTextView = (TextView) v.findViewById(R.id.recyclerview_youtube_link);
        }

        @Override
        protected void bind(int position) {
            final YoutubeVideo video = youtubeVideos[position];
            try {
                titleTextView.setText(video.getTitle());
                descriptionTextView.setText(video.getDescription());
                linkTextView.setText(video.getLink());
                idTextView.setText(video.getId());
            } catch (NullPointerException e) {
                Log.v(AdapterYoutube.class.getSimpleName(), "error in retrieving video data.");
            }
        }


    }

}
