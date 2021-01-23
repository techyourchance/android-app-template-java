package com.techyourchance.template.screens.common.controllers;

import com.techyourchance.template.MyApplication;
import com.techyourchance.template.common.dependencyinjection.activity.ActivityComponent;
import com.techyourchance.template.common.dependencyinjection.activity.ActivityModule;
import com.techyourchance.template.common.dependencyinjection.controller.ControllerComponent;
import com.techyourchance.template.common.dependencyinjection.controller.ControllerModule;
import com.techyourchance.template.common.dependencyinjection.controller.ViewMvcModule;

import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    private ActivityComponent mActivityComponent;

    private boolean mIsControllerComponentUsed = false;

    @UiThread
    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = ((MyApplication)getApplication())
                    .getApplicationComponent()
                    .newActivityComponent(new ActivityModule(this));
        }
        return mActivityComponent;
    }

    @UiThread
    protected ControllerComponent getControllerComponent() {
        if (mIsControllerComponentUsed) {
            throw new IllegalStateException("must not use ControllerComponent more than once");
        }
        mIsControllerComponentUsed = true;
        return getActivityComponent()
                .newControllerComponent(new ControllerModule(), new ViewMvcModule());
    }
}
