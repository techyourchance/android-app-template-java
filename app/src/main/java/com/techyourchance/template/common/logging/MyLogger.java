package com.techyourchance.template.common.logging;

import android.util.Log;

/**
 * This class is a non-static wrapper around {@link Log} class
 */
public class MyLogger {

    public void e(String tag, String message) {
        Log.e(tag, message);
    }

    public void w(String tag, String message) {
        Log.w(tag, message);
    }

    public void v(String tag, String message) {
        Log.v(tag, message);
    }

    public void d(String tag, String message) {
        Log.d(tag, message);
    }
}
