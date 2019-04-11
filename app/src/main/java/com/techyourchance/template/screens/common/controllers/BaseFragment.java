package com.techyourchance.template.screens.common.controllers;

import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;

import com.techyourchance.template.MyApplication;
import com.techyourchance.template.common.dependencyinjection.controller.ControllerComponent;
import com.techyourchance.template.common.dependencyinjection.controller.ControllerModule;
import com.techyourchance.template.common.dependencyinjection.controller.ViewMvcModule;

public abstract class BaseFragment extends Fragment {

    private boolean mIsControllerComponentUsed = false;

    @UiThread
    protected ControllerComponent getControllerComponent() {
        if (mIsControllerComponentUsed) {
            throw new IllegalStateException("must not use ControllerComponent more than once");
        }
        mIsControllerComponentUsed = true;
        return ((MyApplication)getActivity().getApplication())
                .getApplicationComponent()
                .newControllerComponent(new ControllerModule(getActivity()), new ViewMvcModule());
    }
}
