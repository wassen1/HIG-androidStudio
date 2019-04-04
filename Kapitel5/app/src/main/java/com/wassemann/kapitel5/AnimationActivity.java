package com.wassemann.kapitel5;

import android.app.Activity;
import android.os.Bundle;

/**
 * Creates an animation activity
 *
 * @author Fredrik Wassermeyer, 17frwa01
 */
public class AnimationActivity extends Activity {
    private AnimationView animationView;
    private boolean running = false;
    private Ticker ticker = new Ticker();


    /**
     * Sets the the view
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animationView = new AnimationView(this);
        setContentView(animationView);
        ticker.startTicking();
    }

    /**
     * Turns off the Activity
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        ticker.stopTicking();
    }

    /**
     * Starts new thread
     */
    private class Ticker implements Runnable {

        /**
         * Starts the ticking
         */
        public void startTicking() {
            running = true;
            new Thread(this).start();
        }

        /**
         * Stops the ticking
         */
        public void stopTicking() {
            running = false;
        }

        /**
         * Sets the sleep of the thread
         */
        public void run() {
            while (running) {
                try {
                    Thread.sleep(20);
                    animationView.postInvalidate();
                } catch (Exception e) {

                }
            }
        }
    }
};
