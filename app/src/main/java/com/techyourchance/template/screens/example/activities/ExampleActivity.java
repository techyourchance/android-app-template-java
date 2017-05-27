package com.techyourchance.template.screens.example.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;

import com.techyourchance.template.R;
import com.techyourchance.template.dialogs.DialogsFactory;
import com.techyourchance.template.dialogs.DialogsManager;
import com.techyourchance.template.screens.common.activities.BaseActivity;
import com.techyourchance.template.screens.example.mvcviews.ExampleViewMvc;
import com.techyourchance.template.screens.example.mvcviews.ExampleViewMvcImpl;

public class ExampleActivity extends BaseActivity implements ExampleViewMvc.ExampleViewMvcListener {

    private DialogsManager mDialogsManager;
    private DialogsFactory mDialogsFactory;

    private ExampleViewMvc mViewMvc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDialogsFactory = new DialogsFactory();
        mDialogsManager = new DialogsManager(getSupportFragmentManager());

        mViewMvc = new ExampleViewMvcImpl(LayoutInflater.from(this), null);
        mViewMvc.registerListener(this);

        setContentView(mViewMvc.getRootView());
    }

    @Override
    public void onShowDialogClicked() {
        DialogFragment dialog = mDialogsFactory.newInfoDialog(
                getString(R.string.dialog_title),
                getString(R.string.dialog_message),
                getString(R.string.dialog_button_caption));
        mDialogsManager.showRetainedDialogWithId(dialog, null);
    }
}
