package com.techyourchance.template.common.dependencyinjection.controller;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.techyourchance.template.screens.common.dialogs.DialogsFactory;
import com.techyourchance.template.screens.common.dialogs.DialogsManager;

import dagger.Module;
import dagger.Provides;

@Module
public class ControllerModule {

    private final Activity mActivity;
    private final FragmentManager mFragmentManager;

    public ControllerModule(Activity activity, FragmentManager fragmentManager) {
        mActivity = activity;
        mFragmentManager = fragmentManager;
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
        return mFragmentManager;
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
