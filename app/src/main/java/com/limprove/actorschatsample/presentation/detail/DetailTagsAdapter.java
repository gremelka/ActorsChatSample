package com.limprove.actorschatsample.presentation.detail;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class DetailTagsAdapter extends RecyclerView.Adapter<DetailTagsViewHolder> {

    List<String> tags = new ArrayList<>();

    void addTags(List<String> tags) {
        this.tags.addAll(tags);
    }

    @NonNull
    @Override
    public DetailTagsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return DetailTagsViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailTagsViewHolder holder, int position) {
        Timber.d("Binding tag at position %s", position);
        holder.bind(tags.get(position));
    }

    @Override
    public int getItemCount() {
        return tags.size();
    }
}
