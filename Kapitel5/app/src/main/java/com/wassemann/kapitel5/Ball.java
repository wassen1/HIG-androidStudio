package com.wassemann.kapitel5;

/**
 * @author Fredrik Wassermeyer, 17frwa01
 */

public class Ball {
    private float x;
    private float y;
    private float radius;

    /**
     * Defines the ball
     *
     * @param x      the x position of the ball
     * @param y      the y position of the ball
     * @param radius the radius of the ball
     */
    public Ball(float x, float y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    /**
     * Gets the x position
     *
     * @return x
     */
    public float getX() {
        return x;
    }

    /**
     * Sets the x postion
     *
     * @param x
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Gets the y position
     *
     * @return y
     */
    public float getY() {
        return y;
    }

    /**
     * Sets the y position
     *
     * @param y
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Gets the radius
     *
     * @return radius
     */
    public float getRadius() {
        return radius;
    }

    /**
     * Sets the radius
     */
    public void setRadius() {
        this.radius = radius;
    }
};
