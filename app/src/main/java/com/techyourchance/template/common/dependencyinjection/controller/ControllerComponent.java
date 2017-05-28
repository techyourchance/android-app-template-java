package com.techyourchance.template.common.dependencyinjection.controller;

import com.techyourchance.template.screens.example.activities.ExampleActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {ControllerModule.class})
public interface ControllerComponent {

    void inject(ExampleActivity exampleActivity);

}
