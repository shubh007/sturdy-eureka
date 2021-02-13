package com.coderscafe.sturdyeureka.core.dp;

import com.coderscafe.sturdyeureka.constant.enums.DpApproachType;
import com.coderscafe.sturdyeureka.core.dp.dpimpl.TargetSumBruteForce;
import com.coderscafe.sturdyeureka.core.dp.dpimpl.TargetSumMemoized;
import com.coderscafe.sturdyeureka.core.dp.dpimpl.TargetSumTabulation;
import com.coderscafe.sturdyeureka.utils.CommonUtils;
import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class TargetSumTest {
    private static TargetSum[] targetSumImpls;

    @BeforeAll
    public static void setup() {
        targetSumImpls = new TargetSum[]{new TargetSumBruteForce(), new TargetSumMemoized(), new TargetSumTabulation()};
    }

    private static Stream<Arguments> canSumData() {
        return Stream.of(
                Arguments.of(7, Arrays.asList(2, 3), true),
                Arguments.of(7, Arrays.asList(5, 3, 4, 7), true),
                Arguments.of(7, Arrays.asList(2, 4), false),
                Arguments.of(8, Arrays.asList(2, 3, 5), true),
                Arguments.of(300, Arrays.asList(7, 14), false)
        );
    }

    private static Stream<Arguments> howSumData() {
        return Stream.of(
                Arguments.of(7, Arrays.asList(2, 3), Arrays.asList(3, 2, 2), Arrays.asList(3, 2, 2)),
                Arguments.of(7, Arrays.asList(5, 3, 4, 7), Arrays.asList(4, 3), Collections.singletonList(7)),
                Arguments.of(7, Arrays.asList(2, 4), null, null),
                Arguments.of(8, Arrays.asList(2, 3, 5), Arrays.asList(2, 2, 2, 2), Arrays.asList(5, 3)),
                Arguments.of(300, Arrays.asList(7, 14), null, null)
        );
    }

    private static Stream<Arguments> bestSumData() {
        return Stream.of(
                Arguments.of(7, Arrays.asList(5, 3, 4, 7), Collections.singletonList(7)),
                Arguments.of(8, Arrays.asList(2, 3, 5), Arrays.asList(5, 3)),
                Arguments.of(8, Arrays.asList(1, 4, 5), Arrays.asList(4, 4)),
                Arguments.of(50, Arrays.asList(1, 3, 15, 25), Arrays.asList(25, 25))
        );
    }

    @ParameterizedTest
    @MethodSource("canSumData")
    void canSum(int targetSum, List<Integer> numbers, boolean expected) {
        for (TargetSum targetSumImpl : targetSumImpls) {
            Stopwatch stopwatch = Stopwatch.createStarted();
            boolean acc = targetSumImpl.canSum(numbers, targetSum);
            stopwatch.stop();
            Assertions.assertEquals(expected, acc);
            CommonUtils.printStats(stopwatch, targetSumImpl.dpApproachType);
        }
    }

    @ParameterizedTest
    @MethodSource("howSumData")
    void howSum(int targetSum, List<Integer> numbers, List<Integer> expected, List<Integer> expectedTabu) {
        for (TargetSum targetSumImpl : targetSumImpls) {
            Stopwatch stopwatch = Stopwatch.createStarted();
            List<Integer> acc = targetSumImpl.howSum(numbers, targetSum);
            stopwatch.stop();
            if (targetSumImpl.dpApproachType.equals(DpApproachType.TABULATION)) {
                Assertions.assertEquals(expectedTabu, acc);
            } else {
                Assertions.assertEquals(expected, acc);
            }
            CommonUtils.printStats(stopwatch, targetSumImpl.dpApproachType);
        }
    }

    @ParameterizedTest
    @MethodSource("bestSumData")
    void bestSum(int targetSum, List<Integer> numbers, List<Integer> expected) {
        for (TargetSum targetSumImpl : targetSumImpls) {
            Stopwatch stopwatch = Stopwatch.createStarted();
            List<Integer> acc = targetSumImpl.bestSum(numbers, targetSum);
            stopwatch.stop();
            Assertions.assertEquals(expected, acc);
            CommonUtils.printStats(stopwatch, targetSumImpl.dpApproachType);
        }
    }

}