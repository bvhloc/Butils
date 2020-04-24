package com.bvhloc.general.utils.handle;

import android.os.Handler;

public class Bandler extends Handler {

    public boolean isRunning;
    private Runnable runningCallback = new Runnable() {
        @Override
        public void run() {

            isRunning = false;
        }
    };

    private Runnable callback;
    private long delay;

    public void startCountdown(Runnable callback, long delay) {
        cancel();
        this.callback = callback;
        this.delay = delay;
        isRunning = true;
        postDelayed(callback, delay);
        postDelayed(runningCallback, delay);
    }

    public void restart() {
        restart(delay);
    }

    public void restart(long newDelay) {
        cancel();
        startCountdown(callback, newDelay);
    }

    public void cancel() {
        isRunning = false;
        removeCallbacks(callback);
        removeCallbacks(runningCallback);
    }
}
