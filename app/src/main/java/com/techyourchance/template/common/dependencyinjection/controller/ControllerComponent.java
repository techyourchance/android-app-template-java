package com.techyourchance.template.common.dependencyinjection.controller;

import com.techyourchance.template.common.dialogs.info.InfoDialog;
import com.techyourchance.template.common.dialogs.prompt.PromptDialog;
import com.techyourchance.template.screens.example.activities.ExampleActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {ControllerModule.class, ViewMvcModule.class})
public interface ControllerComponent {

    void inject(ExampleActivity exampleActivity);

    void inject(InfoDialog infoDialog);
    void inject(PromptDialog promptDialog);

}
