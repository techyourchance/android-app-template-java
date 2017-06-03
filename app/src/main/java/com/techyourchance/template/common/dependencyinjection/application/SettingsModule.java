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
public class SettingsModule {

    @Provides
    @ApplicationScope
    SettingsManager settingsManager(Application application) {
        SharedPreferences sharedPreferences = application
                .getSharedPreferences(Constants.SHARED_PREFS_FILE, Context.MODE_PRIVATE);
        return new SettingsManager(new SharedPrefsSettingsEntryFactory(sharedPreferences));
    }

}
