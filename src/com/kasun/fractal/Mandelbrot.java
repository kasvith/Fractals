package com.kasun.fractal;

import com.kasun.math.Complex;
import com.kasun.ui.Point;
import com.kasun.ui.Size;

/**
 * Created by kasun on 7/14/17.
 */
public class Mandelbrot extends AbstractFractal {
    final Complex ZERO = new Complex(0,0);

    public Mandelbrot(double realMin, double realMax, double complexMin, double complexMax, int iterations) {
        super(realMin, realMax, complexMin, complexMax,new Size(800,800), iterations);
    }

    private FractalPointData calculateMandelbrot(Complex c) {
        return super.calculateFractal(ZERO, c);
    }

    @Override
    public FractalPointData getFractal(int x, int y) {
        return calculateMandelbrot(getFractalCoordinates(x, y));
    }

    public FractalPointData getFractal(Point point){
        return getFractal(point.getX(), point.getY());
    }
}
