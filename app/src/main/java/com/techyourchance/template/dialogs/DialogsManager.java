package com.techyourchance.template.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;

/**
 * This object should be used in activities and fragments in order to manage dialogs.
 */
@UiThread
public class DialogsManager {

    /**
     * Whenever a dialog is shown with non-empty "id", the provided id will be stored in
     * arguments Bundle under this key.
     */
    public static final String ARGUMENT_DIALOG_ID = "ARGUMENT_DIALOG_ID";

    /**
     * In case Activity or Fragment that instantiated this DialogsManager are re-created (e.g.
     * in case of memory reclaim by OS, orientation change, etc.), we need to be able
     * to get a reference to dialog that might have been shown. This tag will be supplied with
     * all DialogFragment's shown by this DialogsManager and can be used to query
     * {@link FragmentManager} for last shown dialog.
     */
    private static final String DIALOG_FRAGMENT_TAG = "DIALOG_FRAGMENT_TAG";


    private FragmentManager mFragmentManager;
    private DialogFragment mCurrentlyShownDialog;

    public DialogsManager(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;

        // there might be some dialog already shown
        Fragment fragmentWithDialogTag = fragmentManager.findFragmentByTag(DIALOG_FRAGMENT_TAG);
        if (fragmentWithDialogTag != null
                && DialogFragment.class.isAssignableFrom(fragmentWithDialogTag.getClass())) {
            mCurrentlyShownDialog = (DialogFragment) fragmentWithDialogTag;
        }
    }

    /**
     * @return a reference to currently shown dialog, or null if no dialog is shown.
     */
    public @Nullable
    DialogFragment getCurrentlyShownDialog() {
        return mCurrentlyShownDialog;
    }

    /**
     * Obtain the id of the currently shown dialog.
     * @return the id of the currently shown dialog; null if no dialog is shown, or the currently
     *         shown dialog has no id
     */
    public @Nullable
    String getCurrentlyShownDialogId() {
        if (mCurrentlyShownDialog == null || mCurrentlyShownDialog.getArguments() == null ||
                !mCurrentlyShownDialog.getArguments().containsKey(ARGUMENT_DIALOG_ID)) {
            return null;
        } else {
            return mCurrentlyShownDialog.getArguments().getString(ARGUMENT_DIALOG_ID);
        }
    }

    /**
     * Check whether a dialog with a specified id is currently shown
     * @param id dialog id to query
     * @return true if a dialog with the given id is currently shown; false otherwise
     */
    public boolean isDialogCurrentlyShown(String id) {
        String shownDialogId = getCurrentlyShownDialogId();
        return !TextUtils.isEmpty(shownDialogId) && shownDialogId.equals(id);
    }

    /**
     * Dismiss the currently shown dialog. Has no effect if no dialog is shown. Please note that
     * we always allow state loss upon dismissal.
     */
    public void dismissCurrentlyShownDialog() {
        if (mCurrentlyShownDialog != null) {
            mCurrentlyShownDialog.dismissAllowingStateLoss();
            mCurrentlyShownDialog = null;
        }
    }

    /**
     * Show dialog and assign it a given "id". Replaces any other currently shown dialog.<br>
     * The shown dialog will be retained across parent activity re-creation.
     * @param dialog dialog to show
     * @param id string that uniquely identifies the dialog; can be null
     */
    public void showRetainedDialogWithId(DialogFragment dialog, @Nullable String id) {
        dismissCurrentlyShownDialog();
        dialog.setRetainInstance(true);
        setId(dialog, id);
        showDialog(dialog);
    }

    private void setId(DialogFragment dialog, String id) {
        Bundle args = dialog.getArguments() != null ? dialog.getArguments() : new Bundle(1);
        args.putString(ARGUMENT_DIALOG_ID, id);
        dialog.setArguments(args);
    }

    private void showDialog(DialogFragment dialog) {
        dialog.show(mFragmentManager, DIALOG_FRAGMENT_TAG);
        mCurrentlyShownDialog = dialog;
    }

}
