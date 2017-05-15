package com.domain.appname.testdoubles.multithreading;


import com.domain.appname.common.multithreading.BackgroundThreadPoster;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * This is a test double of {@link BackgroundThreadPoster} for unit tests. This implementation
 * sends each Runnable to a new background thread, and then allows to block until all threads
 * are finished.
 */

/* package */ class BackgroundThreadPosterTestDouble extends BackgroundThreadPoster {

    private final Object MONITOR = new Object();

    private final Queue<Thread> mThreads = new LinkedBlockingQueue<>();


    @Override
    public void post(Runnable runnable) {
        synchronized (MONITOR) {
            Thread worker = new Thread(runnable);
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
    public void join() {
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
