package com.limprove.actorschatsample.presentation.detail;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.limprove.actorschatsample.databinding.ChipTagBinding;

public class DetailTagsViewHolder extends RecyclerView.ViewHolder {

    private ChipTagBinding binding;

    private DetailTagsViewHolder(@NonNull ChipTagBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    static DetailTagsViewHolder create(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ChipTagBinding binding = ChipTagBinding.inflate(inflater, parent, false);
        return new DetailTagsViewHolder(binding);
    }

    void bind(String text) {
        binding.setText(text);
        binding.executePendingBindings();
    }
}
