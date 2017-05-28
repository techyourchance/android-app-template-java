package com.techyourchance.template.common.dependencyinjection.service;

import android.app.Service;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {

    private final Service mService;

    public ServiceModule(Service service) {
        mService = service;
    }

    @Provides
    Context context() {
        return mService;
    }

    @Provides
    Service service() {
        return mService;
    }


}
