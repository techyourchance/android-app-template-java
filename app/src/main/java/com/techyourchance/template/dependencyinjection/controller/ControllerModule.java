package com.techyourchance.template.dependencyinjection.controller;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.techyourchance.template.screens.common.dialogs.DialogsFactory;
import com.techyourchance.template.screens.common.dialogs.DialogsManager;

import dagger.Module;
import dagger.Provides;

@Module
public class ControllerModule {

    private final FragmentActivity mActivity;

    public ControllerModule(FragmentActivity activity) {
        mActivity = activity;
    }

    @Provides
    Context context() {
        return mActivity;
    }

    @Provides
    Activity activity() {
        return mActivity;
    }

    @Provides
    FragmentManager fragmentManager() {
        return mActivity.getSupportFragmentManager();
    }

    @Provides
    DialogsManager dialogsManager(FragmentManager fragmentManager) {
        return new DialogsManager(fragmentManager);
    }

    @Provides
    DialogsFactory dialogsFactory() {
        return new DialogsFactory();
    }


}
