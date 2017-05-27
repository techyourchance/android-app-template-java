package com.domain.appname.screens.example.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;

import com.domain.appname.screens.common.activities.BaseActivity;
import com.domain.appname.screens.example.mvcviews.ExampleViewMvc;
import com.domain.appname.screens.example.mvcviews.ExampleViewMvcImpl;

/**
 * Example application Activity
 */
public class ExampleActivity extends BaseActivity implements ExampleViewMvc.ExampleViewMvcListener {

    private ExampleViewMvc mViewMvc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewMvc = new ExampleViewMvcImpl(LayoutInflater.from(this), null);
        mViewMvc.registerListener(this);

        setContentView(mViewMvc.getRootView());
    }

    @Override
    public void onShowDialogClicked() {
        // TODO
    }
}
