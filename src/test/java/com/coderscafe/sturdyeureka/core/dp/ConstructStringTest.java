package com.coderscafe.sturdyeureka.core.dp;

import com.coderscafe.sturdyeureka.core.dp.dpimpl.ConstructStringBruteForce;
import com.coderscafe.sturdyeureka.core.dp.dpimpl.ConstructStringMemoized;
import com.coderscafe.sturdyeureka.core.dp.dpimpl.ConstructStringTabulation;
import com.coderscafe.sturdyeureka.utils.CommonUtils;
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
import java.util.stream.Stream;


class ConstructStringTest {

    private static ConstructString[] constructStringImpls;

    @BeforeAll
    public static void setup() {
        constructStringImpls = new ConstructString[]{new ConstructStringBruteForce(), new ConstructStringMemoized(), new ConstructStringTabulation()};
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
        for (ConstructString constructStringImpl : constructStringImpls) {
            Stopwatch stopwatch = Stopwatch.createStarted();
            boolean acc = constructStringImpl.canConstruct(availableString, targetString);
            stopwatch.stop();
            Assertions.assertEquals(expected, acc);
            CommonUtils.printStats(stopwatch, constructStringImpl.dpApproachType);
        }
    }

    @ParameterizedTest
    @MethodSource("countConstructData")
    void countConstruct(String targetString, List<String> availableString, int expected) {
        for (ConstructString constructStringImpl : constructStringImpls) {
            Stopwatch stopwatch = Stopwatch.createStarted();
            int acc = constructStringImpl.countConstruct(availableString, targetString);
            stopwatch.stop();
            Assertions.assertEquals(expected, acc);
            CommonUtils.printStats(stopwatch, constructStringImpl.dpApproachType);
        }
    }

    @ParameterizedTest
    @MethodSource("allConstructData")
    void allConstruct(String targetString, List<String> availableString, List<List<String>> expected) {
        for (ConstructString constructStringImpl : constructStringImpls) {
            Stopwatch stopwatch = Stopwatch.createStarted();
            List<List<String>> acc = constructStringImpl.allConstruct(availableString, targetString);
            stopwatch.stop();
            Assertions.assertEquals(expected, acc);
            CommonUtils.printStats(stopwatch, constructStringImpl.dpApproachType);
        }
    }
}