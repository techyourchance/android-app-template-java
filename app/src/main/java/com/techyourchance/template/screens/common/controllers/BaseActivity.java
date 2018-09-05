package com.techyourchance.template.screens.common.controllers;

import android.support.annotation.UiThread;
import android.support.v4.app.FragmentActivity;

import com.techyourchance.template.MyApplication;
import com.techyourchance.template.common.dependencyinjection.controller.ControllerComponent;
import com.techyourchance.template.common.dependencyinjection.controller.ControllerModule;
import com.techyourchance.template.common.dependencyinjection.controller.ViewMvcModule;

public abstract class BaseActivity extends FragmentActivity {

    private boolean mIsControllerComponentUsed = false;

    @UiThread
    protected ControllerComponent getControllerComponent() {
        if (mIsControllerComponentUsed) {
            throw new IllegalStateException("must not use ControllerComponent more than once");
        }
        mIsControllerComponentUsed = true;
        return ((MyApplication)getApplication())
                .getApplicationComponent()
                .newControllerComponent(new ControllerModule(this), new ViewMvcModule());
    }
}
