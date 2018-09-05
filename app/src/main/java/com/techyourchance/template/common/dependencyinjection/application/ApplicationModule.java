package com.techyourchance.template.common.dependencyinjection.application;

import android.app.Application;

import com.techyourchance.template.common.logging.MyLogger;

import org.greenrobot.eventbus.EventBus;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationScope
    Application application() {
        return mApplication;
    }

    @Provides
    @ApplicationScope
    MyLogger logger() {
        return new MyLogger();
    }

    @Provides
    @ApplicationScope
    EventBus eventBus() {
        return EventBus.getDefault();
    }

}
