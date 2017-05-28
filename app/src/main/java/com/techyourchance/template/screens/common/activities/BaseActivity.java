package com.techyourchance.template.screens.common.activities;

import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;

import com.techyourchance.template.MyApplication;
import com.techyourchance.template.common.dependencyinjection.controller.ControllerComponent;
import com.techyourchance.template.common.dependencyinjection.controller.ControllerModule;

public abstract class BaseActivity extends AppCompatActivity {

    private ControllerComponent mControllerComponent;

    /**
     * @return controller injector of type {@link ControllerComponent}
     */
    @UiThread
    protected ControllerComponent getControllerComponent() {
        if (mControllerComponent == null) {
            mControllerComponent =
                    ((MyApplication)getApplication()).getApplicationComponent()
                    .newControllerComponent(new ControllerModule(this, getSupportFragmentManager()));
        }
        return mControllerComponent;
    }
}
