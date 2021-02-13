package com.coderscafe.sturdyeureka.core.dp.dpimpl;

import com.coderscafe.sturdyeureka.constant.enums.DpApproachType;
import com.coderscafe.sturdyeureka.core.dp.FibonacciNumber;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumberMemoized extends FibonacciNumber {

    public FibonacciNumberMemoized() {
        dpApproachType = DpApproachType.MEMOIZATION;
    }

    @Override
    public long getNthFibonacci(int n) {
        return getNthFibonacci(n, new HashMap<>());
    }

    private long getNthFibonacci(int n, Map<Integer, Long> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n <= 2) {
            return 1;
        }
        long fib = getNthFibonacci(n - 1, memo) + getNthFibonacci(n - 2, memo);
        memo.put(n, fib);
        return fib;
    }
}
