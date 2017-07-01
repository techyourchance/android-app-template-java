package com.techyourchance.template.screens.common.activities;

import android.support.annotation.UiThread;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.techyourchance.template.MyApplication;
import com.techyourchance.template.dependencyinjection.controller.ControllerComponent;
import com.techyourchance.template.dependencyinjection.controller.ControllerModule;
import com.techyourchance.template.dependencyinjection.controller.ViewMvcModule;

public abstract class BaseActivity extends FragmentActivity {

    private ControllerComponent mControllerComponent;

    /**
     * @return controller injector of type {@link ControllerComponent}
     */
    @UiThread
    protected ControllerComponent getControllerComponent() {
        if (mControllerComponent == null) {
            mControllerComponent =
                    ((MyApplication)getApplication()).getApplicationComponent()
                    .newControllerComponent(
                            new ControllerModule(this),
                            new ViewMvcModule());
        }
        return mControllerComponent;
    }
}
