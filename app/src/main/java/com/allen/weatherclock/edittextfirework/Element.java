package com.allen.weatherclock.edittextfirework;

/**
 * Created by Allen on 2016/9/8.
 */
public class Element {
    public int color;
    public double direction;
    public float speed;
    public float x = 0;
    public float y = 0;

    public Element(int color, double direction, float speed){
        this.color = color;
        this.direction = direction;
        this.speed = speed;
    }
}
