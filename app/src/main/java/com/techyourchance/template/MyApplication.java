package com.techyourchance.template;

import android.app.Application;
import androidx.annotation.UiThread;
import timber.log.Timber;

import com.techyourchance.template.common.dependencyinjection.application.ApplicationComponent;
import com.techyourchance.template.common.dependencyinjection.application.ApplicationModule;
import com.techyourchance.template.common.dependencyinjection.application.DaggerApplicationComponent;
import com.techyourchance.template.common.dependencyinjection.application.SettingsModule;
import com.techyourchance.template.common.logging.TimberReleaseTree;

public class MyApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new TimberReleaseTree());
        }
    }

    /**
     * @return application injector of type {@link ApplicationComponent}
     */
    @UiThread
    public ApplicationComponent getApplicationComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .settingsModule(new SettingsModule())
                    .build();
        }
        return mApplicationComponent;
    }
}
