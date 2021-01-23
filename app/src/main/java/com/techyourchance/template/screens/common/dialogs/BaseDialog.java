package com.techyourchance.template.screens.common.dialogs;

import com.techyourchance.template.common.dependencyinjection.controller.ControllerComponent;
import com.techyourchance.template.common.dependencyinjection.controller.ControllerModule;
import com.techyourchance.template.common.dependencyinjection.controller.ViewMvcModule;
import com.techyourchance.template.screens.common.controllers.BaseActivity;

import org.jetbrains.annotations.Nullable;

import androidx.annotation.UiThread;
import androidx.fragment.app.DialogFragment;

/**
 * Base class for all dialogs
 */
public abstract class BaseDialog extends DialogFragment {

    private ControllerComponent mControllerComponent;

    @UiThread
    protected ControllerComponent getControllerComponent() {
        if (mControllerComponent == null) {
            mControllerComponent =
                    ((BaseActivity) getActivity()).getActivityComponent()
                            .newControllerComponent(new ControllerModule(), new ViewMvcModule());
        }
        return mControllerComponent;
    }

    /**
     * Get this dialog's ID that was supplied with a call to one of {@link DialogsManager}'s
     * methods.
     * @return dialog's ID, or null if none was set
     */
    protected @Nullable String getDialogId() {
        return getControllerComponent().getDialogManager().getDialogId(this);
    }

}
