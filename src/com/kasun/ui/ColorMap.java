package com.kasun.ui;

import com.kasun.fractal.FractalPointData;
import com.kasun.math.Utils;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by kasun on 7/16/17.
 */
public class ColorMap {

    public static final double LOG2 = Math.log(2);

    float redFrequency   = 0.1f;
    float blueFrequency  = 0.13f;
    float greenFrequency = 0.01f;

    float redChannelPhase = 6f;
    float blueChannelPhase = 2f;
    float greenChannelPhase = .1f;

    public ColorMap(float redFrequency, float blueFrequency, float greenFrequency, float redChannelPhase, float blueChannelPhase, float greenChannelPhase) {
        this.redFrequency = redFrequency;
        this.blueFrequency = blueFrequency;
        this.greenFrequency = greenFrequency;
        this.redChannelPhase = redChannelPhase;
        this.blueChannelPhase = blueChannelPhase;
        this.greenChannelPhase = greenChannelPhase;
    }

    public ColorMap(){
        // empty ctr
    }

    public Color getFractalColor(FractalPointData fractalPointData){
        double mu = fractalPointData.getIterations() + 1 - Math.log(Math.log(fractalPointData.getConvergedAbsolute()/LOG2)/LOG2);

        int red = (int)(Math.sin(redFrequency * mu + redChannelPhase) * 128f + 127f);
        int green = (int)(Math.sin(greenFrequency * mu + greenChannelPhase) * 128f + 127f);
        int blue = (int)(Math.sin(blueFrequency * mu + blueChannelPhase) * 128f + 127f);

        red = Utils.Clamp(red, 0, 255);
        green = Utils.Clamp(green, 0, 255);
        blue = Utils.Clamp(blue, 0 , 255);

        return new Color(red, green, blue);
    }

    public float getRedFrequency() {
        return redFrequency;
    }

    public void setRedFrequency(float redFrequency) {
        this.redFrequency = redFrequency;
    }

    public float getBlueFrequency() {
        return blueFrequency;
    }

    public void setBlueFrequency(float blueFrequency) {
        this.blueFrequency = blueFrequency;
    }

    public float getGreenFrequency() {
        return greenFrequency;
    }

    public void setGreenFrequency(float greenFrequency) {
        this.greenFrequency = greenFrequency;
    }

    public float getRedChannelPhase() {
        return redChannelPhase;
    }

    public void setRedChannelPhase(float redChannelPhase) {
        this.redChannelPhase = redChannelPhase;
    }

    public float getBlueChannelPhase() {
        return blueChannelPhase;
    }

    public void setBlueChannelPhase(float blueChannelPhase) {
        this.blueChannelPhase = blueChannelPhase;
    }

    public float getGreenChannelPhase() {
        return greenChannelPhase;
    }

    public void setGreenChannelPhase(float greenChannelPhase) {
        this.greenChannelPhase = greenChannelPhase;
    }

    // Singleton
    public static ColorMap instance = null;

    public static ColorMap getInstance(){
        if (instance == null) instance = new ColorMap();

        return instance;
    }
}
