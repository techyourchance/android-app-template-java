package com.techyourchance.template.dependencyinjection.application;

import com.techyourchance.template.dependencyinjection.controller.ControllerComponent;
import com.techyourchance.template.dependencyinjection.controller.ControllerModule;
import com.techyourchance.template.dependencyinjection.controller.ViewMvcModule;
import com.techyourchance.template.dependencyinjection.service.ServiceComponent;
import com.techyourchance.template.dependencyinjection.service.ServiceModule;

import dagger.Component;

@ApplicationScope
@Component(
        modules = {
                ApplicationModule.class,
                SettingsModule.class
        }
)
public interface ApplicationComponent {

    ControllerComponent newControllerComponent(
            ControllerModule controllerModule,
            ViewMvcModule viewMvcModule);

    ServiceComponent newServiceComponent(ServiceModule serviceModule);

}