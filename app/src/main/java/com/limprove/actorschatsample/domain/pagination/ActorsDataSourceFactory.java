package com.limprove.actorschatsample.domain.pagination;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.limprove.actorschatsample.domain.model.Actor;

public class ActorsDataSourceFactory extends DataSource.Factory<Integer, Actor> {

    @NonNull
    @Override
    public DataSource<Integer, Actor> create() {
        return new ActorsDataSource();
    }
}
