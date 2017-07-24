package com.kasun.ui;

import com.kasun.fractal.AbstractFractal;
import com.kasun.fractal.Julia;
import com.kasun.fractal.Manderbolt;
import com.kasun.math.Complex;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kasun on 7/24/17.
 */
public class FractalViewport extends JPanel {
    AbstractFractal fractal = null;

    public FractalViewport(int width, int height){
        setPreferredSize(new Dimension(width, height));
        setSize(width, height);
    }

    public AbstractFractal getFractal() {
        return fractal;
    }

    public void setFractal(AbstractFractal fractal) {
        this.fractal = fractal;
        this.invalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (fractal != null){
            for (int x = 0; x <= getWidth(); x++){
                for (int y = 0; y <= getHeight(); y++){
                    Point.renderPoint(g, new Point(x, y), ColorMap.getInstance().getFractalColor(fractal.getFractal(x, y)));
                }
            }
        }
    }


}
