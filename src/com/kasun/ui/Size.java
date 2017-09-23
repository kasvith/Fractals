package com.kasun.ui;

/**
 * Created by kasun on 9/23/17.
 */
public final class Size {
    public int width;
    public int height;

    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Size() {
        this(0, 0);
    }

    @Override
    public String toString() {
        return "Size(" + width + ", " + height + ")";
    }
}
