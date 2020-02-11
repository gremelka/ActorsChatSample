package com.limprove.actorschatsample.util;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.limprove.actorschatsample.domain.repository.ActorRepository;
import com.limprove.actorschatsample.presentation.actor.ActorViewModel;
import com.limprove.actorschatsample.presentation.detail.DetailViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final ActorRepository repository;

    public ViewModelFactory(ActorRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ActorViewModel.class)) {
            return (T) new ActorViewModel(repository);
        } else if (modelClass.isAssignableFrom(DetailViewModel.class)) {
            return (T) new DetailViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
