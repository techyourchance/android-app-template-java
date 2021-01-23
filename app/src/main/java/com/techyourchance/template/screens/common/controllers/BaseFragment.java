package com.techyourchance.template.screens.common.controllers;

import com.techyourchance.template.common.dependencyinjection.controller.ControllerComponent;
import com.techyourchance.template.common.dependencyinjection.controller.ControllerModule;
import com.techyourchance.template.common.dependencyinjection.controller.ViewMvcModule;

import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {

    private boolean mIsControllerComponentUsed = false;

    @UiThread
    protected ControllerComponent getControllerComponent() {
        if (mIsControllerComponentUsed) {
            throw new IllegalStateException("must not use ControllerComponent more than once");
        }
        mIsControllerComponentUsed = true;
        return ((BaseActivity)getActivity())
                .getActivityComponent()
                .newControllerComponent(new ControllerModule(), new ViewMvcModule());
    }
}
