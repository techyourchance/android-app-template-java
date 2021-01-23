package com.techyourchance.template.common.dependencyinjection.application;

import com.techyourchance.template.common.dependencyinjection.activity.ActivityComponent;
import com.techyourchance.template.common.dependencyinjection.activity.ActivityModule;
import com.techyourchance.template.common.dependencyinjection.service.ServiceComponent;
import com.techyourchance.template.common.dependencyinjection.service.ServiceModule;

import dagger.Component;

@ApplicationScope
@Component(
        modules = {
                ApplicationModule.class,
                SettingsModule.class
        }
)
public interface ApplicationComponent {
    ActivityComponent newActivityComponent(ActivityModule activityModule);

    ServiceComponent newServiceComponent(ServiceModule serviceModule);
}