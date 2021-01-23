package com.techyourchance.template.screens.home;

import android.app.Application;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techyourchance.template.common.permissions.MyPermission;
import com.techyourchance.template.common.permissions.PermissionsHelper;
import com.techyourchance.template.common.random.RandomStringGenerator;
import com.techyourchance.template.common.settings.SettingsManager;
import com.techyourchance.template.screens.common.ViewMvcFactory;
import com.techyourchance.template.screens.common.controllers.BaseFragment;
import com.techyourchance.template.screens.common.dialogs.DialogsManager;
import com.techyourchance.threadposter.BackgroundThreadPoster;
import com.techyourchance.threadposter.UiThreadPoster;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HomeFragment extends BaseFragment implements
        HomeViewMvc.Listener,
        PermissionsHelper.Listener {

    private static final MyPermission[] PERMISSIONS
            = new MyPermission[] {MyPermission.CAMERA, MyPermission.READ_PHONE_STATE};

    @Inject DialogsManager mDialogsManager;
    @Inject ViewMvcFactory mViewMvcFactory;
    @Inject PermissionsHelper mPermissionsHelper;
    @Inject SettingsManager mSettingsManager;
    @Inject UiThreadPoster mUiThreadPoster;
    @Inject BackgroundThreadPoster mBackgroundThreadPoster;
    @Inject RandomStringGenerator mRandomStringGenerator;
    @Inject Application mApplication;

    private HomeViewMvc mViewMvc;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getControllerComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewMvc = mViewMvcFactory.newHomeViewMvc(container);
        return mViewMvc.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewMvc.registerListener(this);
        mPermissionsHelper.registerListener(this);

        refreshPermissionsUi();
    }

    @Override
    public void onStop() {
        super.onStop();
        mViewMvc.unregisterListener(this);
        mPermissionsHelper.unregisterListener(this);
    }

    @Override
    public void onRequestPermissionsClicked() {
        mPermissionsHelper.requestAllPermissions(PERMISSIONS, 0);
    }


    private void refreshPermissionsUi() {
        if (mPermissionsHelper.hasAllPermissions(PERMISSIONS)) {
            mViewMvc.disableRequestPermissionsButton();
        } else {
            mViewMvc.enableRequestPermissionsButton();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, PermissionsHelper.PermissionsResult result) {
        if (!result.deniedDoNotAskAgain.isEmpty()) {
            mDialogsManager.showInfoDialog(
                    "Missing permissions",
                    "Permissions denied and we can't ask for them again: "
                            + result.deniedDoNotAskAgain.toString()
                            + "\nPart of app's functionality might not work!",
                    "OK",
                    null
            );
        } else if (!result.denied.isEmpty()) {
            mDialogsManager.showInfoDialog(
                    "Missing permissions",
                    "Permissions denied: "
                            + result.denied.toString()
                            + "\n\nWe need these permissions to work!",
                    "OK",
                    null
            );
        } else {
            mDialogsManager.showInfoDialog(
                    "",
                    "Permissions granted",
                    "OK",
                    null
            );
        }
        refreshPermissionsUi();
    }

    @Override
    public void onPermissionsRequestCancelled(int requestCode) {
        mDialogsManager.showInfoDialog(
                "",
                "Permissions request cancelled",
                "OK",
                null
        );
        refreshPermissionsUi();
    }

}
