package com.kasun.events;

import java.util.ArrayList;

/**
 * Created by kasun on 8/1/17.
 */
public class FractalEventHandler {
    private ArrayList<FractalChangedListener> _listners = new ArrayList<>();

    public synchronized void addFractalChangedListener(FractalChangedListener listener) {
        _listners.add(listener);
    }

    public synchronized void removeFractalChangedListener(FractalChangedListener listener) {
        _listners.remove(listener);
    }

    public void dispatchEvent(FractalEvent e) {
        for (FractalChangedListener listner : _listners) {
            listner.onFractalChange(e);
        }
    }
}
