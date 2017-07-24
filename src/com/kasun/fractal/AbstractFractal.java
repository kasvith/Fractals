package com.kasun.fractal;

import com.kasun.math.Complex;
import com.kasun.ui.Point;
import com.sun.glass.ui.Size;

/**
 * Created by kasun on 7/14/17.
 */
public abstract class AbstractFractal {
    private float realMin = -1.0f;
    private float realMax = 1.0f;
    private float imgMin = -1.0f;
    private float imgMax = 1.0f;
    private float planeWidth = 0f;
    private float planeHeight = 0f;
    private int iterations = 1000;
    private Size canvasSize = new Size(800,800);

    public AbstractFractal(float realMin, float realMax, float imgMin, float imgMax, Size canvasSize , int iterations) {
        setBounds(realMin, realMax, imgMin, imgMax);
        setIterations(iterations);
        setCanvasSize(canvasSize);
    }

    public void setBounds(float realMin, float realMax, float imgMin, float imgMax){
        float w = realMax - realMin;
        float h = imgMax - imgMin;

        if (w > h){
            realMax = realMin + h;
        }else if(h > w){
            imgMin = imgMax - w;
        }

        this.imgMin = imgMin;
        this.imgMax = imgMax;
        this.realMin = realMin;
        this.realMax = realMax;

        calculatePlaneSize();
    }

    private void calculatePlaneSize(){
        planeHeight = getImgMax() - getImgMin();
        planeWidth = getRealMax() - getRealMin();
    }

    public Size getCanvasSize() {
        return canvasSize;
    }

    public void setCanvasSize(Size canvasSize) {
        this.canvasSize = canvasSize;
    }

    protected FractalPointData calculateFractal(Complex z, Complex c){
        for (int i = 0; i <= this.getIterations(); i++) {
            if (Complex.getAbsolute(z.square()) > 4) {
                return new FractalPointData(i, z.getAbsolute());
            }
            z = z.square().add(c);
        }
        return new FractalPointData(getIterations(), z.getAbsolute());
    }

    public float getRealMin() {
        return realMin;
    }

    public float getRealMax() {
        return realMax;
    }

    public float getImgMin() {
        return imgMin;
    }

    public float getImgMax() {
        return imgMax;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public Complex getFractalCoordinates(int x, int y){
        float xx = this.realMin + (float)x*planeWidth/canvasSize.width;
        float yy = this.imgMax - (float)y*planeHeight/canvasSize.height;

        return new Complex(xx, yy);
    }

    public Complex getFractalCoordinates(Point point){
        return getFractalCoordinates(point.getX(), point.getY());
    }

    public abstract FractalPointData getFractal(int x, int y);

    public static float NormalizeIteration(int iteration, final int MAX_ITERATION){
        return ((float)iteration/(float)MAX_ITERATION);
    }
}
