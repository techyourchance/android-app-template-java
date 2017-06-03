package com.techyourchance.template.common.dialogs.info;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;

import com.techyourchance.template.common.dialogs.common.BaseDialog;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;


/**
 * A dialog that can show title and message and has a single button. User's actions performed
 * in this dialog will be posted to {@link EventBus} as {@link InfoDialogDismissedEvent}.
 */
public class InfoDialog extends BaseDialog implements InfoViewMvc.InfoViewMvcListener {

    public static final String ARG_TITLE = "ARG_TITLE";
    public static final String ARG_MESSAGE = "ARG_MESSAGE";
    public static final String ARG_BUTTON_CAPTION = "ARG_POSITIVE_BUTTON_CAPTION";

    @Inject EventBus mEventBus;

    private InfoViewMvc mInfoViewMvc;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        getControllerComponent().inject(this);

        setCancelable(true);

        initViewMvc();

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        dialogBuilder.setView(mInfoViewMvc.getRootView());
        return dialogBuilder.create();
    }

    private void initViewMvc() {
        mInfoViewMvc = new InfoViewMvcImpl(LayoutInflater.from(getActivity()), null);
        mInfoViewMvc.setTitle(getArguments().getString(ARG_TITLE));
        mInfoViewMvc.setMessage(getArguments().getString(ARG_MESSAGE));
        mInfoViewMvc.setDismissCaption(getArguments().getString(ARG_BUTTON_CAPTION));
        mInfoViewMvc.registerListener(this);
    }

    @Override
    public void onDismissClicked() {
        dismiss();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        mEventBus.post(new InfoDialogDismissedEvent(getDialogId()));
    }

}
