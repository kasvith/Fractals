package com.kasun.fractal;

/**
 * Created by kasun on 7/23/17.
 */
public class FractalPointData {
    int iterations = 0;
    double convergedAbsolute = 0.0d;

    public FractalPointData(int iterations, double convergedAbsolute) {
        this.iterations = iterations;
        this.convergedAbsolute = convergedAbsolute;
    }

    public int getIterations() {
        return iterations;
    }

    public double getConvergedAbsolute() {
        return convergedAbsolute;
    }
}
