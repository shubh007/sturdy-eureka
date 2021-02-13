package com.coderscafe.sturdyeureka.core.dp;

import com.coderscafe.sturdyeureka.core.dp.dpimpl.FibonacciNumberBruteForce;
import com.coderscafe.sturdyeureka.core.dp.dpimpl.FibonacciNumberMemoized;
import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

class FibonacciNumberTest {

    private static FibonacciNumber fibonacciNumberBruteForce;
    private static FibonacciNumber fibonacciNumberMemoized;

    @BeforeAll
    public static void setup() {
        fibonacciNumberBruteForce = new FibonacciNumberBruteForce();
        fibonacciNumberMemoized = new FibonacciNumberMemoized();
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
        Stopwatch stopwatchBf = Stopwatch.createStarted();
        long accBf = fibonacciNumberBruteForce.getNthFibonacci(n);
        stopwatchBf.stop();
        Assertions.assertEquals(expected, accBf);

        Stopwatch stopwatchMemo = Stopwatch.createStarted();
        long accMemo = fibonacciNumberMemoized.getNthFibonacci(n);
        stopwatchMemo.stop();
        Assertions.assertEquals(expected, accMemo);

        System.out.println("Time elapsed In NANOSECONDS: BruteForce : " + stopwatchBf.elapsed(TimeUnit.NANOSECONDS)
                + " , Memoized : " + stopwatchMemo.elapsed(TimeUnit.NANOSECONDS));
        System.out.println("Time elapsed In MILLISECONDS: BruteForce : " + stopwatchBf.elapsed(TimeUnit.MILLISECONDS)
                + " , Memoized : " + stopwatchMemo.elapsed(TimeUnit.MILLISECONDS));
        System.out.println("Time elapsed In SECONDS: BruteForce : " + stopwatchBf.elapsed(TimeUnit.SECONDS)
                + " , Memoized : " + stopwatchMemo.elapsed(TimeUnit.SECONDS));
    }

}