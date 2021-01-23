package com.techyourchance.template.common.dependencyinjection.activity;

import com.techyourchance.template.common.dependencyinjection.controller.ControllerComponent;
import com.techyourchance.template.common.dependencyinjection.controller.ControllerModule;
import com.techyourchance.template.common.dependencyinjection.controller.ViewMvcModule;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = {ActivityModule.class})
public interface ActivityComponent {

    ControllerComponent newControllerComponent(
            ControllerModule controllerModule,
            ViewMvcModule viewMvcModule
    );

}
