package com.limprove.actorschatsample;

import android.app.Application;

import timber.log.Timber;

public class ActorsApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
