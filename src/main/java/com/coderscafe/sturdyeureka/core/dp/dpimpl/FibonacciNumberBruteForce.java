package com.coderscafe.sturdyeureka.core.dp.dpimpl;

import com.coderscafe.sturdyeureka.constant.enums.DpApproachType;
import com.coderscafe.sturdyeureka.core.dp.FibonacciNumber;

public class FibonacciNumberBruteForce extends FibonacciNumber {

    public FibonacciNumberBruteForce() {
        dpApproachType = DpApproachType.BRUTEFORCE;
    }

    @Override
    public long getNthFibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return getNthFibonacci(n - 1) + getNthFibonacci(n - 2);
    }
}
