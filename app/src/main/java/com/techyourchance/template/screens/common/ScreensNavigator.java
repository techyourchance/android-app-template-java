package com.techyourchance.template.screens.common;

import android.app.Activity;
import android.os.Bundle;

import com.ncapdevi.fragnav.FragNavController;
import com.ncapdevi.fragnav.FragNavTransactionOptions;
import com.techyourchance.template.screens.home.HomeFragment;

import java.util.Collections;

import timber.log.Timber;

public class ScreensNavigator {

        private final FragNavController mFragNavController;
        private final Activity mActivity;

        public ScreensNavigator(Activity activity, FragNavController fragNavController) {
            mFragNavController = fragNavController;
            mActivity = activity;
        }

    public void init(Bundle savedInstanceState) {
        mFragNavController.setRootFragments(Collections.singletonList(HomeFragment.newInstance()));
        mFragNavController.setCreateEager(true);
        mFragNavController.setFragNavLogger((s, throwable) -> Timber.e(throwable, "ScreensNavigator: %s", s));
        mFragNavController.setDefaultTransactionOptions(new FragNavTransactionOptions.Builder().build());
        mFragNavController.initialize(FragNavController.TAB1, savedInstanceState);
    }

    public void onSaveInstanceState(Bundle saveInstanceState) {
        mFragNavController.onSaveInstanceState(saveInstanceState);
    }

    public boolean navigateBack() {
        if(mFragNavController.isRootFragment()) {
            return false;
        } else {
            mFragNavController.popFragment();
            return true;
        }
    }

    public void toHome() {
        mFragNavController.pushFragment(HomeFragment.newInstance());
    }
}
