package com.kasun.ui;

import com.kasun.events.FractalChangedListener;
import com.kasun.events.FractalEvent;
import com.kasun.fractal.AbstractFractal;
import com.kasun.fractal.FractalCalculatorTask;
import com.kasun.fractal.FractalCluster;
import com.kasun.fractal.FractalClusterCallback;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by kasun on 7/24/17.
 */
public class FractalViewport extends JPanel implements FractalChangedListener, FractalClusterCallback {
    private static int NUMBER_OF_CLUSTERS = 100;
    int clusterSize;
    BufferedImage image;
    ExecutorService pool;
    ArrayList<Future<?>> futures = new ArrayList<>();
    private AbstractFractal fractal = null;
    private ArrayList<FractalCluster> clusters = new ArrayList<>();

    public FractalViewport(int width, int height){
        setPreferredSize(new Dimension(width, height));
        setSize(width, height);
        setDoubleBuffered(true);
        clusterSize = getHeight()/NUMBER_OF_CLUSTERS;

        image = new BufferedImage(getWidth(), getHeight(), BufferedImage.SCALE_SMOOTH);
    }

    public AbstractFractal getFractal() {
        return fractal;
    }

    public void setFractal(AbstractFractal fractal) {
        this.fractal = fractal;
        if (pool != null)
        {
            pool.shutdownNow();

            for (Future<?> future : futures)
            {
                future.cancel(true);
            }

        }
        this.setUpClusters();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    public void paintCluster(FractalCluster cluster){
        Graphics g = image.getGraphics();

        for (HashMap.Entry<Point, Color> entry : cluster.getCluster().entrySet())
        {
            Point.renderPoint(g, entry.getKey(), entry.getValue());
        }

        this.repaint();
        this.invalidate();
    }

    @Override
    public void onFractalChange(FractalEvent e) {
        setFractal(e.fractal);
    }

    private void setUpClusters()
    {
        clusters = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_CLUSTERS; i++)
            clusters.add(new FractalCluster(Integer.toString(i)));

        int currentClusterIndex = 0;
        FractalCluster currentCluster = clusters.get(currentClusterIndex);
        for (int y = 0; y <= getHeight(); y++)
        {
            if (y % clusterSize == 0 && currentClusterIndex < NUMBER_OF_CLUSTERS)
            {
                currentCluster = clusters.get(currentClusterIndex++);
            }

            for (int x = 0; x <= getWidth(); x++)
            {
                currentCluster.addPoint(x, y);
            }
        }

        pool = Executors.newCachedThreadPool();

        try{
            for (FractalCluster cluster : clusters)
            {
                FractalCalculatorTask task = new FractalCalculatorTask(fractal, cluster, this);

                futures.add(pool.submit(task));
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            pool.shutdown();
        }
    }
}
