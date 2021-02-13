package com.coderscafe.sturdyeureka.core.dp;

import com.coderscafe.sturdyeureka.core.dp.dpimpl.GridTravelerBruteForce;
import com.coderscafe.sturdyeureka.core.dp.dpimpl.GridTravelerMemoized;
import com.coderscafe.sturdyeureka.core.dp.dpimpl.GridTravelerTabulation;
import com.coderscafe.sturdyeureka.utils.CommonUtils;
import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class GridTravelerTest {

    private static GridTraveler[] gridTravelerImpls;

    @BeforeAll
    public static void setup() {
        gridTravelerImpls = new GridTraveler[]{new GridTravelerBruteForce(), new GridTravelerMemoized(), new GridTravelerTabulation()};
    }

    private static Stream<Arguments> gridData() {
        return Stream.of(
                Arguments.of(1, 1, 1),
                Arguments.of(2, 3, 3),
                Arguments.of(3, 2, 3),
                Arguments.of(3, 3, 6),
                Arguments.of(18, 18, 2333606220L)
        );
    }

    @ParameterizedTest
    @MethodSource("gridData")
    void travelGrid(int noOfRow, int noOfCols, long expected) {
        for (GridTraveler gridTravelerImpl : gridTravelerImpls) {
            Stopwatch stopwatch = Stopwatch.createStarted();
            long acc = gridTravelerImpl.travelGrid(noOfRow, noOfCols);
            stopwatch.stop();
            Assertions.assertEquals(expected, acc);
            CommonUtils.printStats(stopwatch, gridTravelerImpl.dpApproachType);
        }
    }
}