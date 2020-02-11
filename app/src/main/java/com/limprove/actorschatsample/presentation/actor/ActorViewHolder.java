package com.limprove.actorschatsample.presentation.actor;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.limprove.actorschatsample.databinding.ActorItemSimpleBinding;
import com.limprove.actorschatsample.domain.model.Actor;
import com.limprove.actorschatsample.presentation.detail.DetailActivity;

class ActorViewHolder extends RecyclerView.ViewHolder {

    private ActorItemSimpleBinding binding;

    private ActorViewHolder(@NonNull ActorItemSimpleBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        binding.getRoot().setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DetailActivity.class);
            intent.putExtra("currentActor", binding.getActor().id);
            v.getContext().startActivity(intent);
        });
    }

    static ActorViewHolder create(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ActorItemSimpleBinding binding = ActorItemSimpleBinding.inflate(inflater, parent, false);
        return new ActorViewHolder(binding);
    }

    void bind(Actor actor) {
        binding.setActor(actor);
        binding.executePendingBindings();
    }
}
