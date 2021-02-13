package com.coderscafe.sturdyeureka.core.dp.dpimpl;

import com.coderscafe.sturdyeureka.constant.enums.DpApproachType;
import com.coderscafe.sturdyeureka.core.dp.FibonacciNumber;

public class FibonacciNumberTabulation extends FibonacciNumber {

    public FibonacciNumberTabulation() {
        dpApproachType = DpApproachType.TABULATION;
    }

    @Override
    public long getNthFibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        long[] fibs = new long[n + 1];
        fibs[1] = 1;
        for (int fibIndex = 2; fibIndex <= n; fibIndex++) {
            fibs[fibIndex] = fibs[fibIndex - 1] + fibs[fibIndex - 2];
        }
        return fibs[n];
    }
}
