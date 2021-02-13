package com.coderscafe.sturdyeureka.core.dp;

import com.coderscafe.sturdyeureka.core.dp.dpimpl.FibonacciNumberBruteForce;
import com.coderscafe.sturdyeureka.core.dp.dpimpl.FibonacciNumberMemoized;
import com.coderscafe.sturdyeureka.core.dp.dpimpl.FibonacciNumberTabulation;
import com.coderscafe.sturdyeureka.utils.CommonUtils;
import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FibonacciNumberTest {

    private static FibonacciNumber[] fibonacciNumberImpls;

    @BeforeAll
    public static void setup() {
        fibonacciNumberImpls = new FibonacciNumber[]{new FibonacciNumberBruteForce(), new FibonacciNumberMemoized(), new FibonacciNumberTabulation()};
    }

    private static Stream<Arguments> fibData() {
        return Stream.of(
                Arguments.of(7, 13),
                Arguments.of(8, 21),
                Arguments.of(15, 610),
                Arguments.of(20, 6765),
                Arguments.of(47, 2971215073L)
        );
    }

    @ParameterizedTest
    @MethodSource("fibData")
    void getNthFibonacci(int n, long expected) {
        for (FibonacciNumber fibonacciNumberImpl : fibonacciNumberImpls) {
            Stopwatch stopwatch = Stopwatch.createStarted();
            long acc = fibonacciNumberImpl.getNthFibonacci(n);
            stopwatch.stop();
            Assertions.assertEquals(expected, acc);
            CommonUtils.printStats(stopwatch, fibonacciNumberImpl.dpApproachType);
        }
    }

}