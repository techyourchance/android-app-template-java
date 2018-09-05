package com.techyourchance.template.common;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BaseObservable<LISTENER_CLASS> {

    // thread-safe set of listeners
    private Set<LISTENER_CLASS> mListeners = Collections.newSetFromMap(
            new ConcurrentHashMap<LISTENER_CLASS, Boolean>(1));


    public void registerListener(LISTENER_CLASS listener) {
        mListeners.add(listener);
    }

    public void unregisterListener(LISTENER_CLASS listener) {
        mListeners.remove(listener);
    }

    protected Set<LISTENER_CLASS> getListeners() {
        return mListeners;
    }

}
