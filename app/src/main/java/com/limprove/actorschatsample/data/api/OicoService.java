package com.limprove.actorschatsample.data.api;

import com.limprove.actorschatsample.domain.model.Actor;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OicoService {

    @GET("test/")
    Call<List<Actor>> searchActors(@Query("limit") Integer limit, @Query("offset") Integer offset);

    @GET("test/{currentActor}")
    Single<Actor> getActor(@Path("currentActor") int actor);
}
