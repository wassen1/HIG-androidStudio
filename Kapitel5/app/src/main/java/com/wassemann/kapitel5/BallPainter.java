package com.wassemann.kapitel5;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import java.util.Random;

/**
 * Sets the appearance of the ball
 *
 * @author Fredrik Wassermeyer, 17frwa01
 */

public class BallPainter {
    private Paint paint;
    private Ball ball;
    private static final Random random = new Random();


    /**
     * @param ball
     * @param paint
     */
    public BallPainter(Ball ball, Paint paint) {
        this.paint = paint;
        this.ball = ball;
    }

    /**
     * @param ball
     */
    public BallPainter(Ball ball) {
        this(ball, createRandomPaint());
    }

    /**
     * Paints the ball with a path
     *
     * @param canvas
     */
    public void paintBall(Canvas canvas) {

        Path circle;
        Paint tpaint;

        tpaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        tpaint.setStyle(Paint.Style.FILL_AND_STROKE);
        tpaint.setColor(Color.BLACK);
        tpaint.setTextSize(ball.getRadius() / 2);

        circle = new Path();
        circle.addCircle(ball.getX(), ball.getY(), ball.getRadius(), Path.Direction.CW);
        String QUOTE = "Fredrik Wassermeyer   * * *";
        canvas.drawPath(circle, paint);
        canvas.drawTextOnPath(QUOTE, circle, 0, tpaint.getTextSize(), tpaint);

    }

    /**
     * Sets a random color of the ball
     *
     * @return the color
     */
    private static Paint createRandomPaint() {

        byte[] params = new byte[4];
        random.nextBytes(params);
        Paint paint = new Paint();
        paint.setColor(Color.argb(params[0], params[1], params[2], params[3]));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        return paint;
    }
};
