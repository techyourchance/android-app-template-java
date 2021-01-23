package com.techyourchance.template.screens.main;

import android.os.Bundle;

import com.techyourchance.template.R;
import com.techyourchance.template.common.permissions.PermissionsHelper;
import com.techyourchance.template.screens.common.ScreensNavigator;
import com.techyourchance.template.screens.common.controllers.BackPressDispatcher;
import com.techyourchance.template.screens.common.controllers.BackPressListener;
import com.techyourchance.template.screens.common.controllers.BaseActivity;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MainActivity extends BaseActivity implements BackPressDispatcher {

    @Inject ScreensNavigator mScreensNavigator;
    @Inject PermissionsHelper mPermissionsHelper;

    private final Set<BackPressListener> mBackPressListeners = new HashSet<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getControllerComponent().inject(this);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_main);

        mScreensNavigator.init(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mScreensNavigator.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        boolean backPressListenerConsumedTheEvent = false;
        for (BackPressListener backPressListener : mBackPressListeners) {
            if (backPressListener.onBackPressed()) {
                backPressListenerConsumedTheEvent = true;
            }
        }
        if (backPressListenerConsumedTheEvent || mScreensNavigator.navigateBack()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // must delegate to PermissionsHelper because this object functions as a central "hub"
        // for permissions management in the scope of this Activity
        mPermissionsHelper.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void registerListener(BackPressListener listener) {
        mBackPressListeners.add(listener);
    }

    @Override
    public void unregisterListener(BackPressListener listener) {
        mBackPressListeners.remove(listener);
    }

}
