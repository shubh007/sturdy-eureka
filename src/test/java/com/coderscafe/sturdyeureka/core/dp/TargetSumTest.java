package com.coderscafe.sturdyeureka.core.dp;

import com.coderscafe.sturdyeureka.core.dp.dpimpl.TargetSumBruteForce;
import com.coderscafe.sturdyeureka.core.dp.dpimpl.TargetSumMemoized;
import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

class TargetSumTest {

    private static TargetSum targetSumBruteForce ;
    private static TargetSum targetSumMemoized ;

    @BeforeAll
    public static void setup(){
        targetSumBruteForce = new TargetSumBruteForce();
        targetSumMemoized = new TargetSumMemoized();
    }

    @ParameterizedTest
    @MethodSource("canSumData")
    void canSum(int targetSum, List<Integer> numbers, boolean expected) {

        Stopwatch stopwatchBf = Stopwatch.createStarted();
        boolean accBf = targetSumBruteForce.canSum(numbers,targetSum);
        stopwatchBf.stop();
        Assertions.assertEquals(expected,accBf);

        Stopwatch stopwatchMemo = Stopwatch.createStarted();
        boolean accMemo = targetSumMemoized.canSum(numbers,targetSum);
        stopwatchMemo.stop();
        Assertions.assertEquals(expected,accMemo);

        System.out.println("Time elapsed In NANOSECONDS: BruteForce : "+ stopwatchBf.elapsed(TimeUnit.NANOSECONDS)
                +" , Memoized : "+ stopwatchMemo.elapsed(TimeUnit.NANOSECONDS));
        System.out.println("Time elapsed In MILLISECONDS: BruteForce : "+ stopwatchBf.elapsed(TimeUnit.MILLISECONDS)
                +" , Memoized : "+ stopwatchMemo.elapsed(TimeUnit.MILLISECONDS));
        System.out.println("Time elapsed In SECONDS: BruteForce : "+ stopwatchBf.elapsed(TimeUnit.SECONDS)
                +" , Memoized : "+ stopwatchMemo.elapsed(TimeUnit.SECONDS));
    }

    @ParameterizedTest
    @MethodSource("howSumData")
    void howSum(int targetSum, List<Integer> numbers, List<Integer> expected) {
        Stopwatch stopwatchBf = Stopwatch.createStarted();
        List<Integer> accBf = targetSumBruteForce.howSum(numbers,targetSum);
        stopwatchBf.stop();
        Assertions.assertEquals(expected,accBf);

        Stopwatch stopwatchMemo = Stopwatch.createStarted();
        List<Integer> accMemo = targetSumMemoized.howSum(numbers,targetSum);
        stopwatchMemo.stop();
        Assertions.assertEquals(expected,accMemo);

        System.out.println("Time elapsed In NANOSECONDS: BruteForce : "+ stopwatchBf.elapsed(TimeUnit.NANOSECONDS)
                +" , Memoized : "+ stopwatchMemo.elapsed(TimeUnit.NANOSECONDS));
        System.out.println("Time elapsed In MILLISECONDS: BruteForce : "+ stopwatchBf.elapsed(TimeUnit.MILLISECONDS)
                +" , Memoized : "+ stopwatchMemo.elapsed(TimeUnit.MILLISECONDS));
        System.out.println("Time elapsed In SECONDS: BruteForce : "+ stopwatchBf.elapsed(TimeUnit.SECONDS)
                +" , Memoized : "+ stopwatchMemo.elapsed(TimeUnit.SECONDS));
    }

    @ParameterizedTest
    @MethodSource("bestSumData")
    void bestSum(int targetSum, List<Integer> numbers, List<Integer> expected) {
        Stopwatch stopwatchBf = Stopwatch.createStarted();
        List<Integer> accBf = targetSumBruteForce.bestSum(numbers,targetSum);
        stopwatchBf.stop();
        Assertions.assertEquals(expected,accBf);

        Stopwatch stopwatchMemo = Stopwatch.createStarted();
        List<Integer> accMemo = targetSumMemoized.bestSum(numbers,targetSum);
        stopwatchMemo.stop();
        Assertions.assertEquals(expected,accMemo);

        System.out.println("Time elapsed In NANOSECONDS: BruteForce : "+ stopwatchBf.elapsed(TimeUnit.NANOSECONDS)
                +" , Memoized : "+ stopwatchMemo.elapsed(TimeUnit.NANOSECONDS));
        System.out.println("Time elapsed In MILLISECONDS: BruteForce : "+ stopwatchBf.elapsed(TimeUnit.MILLISECONDS)
                +" , Memoized : "+ stopwatchMemo.elapsed(TimeUnit.MILLISECONDS));
        System.out.println("Time elapsed In SECONDS: BruteForce : "+ stopwatchBf.elapsed(TimeUnit.SECONDS)
                +" , Memoized : "+ stopwatchMemo.elapsed(TimeUnit.SECONDS));
    }
    private static Stream<Arguments> canSumData() {
        return Stream.of(
                Arguments.of(7, Arrays.asList(2,3),true),
                Arguments.of(7, Arrays.asList(5,3,4,7),true),
                Arguments.of(7, Arrays.asList(2,4),false),
                Arguments.of(8, Arrays.asList(2,3,5),true),
                Arguments.of(300, Arrays.asList(7,14),false)
        );
    }
    private static Stream<Arguments> howSumData() {
        return Stream.of(
                Arguments.of(7, Arrays.asList(2,3),Arrays.asList(3,2,2)),
                Arguments.of(7, Arrays.asList(5,3,4,7),Arrays.asList(4,3)),
                Arguments.of(7, Arrays.asList(2,4),null),
                Arguments.of(8, Arrays.asList(2,3,5),Arrays.asList(2,2,2,2)),
                Arguments.of(300, Arrays.asList(7,14),null)
        );
    }
    private static Stream<Arguments> bestSumData() {
        return Stream.of(
                Arguments.of(7, Arrays.asList(5,3,4,7), Collections.singletonList(7)),
                Arguments.of(8, Arrays.asList(2,3,5),Arrays.asList(5,3)),
                Arguments.of(8, Arrays.asList(1,4,5),Arrays.asList(4,4)),
                Arguments.of(50, Arrays.asList(1,3,15,25),Arrays.asList(25,25))
        );
    }

}