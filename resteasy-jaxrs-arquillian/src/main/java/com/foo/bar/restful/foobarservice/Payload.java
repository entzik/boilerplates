package com.foo.bar.restful.foobarservice;

/**
 * Created by emilkirschner on 16/10/15.
 */
public class Payload {
    String x;
    int y;

    public Payload() {
    }

    public Payload(String x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
