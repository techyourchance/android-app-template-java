package com.techyourchance.template.common.dependencyinjection.application;

import android.app.Application;

import com.techyourchance.template.common.eventbus.EventBusPoster;
import com.techyourchance.template.common.eventbus.EventBusSubscriber;
import com.techyourchance.threadposter.BackgroundThreadPoster;
import com.techyourchance.threadposter.UiThreadPoster;

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
    EventBusPoster eventBusPoster() {
        return new EventBusPoster(EventBus.getDefault());
    }

    @Provides
    @ApplicationScope
    EventBusSubscriber eventBusSubscriber() {
        return new EventBusSubscriber(EventBus.getDefault());
    }

    @Provides
    @ApplicationScope
    UiThreadPoster uiThreadPoster() {
        return new UiThreadPoster();
    }

    @Provides
    @ApplicationScope
    BackgroundThreadPoster backgroundThreadPoster() {
        return new BackgroundThreadPoster();
    }


}
