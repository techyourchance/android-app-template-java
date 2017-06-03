package com.techyourchance.template.common.dependencyinjection.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.techyourchance.template.common.Constants;
import com.techyourchance.template.common.logging.MyLogger;
import com.techyourchance.template.common.multithreading.BackgroundThreadPoster;
import com.techyourchance.template.common.multithreading.MainThreadPoster;
import com.techyourchance.template.common.settings.SettingsManager;
import com.techyourchance.template.common.settings.sharedpreferences.SharedPrefsSettingsEntryFactory;

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

    @Provides
    @ApplicationScope
    MainThreadPoster mainThreadPoster() {
        return new MainThreadPoster();
    }

    @Provides
    @ApplicationScope
    BackgroundThreadPoster backgroundThreadPoster() {
        return new BackgroundThreadPoster();
    }
}
