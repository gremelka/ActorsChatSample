package com.limprove.actorschatsample.domain.repository;

import com.limprove.actorschatsample.data.api.OicoClient;
import com.limprove.actorschatsample.data.api.OicoService;
import com.limprove.actorschatsample.domain.model.Actor;
import com.limprove.actorschatsample.domain.pagination.ActorsDataSourceFactory;

import io.reactivex.Single;

public class ActorRepository {

    //Ideally should be injected by the dagger
    private OicoService service = OicoClient.provideService();

    public ActorsDataSourceFactory provideDataSourceFactory() {
        return new ActorsDataSourceFactory();
    }

    public Single<Actor> getActor(int actorId) {
        return service.getActor(actorId);
    }
}
