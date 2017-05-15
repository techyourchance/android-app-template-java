package com.domain.appname.screens.common.mvcviews;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.view.View;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the base class which provides basic common functionality to MVC views implementations
 */
@SuppressWarnings("unused,WeakerAccess")
public abstract class BaseViewMvc<ListenerType> implements ObservableViewMvc<ListenerType> {

    private View mRootView;
    private Set<ListenerType> mListeners = new HashSet<>(1);

    // ---------------------------------------------------------------------------------------------
    // region listeners

    @Override
    public void registerListener(ListenerType listener) {
        mListeners.add(listener);
    }

    @Override
    public void unregisterListener(ListenerType listener) {
        mListeners.remove(listener);
    }

    /**
     * Get a reference to the (thread safe) set containing all the registered listeners. Note that
     * the returned reference is a reference to the set itself, not to its copy.
     */
    protected Set<ListenerType> getListeners() {
        return mListeners;
    }

    // endregion listeners
    // ---------------------------------------------------------------------------------------------

    // ---------------------------------------------------------------------------------------------
    // region root View

    /**
     * Set the root android view of this MVC view
     */
    protected void setRootView(View rootView) {
        mRootView = rootView;
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    // endregion root View
    // ---------------------------------------------------------------------------------------------


    /**
     * Convenience method for obtaining references to {@link View}s contained in the hierarchy of
     * the root {@link View}.<br>
     * This method uses Java's type inference in order to automatically cast the returned
     * {@link View}s to the type of the containing variable.
     * @return {@link View} object casted to the type inferred by Java's automatic type inference
     *         mechanism, or null
     */
    @SuppressWarnings("unchecked")
    protected <T extends View> T findViewById(@IdRes int id) {
        return (T) mRootView.findViewById(id);
    }

    /**
     * Convenience method for obtaining reference to {@link Context} in MVC views
     * @return instance of {@link Context} associated with the root {@link View} of this MVC view
     */
    protected Context getContext() {
        return getRootView().getContext();
    }

    /**
     * Convenience method for obtaining a string resource
     */
    protected String getString(@StringRes int id) {
        return getContext().getString(id);
    }


}
