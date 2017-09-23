package com.kasun.fractal;

import com.kasun.math.Complex;
import com.kasun.ui.Point;
import com.kasun.ui.Size;

/**
 * Created by kasun on 7/16/17.
 */
public class Julia extends AbstractFractal {
    private Complex c;

    public Julia(Complex c, int iterations) {
        super(-1f, 1f, -1f, 1f, new Size(800,800), iterations);
        setC(c);
    }

    public Complex getC() {
        return c;
    }

    public void setC(Complex c) {
        this.c = c;
    }

    private FractalPointData calculateJulia(Complex z){
        return super.calculateFractal(z, getC());
    }

    @Override
    public FractalPointData getFractal(int x, int y) {
        return calculateJulia(getFractalCoordinates(x,y));
    }

    public FractalPointData getFractal(Point point){
        return getFractal(point.getX(), point.getY());
    }
}
