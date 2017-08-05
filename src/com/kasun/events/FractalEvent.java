package com.kasun.events;

import com.kasun.fractal.AbstractFractal;

/**
 * Created by kasun on 8/1/17.
 */
public class FractalEvent {
    public AbstractFractal fractal;
    public String fractalType;

    public FractalEvent(AbstractFractal fractal, String fractalType) {
        this.fractal = fractal;
        this.fractalType = fractalType;
    }
}
