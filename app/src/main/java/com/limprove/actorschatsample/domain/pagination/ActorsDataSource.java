package com.limprove.actorschatsample.domain.pagination;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.limprove.actorschatsample.domain.model.Actor;
import com.limprove.actorschatsample.data.api.OicoClient;
import com.limprove.actorschatsample.data.api.OicoService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class ActorsDataSource extends PageKeyedDataSource<Integer, Actor> {

    private OicoService oicoService = OicoClient.provideService();

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Actor> callback) {
        Timber.d("Initial data source");
        oicoService.searchActors(10, 1).enqueue(new Callback<List<Actor>>() {
            @Override
            public void onResponse(@NonNull Call<List<Actor>> call, @NonNull Response<List<Actor>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        List<Actor> actors = response.body();
                        callback.onResult(actors, 1, 10);
                    } else {
                        callback.onResult(new ArrayList<>(), null, null);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Actor>> call, @NonNull Throwable t) {
                Timber.d(t);
            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Actor> callback) {}

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Actor> callback) {
        Timber.d("Fetching currentActor: %s", params.key);
        oicoService.searchActors(10, params.key).enqueue(new Callback<List<Actor>>() {
            @Override
            public void onResponse(@NonNull Call<List<Actor>> call, @NonNull Response<List<Actor>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        List<Actor> actors = response.body();
                        callback.onResult(actors, params.key + 10);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Actor>> call, @NonNull Throwable t) {
                Timber.d(t);
            }
        });
    }
}
