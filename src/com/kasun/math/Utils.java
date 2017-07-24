package com.kasun.math;

/**
 * Created by kasun on 7/24/17.
 */
public final class Utils {
    public static int Clamp(int value, int min, int max){
        if (value < min)
            return min;

        if (value > max)
            return max;

        return value;
    }
}
