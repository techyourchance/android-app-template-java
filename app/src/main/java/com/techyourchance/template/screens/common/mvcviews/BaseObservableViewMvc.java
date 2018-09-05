package com.techyourchance.template.screens.common.mvcviews;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class BaseObservableViewMvc<LISTENER_CLASS> extends BaseViewMvc
        implements ObservableViewMvc<LISTENER_CLASS> {

    private Set<LISTENER_CLASS> mListeners = new HashSet<>();

    @Override
    public final void registerListener(LISTENER_CLASS listener) {
        mListeners.add(listener);
    }

    @Override
    public final void unregisterListener(LISTENER_CLASS listener) {
        mListeners.remove(listener);
    }

    protected final Set<LISTENER_CLASS> getListeners() {
        return Collections.unmodifiableSet(mListeners);
    }
}
