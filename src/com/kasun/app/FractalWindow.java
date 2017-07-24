package com.kasun.app;

import com.kasun.fractal.AbstractFractal;
import com.kasun.fractal.Julia;
import com.kasun.fractal.Manderbolt;
import com.kasun.math.Complex;
import com.kasun.ui.*;
import com.kasun.ui.Point;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kasun on 7/15/17.
 */
public class FractalWindow extends JFrame {

    public FractalWindow(String title, int width, int height){
        setTitle(title);
        setSize(width,height);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ColorMap colorMap = new ColorMap();
        Manderbolt manderbolt = new Manderbolt(-2f, 2f, -2f, 2f, 1000);
        Julia julia = new Julia(new Complex(-0.4f, 0.6f), 1000);

        AbstractFractal abstractFractal = manderbolt;

        for (int x = 0; x <= 800; x++){
            for (int y = 0; y <= 800; y++){
                Point.renderPoint(g, new Point(x, y), colorMap.getFractalColor(abstractFractal.getFractal(x, y)));
            }
        }
    }

}
