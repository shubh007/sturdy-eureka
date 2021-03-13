package com.coderscafe.sturdyeureka.core.unionfind;

import com.coderscafe.sturdyeureka.core.dp.FibonacciNumber;
import com.coderscafe.sturdyeureka.core.dp.dpimpl.FibonacciNumberBruteForce;
import com.coderscafe.sturdyeureka.core.dp.dpimpl.FibonacciNumberMemoized;
import com.coderscafe.sturdyeureka.core.dp.dpimpl.FibonacciNumberTabulation;
import com.coderscafe.sturdyeureka.utils.CommonUtils;
import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AccountsMergeTest {

    private static AccountsMerge accountsMerge ;

    @BeforeAll
    public static void setup() {
        accountsMerge = new AccountsMerge();
    }

    private static Stream<Arguments> accountsData() {

        List[] input1 = {Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"),Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),Arrays.asList("Mary","mary@mail.com"),Arrays.asList("John","johnnybravo@mail.com")};
        List[] output1 = {Arrays.asList("John","johnnybravo@mail.com"),Arrays.asList("John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"),Arrays.asList("Mary","mary@mail.com")};

        List[] input2 = {Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"),Arrays.asList("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"),Arrays.asList("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"),Arrays.asList("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"),Arrays.asList("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co")};
        List[] output2 = {Arrays.asList("Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"),Arrays.asList("Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"),Arrays.asList("Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"),Arrays.asList("Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"),Arrays.asList("Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co")};
        return Stream.of(
                Arguments.of(Arrays.asList(input1), Arrays.asList(output1)),
                Arguments.of(Arrays.asList(input2), Arrays.asList(output2))
        );
    }

    @ParameterizedTest
    @MethodSource("accountsData")
    void mergeAccounts(List<List<String>> accounts , List<List<String>> expAccounts) {
        List<List<String>> accAccounts = accountsMerge.mergeAccounts(accounts);
        Assertions.assertEquals(accAccounts.size(), expAccounts.size());
        int size = accAccounts.size();
        for(int index = 0 ; index < size ; index++){
            Assertions.assertEquals(accAccounts.get(index), expAccounts.get(index));
        }
    }
}