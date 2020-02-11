package com.limprove.actorschatsample.presentation.actor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.limprove.actorschatsample.domain.model.Actor;
import com.limprove.actorschatsample.domain.pagination.ActorsDataSourceFactory;
import com.limprove.actorschatsample.domain.repository.ActorRepository;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ActorViewModel extends ViewModel {

    private final ActorRepository repository;

    private Executor networkExecutor = Executors.newFixedThreadPool(5);
    private PagedList.Config pagedListConfig = new PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(10)
            .setInitialLoadSizeHint(10)
            .build();

    public ActorViewModel(ActorRepository repository) {
        this.repository = repository;
    }

    LiveData<PagedList<Actor>> getActors() {
        ActorsDataSourceFactory factory = repository.provideDataSourceFactory();
        return new LivePagedListBuilder<>(factory, pagedListConfig)
                .setFetchExecutor(networkExecutor)
                .build();
    }
}
