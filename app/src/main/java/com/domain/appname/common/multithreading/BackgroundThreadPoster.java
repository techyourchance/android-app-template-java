package com.domain.appname.common.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This object should be used whenever we need to post anything to a (random) background thread.
 */
public class BackgroundThreadPoster {

    private ExecutorService mExecutorService = Executors.newCachedThreadPool();

    public void post(Runnable runnable) {
        mExecutorService.execute(runnable);
    }

}
