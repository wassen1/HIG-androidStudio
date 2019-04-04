package com.wassemann.kapitel5;

/**
 * Controls the movement of the ball
 *
 * @author Fredrik Wassermeyer, 17frwa01
 */

public class BallMover {
    private float dx;
    private float dy;
    private Ball ball;

    /**
     * @param ball
     * @param angleRadians
     * @param speedFactor
     */
    public BallMover(Ball ball, float angleRadians, float speedFactor) {
        this.ball = ball;
        dx = (float) (speedFactor * Math.cos(angleRadians));
        dy = (float) (speedFactor * Math.sin(angleRadians));
    }

    /**
     * Sets the area were the ball can move
     *
     * @param xMin the min position of x
     * @param yMin the min position of y
     * @param xMax the max position of x
     * @param yMax the max position of y
     */
    public void moveBallWithin(float xMin, float yMin, float xMax, float yMax) {
        checkForBounce(xMin, yMin, xMax, yMax);
        float x = ball.getX();
        float y = ball.getY();
        ball.setX(x + dx);
        ball.setY(y + dy);
    }

    /**
     * Controls the bounces into the walls
     *
     * @param xMin the min position of x
     * @param yMin the min position of y
     * @param xMax the max position of x
     * @param yMax the max position of y
     */
    private void checkForBounce(float xMin, float yMin, float xMax, float yMax) {
        float rightEdge = ball.getX() + ball.getRadius();
        float leftEdge = ball.getX() - ball.getRadius();
        float upperEdge = ball.getY() - ball.getRadius();
        float lowerEdge = ball.getY() + ball.getRadius();
        if ((rightEdge > xMax && dx > 0) || (leftEdge < xMin && dx < 0))
            dx = -dx;
        if ((lowerEdge > yMax && dy > 0) || (upperEdge < yMin && dy < 0))
            dy = -dy;
    }


}
