package com.coderscafe.sturdyeureka.core.dp.dpimpl;

import com.coderscafe.sturdyeureka.core.dp.FibonacciNumber;

public class FibonacciNumberBruteForce implements FibonacciNumber {

    @Override
    public long getNthFibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return getNthFibonacci(n - 1) + getNthFibonacci(n - 2);
    }
}
