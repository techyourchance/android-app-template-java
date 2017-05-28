package com.techyourchance.template;

import android.app.Application;
import android.support.annotation.UiThread;

import com.techyourchance.template.common.dependencyinjection.application.ApplicationComponent;
import com.techyourchance.template.common.dependencyinjection.application.ApplicationModule;
import com.techyourchance.template.common.dependencyinjection.application.DaggerApplicationComponent;

public class MyApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * @return application injector of type {@link ApplicationComponent}
     */
    @UiThread
    public ApplicationComponent getApplicationComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }
}
