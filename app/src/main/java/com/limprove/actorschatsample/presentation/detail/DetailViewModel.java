package com.limprove.actorschatsample.presentation.detail;

import androidx.arch.core.util.Function;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.limprove.actorschatsample.domain.model.Actor;
import com.limprove.actorschatsample.domain.repository.ActorRepository;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class DetailViewModel extends ViewModel {

    private ActorRepository repository;
    private CompositeDisposable disposable = new CompositeDisposable();

    public ObservableField<String> speech = new ObservableField<>();
    public ObservableField<String> created = new ObservableField<>();

    private MutableLiveData<Actor> _currentActor = new MutableLiveData<>();
    public LiveData<Actor> getActor = _currentActor;

    public DetailViewModel(ActorRepository repository) {
        this.repository = repository;
    }

    void populateFields(Actor actor) {
        speech.set(actor.speech);
        created.set(String.valueOf(actor.created));
    }

    void provideActor(int actorId) {
        Single<Actor> actorSingle = repository.getActor(actorId);
        disposable.add(actorSingle
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<Actor>() {
            @Override
            public void onSuccess(Actor actor) {
                _currentActor.postValue(actor);
            }

            @Override
            public void onError(Throwable e) {
                Timber.d(e);
            }
        }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
