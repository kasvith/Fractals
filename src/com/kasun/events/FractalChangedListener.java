package com.kasun.events;

import java.util.EventListener;

/**
 * Created by kasun on 7/29/17.
 */
public interface FractalChangedListener extends EventListener {
    void onFractalChange(FractalEvent e);
}
