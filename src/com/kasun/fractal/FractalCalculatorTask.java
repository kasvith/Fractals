package com.kasun.fractal;

import com.kasun.ui.ColorMap;
import com.kasun.ui.Point;

import java.awt.*;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.RecursiveTask;

/**
 * Created by kasun on 9/9/17.
 */
public class FractalCalculatorTask implements Runnable {
    FractalClusterCallback callback;
    AbstractFractal fractal;
    FractalCluster cluster;


    public FractalCalculatorTask(AbstractFractal fractal, FractalCluster cluster, FractalClusterCallback callback) {
        this.fractal = fractal;
        this.cluster = cluster;
        this.callback = callback;
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        HashMap<Point, Color> map = cluster.getCluster();

        for (HashMap.Entry<Point, Color> entry : map.entrySet())
        {
            Color data = ColorMap.getInstance().getFractalColor(fractal.getFractal(entry.getKey()));
            map.put(entry.getKey(), data);
        }
        cluster.setCluster(map);

        callback.paintCluster(cluster);
    }
}
