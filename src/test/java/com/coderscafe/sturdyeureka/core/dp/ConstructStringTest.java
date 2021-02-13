package com.coderscafe.sturdyeureka.core.dp;

import com.coderscafe.sturdyeureka.core.dp.dpimpl.ConstructStringBruteForce;
import com.coderscafe.sturdyeureka.core.dp.dpimpl.ConstructStringMemoized;
import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;


class ConstructStringTest {

    private static ConstructString constructStringBruteForce;
    private static ConstructString constructStringMemoized;

    @BeforeAll
    public static void setup() {
        constructStringBruteForce = new ConstructStringBruteForce();
        constructStringMemoized = new ConstructStringMemoized();
    }

    private static Stream<Arguments> canConstructData() {
        return Stream.of(
                Arguments.of("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd"), true),
                Arguments.of("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar"), false),
                Arguments.of("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t"), true),
                Arguments.of("eeeeeeeeeeeeeeeeeeeeeeeeeeeef", Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee"), false)
        );
    }

    private static Stream<Arguments> countConstructData() {
        return Stream.of(
                Arguments.of("purple", Arrays.asList("purp", "p", "ur", "le", "purpl"), 2),
                Arguments.of("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd"), 1),
                Arguments.of("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar"), 0),
                Arguments.of("enterapotentpot", Arrays.asList("a", "p", "ent", "enter", "ot", "o", "t"), 4),
                Arguments.of("eeeeeeeeeeeeeeeeeeeeeeeeeeeef", Arrays.asList("e", "ee", "eee", "eeee", "eeeee", "eeeeee"), 0)
        );
    }

    private static Stream<Arguments> allConstructData() {
        return Stream.of(
                Arguments.of("purple", Arrays.asList("purp", "p", "ur", "le", "purpl"), Arrays.asList(
                        Arrays.asList("le", "purp"),
                        Arrays.asList("le", "p", "ur", "p")
                )),
                Arguments.of("abcdef", Arrays.asList("ab", "abc", "cd", "def", "abcd", "ef", "c"), Arrays.asList(
                        Arrays.asList("ef", "cd", "ab"),
                        Arrays.asList("def", "c", "ab"),
                        Arrays.asList("def", "abc"),
                        Arrays.asList("ef", "abcd")
                )),
                Arguments.of("skateboard", Arrays.asList("bo", "rd", "ate", "t", "ska", "sk", "boar"), new ArrayList<>()),
                Arguments.of("aaaaaaaaaaaaaaaaaaaaaaaaaaaz", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa"), new ArrayList<>()),
                Arguments.of("", Arrays.asList("cat", "dog", "mouse"), Collections.singletonList(new ArrayList<>()))
        );
    }

    @ParameterizedTest
    @MethodSource("canConstructData")
    void canConstruct(String targetString, List<String> availableString, boolean expected) {
        Stopwatch stopwatchBf = Stopwatch.createStarted();
        boolean accBf = constructStringBruteForce.canConstruct(availableString, targetString);
        stopwatchBf.stop();
        Assertions.assertEquals(expected, accBf);

        Stopwatch stopwatchMemo = Stopwatch.createStarted();
        boolean accMemo = constructStringMemoized.canConstruct(availableString, targetString);
        stopwatchMemo.stop();
        Assertions.assertEquals(expected, accMemo);

        System.out.println("Time elapsed In NANOSECONDS: BruteForce : " + stopwatchBf.elapsed(TimeUnit.NANOSECONDS)
                + " , Memoized : " + stopwatchMemo.elapsed(TimeUnit.NANOSECONDS));
        System.out.println("Time elapsed In MILLISECONDS: BruteForce : " + stopwatchBf.elapsed(TimeUnit.MILLISECONDS)
                + " , Memoized : " + stopwatchMemo.elapsed(TimeUnit.MILLISECONDS));
        System.out.println("Time elapsed In SECONDS: BruteForce : " + stopwatchBf.elapsed(TimeUnit.SECONDS)
                + " , Memoized : " + stopwatchMemo.elapsed(TimeUnit.SECONDS));
    }

    @ParameterizedTest
    @MethodSource("countConstructData")
    void countConstruct(String targetString, List<String> availableString, int expected) {
        Stopwatch stopwatchBf = Stopwatch.createStarted();
        int accBf = constructStringBruteForce.countConstruct(availableString, targetString);
        stopwatchBf.stop();
        Assertions.assertEquals(expected, accBf);

        Stopwatch stopwatchMemo = Stopwatch.createStarted();
        int accMemo = constructStringMemoized.countConstruct(availableString, targetString);
        stopwatchMemo.stop();
        Assertions.assertEquals(expected, accMemo);

        System.out.println("Time elapsed In NANOSECONDS: BruteForce : " + stopwatchBf.elapsed(TimeUnit.NANOSECONDS)
                + " , Memoized : " + stopwatchMemo.elapsed(TimeUnit.NANOSECONDS));
        System.out.println("Time elapsed In MILLISECONDS: BruteForce : " + stopwatchBf.elapsed(TimeUnit.MILLISECONDS)
                + " , Memoized : " + stopwatchMemo.elapsed(TimeUnit.MILLISECONDS));
        System.out.println("Time elapsed In SECONDS: BruteForce : " + stopwatchBf.elapsed(TimeUnit.SECONDS)
                + " , Memoized : " + stopwatchMemo.elapsed(TimeUnit.SECONDS));
    }

    @ParameterizedTest
    @MethodSource("allConstructData")
    void allConstruct(String targetString, List<String> availableString, List<List<String>> expected) {
        Stopwatch stopwatchBf = Stopwatch.createStarted();
        List<List<String>> accBf = constructStringBruteForce.allConstruct(availableString, targetString);
        stopwatchBf.stop();
        Assertions.assertEquals(expected, accBf);

        Stopwatch stopwatchMemo = Stopwatch.createStarted();
        List<List<String>> accMemo = constructStringMemoized.allConstruct(availableString, targetString);
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