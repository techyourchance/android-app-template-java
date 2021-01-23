package com.techyourchance.template.common.dependencyinjection.controller;

import com.techyourchance.template.screens.common.dialogs.DialogsManager;
import com.techyourchance.template.screens.common.dialogs.info.InfoDialog;
import com.techyourchance.template.screens.common.dialogs.prompt.PromptDialog;
import com.techyourchance.template.screens.home.HomeFragment;
import com.techyourchance.template.screens.main.MainActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {ControllerModule.class, ViewMvcModule.class})
public interface ControllerComponent {

    void inject(MainActivity mainActivity);

    void inject(HomeFragment homeFragment);

    void inject(InfoDialog infoDialog);
    void inject(PromptDialog promptDialog);

    // this method is added only to be able to retrieve dialog ID in BaseDialog class
    DialogsManager getDialogManager();

}
