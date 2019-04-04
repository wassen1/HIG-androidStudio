package com.wassemann.kapitel5;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

/**
 * Set the behavior of the View
 *
 * @author Fredrik Wassermeyer, 17frwa01
 */

public class AnimationView extends View {
    private ArrayList<BallMover> ballMoverList = new ArrayList<BallMover>();
    private ArrayList<BallPainter> ballPainterList = new ArrayList<BallPainter>();
    private static final Random random = new Random();

    /**
     * @param context
     */
    public AnimationView(Context context) {
        super(context);
        init();
    }

    /**
     * Adds OnTouchListener
     */
    private void init() {
        this.setOnTouchListener(new OnTouchListener() {

            /**
             * Reacts on touches of the screen
             *
             * @param v
             * @param event
             * @return true
             */
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                createAndInsertBall(event.getX(), event.getY());
                return true;
            }

        });
    }

    /**
     * Sets direction, speed and size of the ball
     *
     * @param x
     * @param y
     */
    private void createAndInsertBall(float x, float y) {
        float dir = (float) (random.nextFloat() * 2.0 * Math.PI);
        float speed = (float) (1.0 + random.nextFloat() * 20.0);
        float size = (float) (5.0 + random.nextFloat() * 20.0);
        Ball ball = new Ball(x, y, 100 * random.nextFloat() + 50);
        BallPainter painter = new BallPainter(ball);
        ballPainterList.add(painter);
        BallMover ballMover = new BallMover(ball, dir, speed);
        ballMoverList.add(ballMover);
    }

    /**
     * Draws the balls on the Canvas
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (BallPainter ballPainter : ballPainterList)
            ballPainter.paintBall(canvas);
        for (BallMover ballMover : ballMoverList)
            ballMover.moveBallWithin(0, 0, getWidth(), getHeight());

    }
}
