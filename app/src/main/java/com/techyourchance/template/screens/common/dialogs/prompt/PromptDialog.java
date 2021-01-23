package com.techyourchance.template.screens.common.dialogs.prompt;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.techyourchance.template.common.eventbus.EventBusPoster;
import com.techyourchance.template.screens.common.dialogs.BaseDialog;

import javax.inject.Inject;

import androidx.annotation.NonNull;


/**
 * A dialog that can show title and message and has two buttons. User's actions performed
 * in this dialog will be posted to event bus as {@link PromptDialogDismissedEvent}.
 */
public class PromptDialog extends BaseDialog implements PromptViewMvc.PromptViewMvcListener {

    private static final String ARG_TITLE = "ARG_TITLE";
    private static final String ARG_MESSAGE = "ARG_MESSAGE";
    private static final String ARG_POSITIVE_BUTTON_CAPTION = "ARG_POSITIVE_BUTTON_CAPTION";
    private static final String ARG_NEGATIVE_BUTTON_CAPTION = "ARG_NEGATIVE_BUTTON_CAPTION";

    public static PromptDialog newInstance(String title,
                                           String message,
                                           String positiveButtonCaption,
                                           String negativeButtonCaption) {
        Bundle args = new Bundle(4);
        args.putString(PromptDialog.ARG_TITLE, title);
        args.putString(PromptDialog.ARG_MESSAGE, message);
        args.putString(PromptDialog.ARG_POSITIVE_BUTTON_CAPTION, positiveButtonCaption);
        args.putString(PromptDialog.ARG_NEGATIVE_BUTTON_CAPTION, negativeButtonCaption);

        PromptDialog promptDialog = new PromptDialog();
        promptDialog.setArguments(args);

        return promptDialog;
    }
    
    @Inject EventBusPoster mEventBusPoster;

    private PromptViewMvc mPromptViewMvc;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        getControllerComponent().inject(this);

        setCancelable(true);

        initViewMvc();

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        dialogBuilder.setView(mPromptViewMvc.getRootView());
        return dialogBuilder.create();
    }

    private void initViewMvc() {
        mPromptViewMvc = new PromptViewMvcImpl(LayoutInflater.from(getActivity()), null);
        mPromptViewMvc.setTitle(getArguments().getString(ARG_TITLE));
        mPromptViewMvc.setMessage(getArguments().getString(ARG_MESSAGE));
        mPromptViewMvc.setPositiveButtonCaption(getArguments().getString(ARG_POSITIVE_BUTTON_CAPTION));
        mPromptViewMvc.setNegativeButtonCaption(getArguments().getString(ARG_NEGATIVE_BUTTON_CAPTION));
        mPromptViewMvc.registerListener(this);
    }

    @Override
    public void onPositiveButtonClicked() {
        dismiss();
        mEventBusPoster.post(new PromptDialogDismissedEvent(
                getDialogId(), PromptDialogDismissedEvent.BUTTON_POSITIVE));
    }

    @Override
    public void onNegativeButtonClicked() {
        dismiss();
        mEventBusPoster.post(new PromptDialogDismissedEvent(
                getDialogId(), PromptDialogDismissedEvent.BUTTON_NEGATIVE));
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        dismiss();
        mEventBusPoster.post(new PromptDialogDismissedEvent(
                getDialogId(), PromptDialogDismissedEvent.BUTTON_NONE));
    }

}
