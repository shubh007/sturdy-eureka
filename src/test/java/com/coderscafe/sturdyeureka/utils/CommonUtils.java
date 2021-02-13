package com.coderscafe.sturdyeureka.utils;

import com.coderscafe.sturdyeureka.constant.enums.DpApproachType;
import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

public class CommonUtils {

    public static void printStats(Stopwatch stopwatch, DpApproachType dpApproachType) {
        System.out.println("Time elapsed in " + dpApproachType.name().toLowerCase() + " approach :"
                + " nanoseconds : " + stopwatch.elapsed(TimeUnit.NANOSECONDS)
                + ", milliseconds : " + stopwatch.elapsed(TimeUnit.MILLISECONDS)
                + ", seconds : " + stopwatch.elapsed(TimeUnit.SECONDS));
    }
}
