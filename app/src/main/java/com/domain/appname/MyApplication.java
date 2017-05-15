package com.domain.appname;

import android.app.Application;

/**
 * Our custom {@link Application}
 */
public class MyApplication extends Application {

    private final MainThreadPoster mMainThreadPoster = new MainThreadPoster();
    private final BackgroundThreadPoster mBackgroundThreadPoster = new BackgroundThreadPoster();

    public MainThreadPoster getMainThreadPoster() {
        return mMainThreadPoster;
    }

    public BackgroundThreadPoster getBackgroundThreadPoster() {
        return mBackgroundThreadPoster;
    }
}
