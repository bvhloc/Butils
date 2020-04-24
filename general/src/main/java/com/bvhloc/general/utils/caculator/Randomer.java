package com.bvhloc.general.utils.caculator;

import java.util.Random;

/**
 * Created by Leon on 11/15/2016.
 */

public class Randomer {

    public static long longInRange(long min, long max) {

        return (long) doubleInRange(min, max); // == (rand.nextDouble() * (max-min)) + min;
    }

    public static double doubleInRange(double min, double max) {

        Random random = new Random();
        double range = max - min;
        double scaled = random.nextDouble() * range;
        double shifted = scaled + min;
        return shifted; // == (rand.nextDouble() * (max-min)) + min;
    }
}
