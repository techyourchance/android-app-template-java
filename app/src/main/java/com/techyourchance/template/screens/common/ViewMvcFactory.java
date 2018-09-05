package com.techyourchance.template.screens.common;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.techyourchance.template.screens.example.mvcviews.ExampleViewMvc;
import com.techyourchance.template.screens.example.mvcviews.ExampleViewMvcImpl;

/**
 * This class is required because we can't inject MVC view implementations directly. The reason is
 * that the constructor of MVC views must accept "container" ViewGroup. In case of e.g. Fragments,
 * this "container" is not yet known when the dependencies are being injected. By using this class,
 * we can instantiate MVC views after injection while providing "container" as parameter.
 */
public class ViewMvcFactory {

    private final LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
    }

    public ExampleViewMvc newExampleViewMvc(@Nullable ViewGroup container) {
        return new ExampleViewMvcImpl(mLayoutInflater, container);
    }

}
