package com.techyourchance.template.screens.common.mvcviews;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.techyourchance.template.screens.example.mvcviews.ExampleViewMvc;
import com.techyourchance.template.screens.example.mvcviews.ExampleViewMvcImpl;

/**
 * This class implements Service Locator pattern in order to provide implementations of
 * MVC view interfaces.<br>
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

    /**
     * Instantiate a new implementation of MVC view interface. The returned instance will be
     * casted to MVC view type inferred by java's automatic type inference.
     * @param mvcViewClass the interface of the required MVC view
     * @param container this container will be used as MVC view's parent. See {@link LayoutInflater#inflate(int, ViewGroup)}
     * @param <T> the type of the required MVC view
     * @return new instance of MVC view that implements the required interface
     * @throws IllegalArgumentException if MVC view of particular type is not supported
     */
    @SuppressWarnings("unchecked")
    public <T extends ViewMvc> T newMvcView(Class<T> mvcViewClass, @Nullable ViewGroup container) {
        if (mvcViewClass == ExampleViewMvc.class) {
            return (T) new ExampleViewMvcImpl(mLayoutInflater, container);
        } else {
            throw new IllegalArgumentException("MVC view class " + mvcViewClass + " not supported");
        }
    }
}
