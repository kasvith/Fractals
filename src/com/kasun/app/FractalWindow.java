package com.kasun.app;

import com.kasun.events.FractalChangedListener;
import com.kasun.events.FractalEvent;
import com.kasun.fractal.AbstractFractal;
import com.kasun.fractal.Julia;
import com.kasun.fractal.Mandelbrot;
import com.kasun.ui.FractalViewport;
import com.kasun.ui.OptionsUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kasun on 7/15/17.
 */
public class FractalWindow extends JFrame implements FractalChangedListener {
    final int viewPortWidth = 800;
    final int viewPortHeight = 800;

    FractalViewport viewport;
    OptionsUI optionsUI;

    public FractalWindow(int width, int height, AbstractFractal fractal) {
        setSize(width,height);
        init(fractal);
        setLocationRelativeTo(null);
    }

    private void init(AbstractFractal fractal) {
        String fractalName = OptionsUI.MANDELBROT;

        viewport = new FractalViewport(viewPortWidth, viewPortHeight);
        optionsUI = new OptionsUI();
        optionsUI.getFractalEventHandler().addFractalChangedListener(viewport);
        optionsUI.getFractalEventHandler().addFractalChangedListener(this);

        getContentPane().add(viewport, BorderLayout.LINE_START);
        getContentPane().add(optionsUI);

        if (fractal instanceof Mandelbrot) {
            fractalName = OptionsUI.MANDELBROT;
        } else if (fractal instanceof Julia) {
            fractalName = OptionsUI.JULIA;
        }

        optionsUI.setFractalProperties(fractalName, fractal);
    }

    @Override
    public void onFractalChange(FractalEvent e) {
        setTitle(e.fractalType);
    }
}
