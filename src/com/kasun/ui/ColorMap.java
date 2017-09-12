package com.kasun.ui;

import com.kasun.fractal.FractalPointData;
import com.kasun.math.Utils;

import java.awt.*;

/**
 * Created by kasun on 7/16/17.
 */
public class ColorMap {

    public static final double LOG2 = Math.log(2);
    // Singleton
    private static ColorMap instance = null;
    float redFrequency = 0.16f;
    float blueFrequency  = 0.13f;
    float greenFrequency = 0.01f;
    float redChannelPhase = 6f;
    float blueChannelPhase = 2f;
    float greenChannelPhase = .05f;

    public ColorMap(){
        // empty ctr
    }

    public static ColorMap getInstance() {
        if (instance == null) instance = new ColorMap();

        return instance;
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
}
