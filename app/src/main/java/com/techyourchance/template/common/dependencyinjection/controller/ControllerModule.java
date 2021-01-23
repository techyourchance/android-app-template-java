package com.techyourchance.template.common.dependencyinjection.controller;

import com.techyourchance.dialoghelper.DialogHelper;
import com.techyourchance.template.screens.common.dialogs.DialogsManager;

import androidx.fragment.app.FragmentManager;
import dagger.Module;
import dagger.Provides;

@Module
public class ControllerModule {

    @Provides
    DialogsManager dialogsManager(FragmentManager fragmentManager) {
        return new DialogsManager(new DialogHelper(fragmentManager));
    }

}
