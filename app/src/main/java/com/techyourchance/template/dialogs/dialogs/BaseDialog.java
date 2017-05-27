package com.techyourchance.template.dialogs.dialogs;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;

import com.techyourchance.template.dialogs.DialogsManager;

/**
 * Base class for all dialogs
 */
public abstract class BaseDialog extends DialogFragment {

    /**
     * Get this dialog's ID that was supplied with a call to
     * {@link DialogsManager#showRetainedDialogWithId(DialogFragment, String)}
     * @return dialog's ID, or null if none was set
     */
    protected String getDialogId() {
        if (getArguments() == null) {
            return null;
        } else {
            return getArguments().getString(DialogsManager.ARGUMENT_DIALOG_ID);
        }
    }

}
