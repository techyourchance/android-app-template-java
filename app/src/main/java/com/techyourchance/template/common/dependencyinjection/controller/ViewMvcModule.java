package com.techyourchance.template.common.dependencyinjection.controller;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;

import com.techyourchance.template.dialogs.DialogsFactory;
import com.techyourchance.template.dialogs.DialogsManager;
import com.techyourchance.template.screens.common.mvcviews.ViewMvcFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewMvcModule {

    @Provides
    LayoutInflater layoutInflater(Context context) {
        return LayoutInflater.from(context);
    }

    @Provides
    ViewMvcFactory viewMvcFactory(LayoutInflater layoutInflater) {
        return new ViewMvcFactory(layoutInflater);
    }

}
