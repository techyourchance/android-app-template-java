package com.techyourchance.template.common.logging;

import timber.log.Timber;

/**
 * This class is a non-static logger wrapper
 */
public class MyLogger {

    public void e(String tag, String message, Object... args) {
        Timber.tag(tag);
        Timber.e(message, args);
    }

    public void d(String tag, String message, Object... args) {
        Timber.tag(tag);
        Timber.d(message, args);
    }

    public void v(String tag, String message, Object... args) {
        Timber.tag(tag);
        Timber.v(message, args);
    }

}
