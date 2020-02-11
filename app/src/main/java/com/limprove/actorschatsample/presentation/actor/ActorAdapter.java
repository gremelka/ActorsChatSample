package com.limprove.actorschatsample.presentation.actor;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

import com.limprove.actorschatsample.domain.model.Actor;

import timber.log.Timber;

public class ActorAdapter extends PagedListAdapter<Actor, ActorViewHolder> {

    private static final DiffUtil.ItemCallback<Actor> ACTOR_COMPARATOR = new DiffUtil.ItemCallback<Actor>() {
        @Override
        public boolean areItemsTheSame(@NonNull Actor oldItem, @NonNull Actor newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Actor oldItem, @NonNull Actor newItem) {
            return oldItem.equals(newItem);
        }
    };

    public ActorAdapter() {
        super(ACTOR_COMPARATOR);
    }

    @NonNull
    @Override
    public ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ActorViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorViewHolder holder, int position) {
        Timber.d("Binding view holder at position %s", position);
        holder.bind(getItem(position));
    }
}
