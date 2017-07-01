package com.techyourchance.template.screens.common.fragments;

import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;

import com.techyourchance.template.MyApplication;
import com.techyourchance.template.dependencyinjection.controller.ControllerComponent;
import com.techyourchance.template.dependencyinjection.controller.ControllerModule;
import com.techyourchance.template.dependencyinjection.controller.ViewMvcModule;

public abstract class BaseFragment extends Fragment {

    private ControllerComponent mControllerComponent;

    /**
     * @return controller injector of type {@link ControllerComponent}
     */
    @UiThread
    protected ControllerComponent getControllerComponent() {
        if (mControllerComponent == null) {
            mControllerComponent =
                    ((MyApplication)getActivity().getApplication()).getApplicationComponent()
                            .newControllerComponent(
                                    new ControllerModule(getActivity()),
                                    new ViewMvcModule());
        }
        return mControllerComponent;
    }
}
