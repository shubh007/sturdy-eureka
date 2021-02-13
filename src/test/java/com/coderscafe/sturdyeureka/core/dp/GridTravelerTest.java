package com.coderscafe.sturdyeureka.core.dp;

import com.coderscafe.sturdyeureka.core.dp.dpimpl.GridTravelerBruteForce;
import com.coderscafe.sturdyeureka.core.dp.dpimpl.GridTravelerMemoized;
import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

class GridTravelerTest {

    private static GridTraveler gridTravelerBruteForce;
    private static GridTraveler gridTravelerMemoized;

    @BeforeAll
    public static void setup() {
        gridTravelerBruteForce = new GridTravelerBruteForce();
        gridTravelerMemoized = new GridTravelerMemoized();
    }

    private static Stream<Arguments> gridData() {
        return Stream.of(
                Arguments.of(1, 1, 1),
                Arguments.of(2, 3, 3),
                Arguments.of(3, 2, 3),
                Arguments.of(3, 3, 6),
                Arguments.of(17, 17, 601080390)
        );
    }

    @ParameterizedTest
    @MethodSource("gridData")
    void travelGrid(int noOfRow, int noOfCols, long expected) {
        Stopwatch stopwatchBf = Stopwatch.createStarted();
        long accBf = gridTravelerBruteForce.travelGrid(noOfRow, noOfCols, noOfRow, noOfCols);
        stopwatchBf.stop();
        Assertions.assertEquals(expected, accBf);

        Stopwatch stopwatchMemo = Stopwatch.createStarted();
        long accMemo = gridTravelerMemoized.travelGrid(noOfRow, noOfCols, noOfRow, noOfCols);
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