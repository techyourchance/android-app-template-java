package com.domain.appname.testdoubles.multithreading;

import android.os.Handler;


import com.domain.appname.common.multithreading.MainThreadPoster;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This is a test double of {@link MainThreadPoster} for unit tests. Instead of using the Main (UI)
 * Android's thread, this implementation sends each {@link Runnable} to a new background thread.
 * Only one background thread is allowed to run at a time, thus simulating a serial execution
 * of {@link Runnable}s.
 */

/* pp */ class MainThreadPosterTestDouble extends MainThreadPoster {

    private final Object MONITOR = new Object();

    private final Queue<Thread> mThreads = new LinkedBlockingQueue<>();

    @Override
    protected Handler getMainHandler() {
        /*
         We need to override this method in order to prevent "stub" RuntimeException during unit
         testing. Since this class does not use Handler at all, we can simply return null
          */
        return null;
    }

    @Override
    public void post(final Runnable runnable) {
        synchronized (MONITOR) {
            Thread worker = new Thread(new Runnable() {
                @Override
                public void run() {
                    // make sure all previous threads finished
                    MainThreadPosterTestDouble.this.join();
                    runnable.run();
                }
            });
            worker.start();
            mThreads.add(worker);
        }
    }

    /**
     * Call to this method will block until all {@link Runnable}s posted to this "test double"
     * BEFORE THE MOMENT OF A CALL will be completed.<br>
     * Call to this method allows to establish a happens-before relationship between the previously
     * posted {@link Runnable}s and subsequent code.
     */
    /* pp */ void join() {
        Queue<Thread> threadsCopy;
        synchronized (MONITOR) {
            threadsCopy = new LinkedBlockingQueue<>(mThreads);
        }

        Thread thread;
        while ((thread = threadsCopy.poll()) != null) {
            try {
                // there is race condition - "self" thread and further threads could be added; we need
                // to wait only until threads before "self" finish
                if (thread.getId() == Thread.currentThread().getId()) {
                    break;
                } else {
                    thread.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
