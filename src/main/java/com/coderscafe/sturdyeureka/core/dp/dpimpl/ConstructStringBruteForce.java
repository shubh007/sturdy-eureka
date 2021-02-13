package com.coderscafe.sturdyeureka.core.dp.dpimpl;

import com.coderscafe.sturdyeureka.constant.enums.DpApproachType;
import com.coderscafe.sturdyeureka.core.dp.ConstructString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConstructStringBruteForce extends ConstructString {

    public ConstructStringBruteForce() {
        dpApproachType = DpApproachType.BRUTEFORCE;
    }

    @Override
    public boolean canConstruct(List<String> availableString, String targetString) {
        if (targetString.equals("")) {
            return true;
        }
        for (String prefix : availableString) {
            if (targetString.startsWith(prefix) && canConstruct(availableString, targetString.substring(prefix.length()))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int countConstruct(List<String> availableString, String targetString) {
        if (targetString.equals("")) {
            return 1;
        }
        int count = 0;
        for (String prefix : availableString) {
            if (targetString.startsWith(prefix)) {
                count += countConstruct(availableString, targetString.substring(prefix.length()));
            }
        }
        return count;
    }

    @Override
    public List<List<String>> allConstruct(List<String> availableString, String targetString) {
        if (targetString.equals("")) {
            return Collections.singletonList(new ArrayList<>());
        }
        List<List<String>> result = new ArrayList<>();
        for (String prefix : availableString) {
            if (targetString.startsWith(prefix)) {
                List<List<String>> currResult = allConstruct(availableString, targetString.substring(prefix.length()));
                for (List<String> construct : currResult) {
                    construct.add(prefix);
                    result.add(construct);
                }
            }
        }
        return result;
    }
}
