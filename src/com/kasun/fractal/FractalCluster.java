package com.kasun.fractal;

import com.kasun.ui.Point;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by kasun on 9/9/17.
 */
public class FractalCluster {
    HashMap<Point, Color> cluster = new HashMap<>();
    String name;

    public FractalCluster(String name) {
        this.name = name;
    }

    public void addPoint(int x, int y)
    {
        cluster.put(new Point(x, y), null);
    }

    public HashMap<Point, Color> getCluster()
    {
        return cluster;
    }

    public void setCluster(HashMap<Point, Color> cluster) {
        this.cluster = cluster;
    }

    @Override
    public String toString() {
        return "FractalCluster{" +
                "name='" + name + '\'' +
                '}';
    }
}
