package com.limprove.actorschatsample.util;

import com.limprove.actorschatsample.domain.repository.ActorRepository;

public class InjectorUtil {

    private static volatile InjectorUtil instance;

    public static InjectorUtil getInstance() {
        InjectorUtil localInstance = instance;
        if (localInstance == null) {
            synchronized (InjectorUtil.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = new InjectorUtil();
                }
            }
        }
        return instance;
    }

    private ActorRepository provideRepository() {
        return new ActorRepository();
    }

    public ViewModelFactory getViewModelFactory() {
        return new ViewModelFactory(provideRepository());
    }
}
