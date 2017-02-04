package com.example.stevenzafrani.congregate.adapters;


import android.content.pm.PackageManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.stevenzafrani.congregate.R;

public class AdapterYoutube extends RecyclerView.Adapter<AdapterYoutube.ViewHolder> {

    public AdapterYoutube(PackageManager packageManager) {

    }

    @Override
    public AdapterYoutube.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(AdapterYoutube.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public String thumbnailDefault;

        public ViewHolder(View v) {
            super(v);
            thumbnailDefault = (View) v.findViewById(R.id.placeholder_youtube);

        }
    }
}
