package com.techyourchance.template.common.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;

import com.techyourchance.template.MyApplication;
import com.techyourchance.template.common.dependencyinjection.service.ServiceComponent;
import com.techyourchance.template.common.dependencyinjection.service.ServiceModule;

public abstract class BaseService extends Service {

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
