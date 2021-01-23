package com.techyourchance.template.common.dependencyinjection.activity;

import android.app.Activity;
import android.content.Context;

import com.ncapdevi.fragnav.FragNavController;
import com.techyourchance.template.R;
import com.techyourchance.template.common.permissions.PermissionsHelper;
import com.techyourchance.template.screens.common.ScreensNavigator;
import com.techyourchance.template.screens.common.controllers.BackPressDispatcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Provides
    Context context() {
        return mActivity;
    }

    @Provides
    AppCompatActivity appCompatActivity() {
        return mActivity;
    }

    @Provides
    Activity activity() {
        return mActivity;
    }

    @Provides
    BackPressDispatcher backPressDispatcher(Activity activity) {
        return (BackPressDispatcher) activity;
    }

    @Provides
    FragmentManager fragmentManager(AppCompatActivity activity) {
        return activity.getSupportFragmentManager();
    }

    @Provides
    @ActivityScope
    PermissionsHelper permissionsHelper(Activity activity) {
        return new PermissionsHelper(activity);
    }

    @Provides
    @ActivityScope
    ScreensNavigator screensNavigator(Activity activity, FragmentManager fragmentManager) {
        FragNavController fragNavController
                = new FragNavController(fragmentManager, R.id.fragment_container_view);
        return new ScreensNavigator(activity, fragNavController);
    }

}
