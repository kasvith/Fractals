package com.kasun.ui;

import java.awt.*;

/**
 * Created by kasun on 7/21/17.
 */
public class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public void render(Graphics g, Color color){
        Point.renderPoint(g, this, color);
    }

    public static void renderPoint(Graphics g, Point point, Color color){
        g.setColor(color);
        g.drawLine(point.getX(), point.getY(), point.getX(), point.getY());
    }
}
