package com.techyourchance.template.common.dependencyinjection.application;

import com.techyourchance.template.common.dependencyinjection.controller.ControllerComponent;
import com.techyourchance.template.common.dependencyinjection.controller.ControllerModule;
import com.techyourchance.template.common.dependencyinjection.service.ServiceComponent;
import com.techyourchance.template.common.dependencyinjection.service.ServiceModule;

import dagger.Component;

@ApplicationScope
@Component(
        modules = {
                ApplicationModule.class
        }
)
public interface ApplicationComponent {

    ControllerComponent newControllerComponent(ControllerModule controllerModule);

    ServiceComponent newServiceComponent(ServiceModule serviceModule);

}