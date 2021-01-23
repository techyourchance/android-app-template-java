package com.techyourchance.template.screens.common.dialogs;

import com.techyourchance.dialoghelper.DialogHelper;
import com.techyourchance.template.screens.common.dialogs.info.InfoDialog;
import com.techyourchance.template.screens.common.dialogs.prompt.PromptDialog;

import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.fragment.app.DialogFragment;

@UiThread
public class DialogsManager {

    private final DialogHelper mDialogHelper;

    public DialogsManager(DialogHelper dialogHelper) {
        mDialogHelper = dialogHelper;
    }

    /**
     * @return a reference to currently shown dialog, or null if no dialog is shown.
     */
    public @Nullable DialogFragment getCurrentlyShownDialog() {
        return mDialogHelper.getCurrentlyShownDialog();
    }

    /**
     * Obtain the id of the currently shown dialog.
     * @return the id of the currently shown dialog; null if no dialog is shown, or the currently
     *         shown dialog has no id
     */
    public @Nullable String getCurrentlyShownDialogId() {
        return mDialogHelper.getCurrentlyShownDialogId();
    }

    /**
     * Check whether a dialog with a specified id is currently shown
     * @param id dialog id to query
     * @return true if a dialog with the given id is currently shown; false otherwise
     */
    public boolean isDialogCurrentlyShown(String id) {
        return id.equals(mDialogHelper.getCurrentlyShownDialogId());
    }

    /**
     * Dismiss the currently shown dialog. Has no effect if no dialog is shown.
     */
    public void dismissCurrentlyShownDialog() {
        mDialogHelper.dismissCurrentlyShownDialog();
    }

    public String getDialogId(DialogFragment dialog) {
        return mDialogHelper.getDialogId(dialog);
    }

    /**
     * Show a new instance of {@link InfoDialog}.
     * @param title dialog's title
     * @param message dialog's message
     * @param buttonCaption dialog's button caption
     * @param id dialog's ID; can be null
     */
    public void showInfoDialog(String title,
                               String message,
                               String buttonCaption,
                               @Nullable String id) {
        InfoDialog dialog = InfoDialog.newInstance(title, message, buttonCaption);
        mDialogHelper.showDialog(dialog, id);
    }

    /**
     * Show a new instance of {@link PromptDialog}.
     * @param title dialog's title
     * @param message dialog's message
     * @param positiveButtonCaption dialog's positive button caption
     * @param negativeButtonCaption dialog's negative button caption
     * @param id dialog's ID; can be null
     */
    public void newPromptDialog(String title,
                                String message,
                                String positiveButtonCaption,
                                String negativeButtonCaption,
                                @Nullable String id) {
        PromptDialog dialog = PromptDialog.newInstance(title, message, positiveButtonCaption, negativeButtonCaption);
        mDialogHelper.showDialog(dialog, id);
    }
}
