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
    FractalViewport viewport;

    public FractalWindow(String title, int width, int height){
        setTitle(title);
        setSize(width,height);
        viewport = new FractalViewport(800,800);
        getContentPane().add(viewport, BorderLayout.LINE_START);

        viewport.setFractal(new Julia(new Complex(-.4f, .6f), 1000));
        setLocationRelativeTo(null);
    }

    private void init(){

    }

}
