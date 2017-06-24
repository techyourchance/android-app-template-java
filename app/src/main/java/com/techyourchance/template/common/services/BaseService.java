package com.techyourchance.template.common.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;

import com.techyourchance.template.MyApplication;
import com.techyourchance.template.dependencyinjection.service.ServiceComponent;
import com.techyourchance.template.dependencyinjection.service.ServiceModule;

public class BaseService extends Service {

    private ServiceComponent mServiceComponent;
    
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * @return service injector of type {@link ServiceComponent}
     */
    @UiThread
    protected ServiceComponent getServiceComponent() {
        if (mServiceComponent == null) {
            mServiceComponent =
                    ((MyApplication)getApplication()).getApplicationComponent()
                            .newServiceComponent(new ServiceModule(this));
        }
        return mServiceComponent;
    }
}
