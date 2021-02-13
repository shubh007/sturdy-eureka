package com.coderscafe.sturdyeureka.core.dp.dpimpl;

import com.coderscafe.sturdyeureka.constant.enums.DpApproachType;
import com.coderscafe.sturdyeureka.core.dp.TargetSum;

import java.util.ArrayList;
import java.util.List;

public class TargetSumBruteForce extends TargetSum {

    public TargetSumBruteForce() {
        dpApproachType = DpApproachType.BRUTEFORCE;
    }

    @Override
    public boolean canSum(List<Integer> numbers, int targetSum) {
        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        for (int val : numbers) {
            if (canSum(numbers, targetSum - val)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Integer> howSum(List<Integer> numbers, int targetSum) {
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        if (targetSum < 0) {
            return null;
        }
        for (int val : numbers) {
            List<Integer> currList = howSum(numbers, targetSum - val);
            if (currList != null) {
                currList.add(val);
                return currList;
            }
        }
        return null;
    }

    @Override
    public List<Integer> bestSum(List<Integer> numbers, int targetSum) {
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        if (targetSum < 0) {
            return null;
        }
        List<Integer> bestResult = null;
        for (int val : numbers) {
            List<Integer> currResult = bestSum(numbers, targetSum - val);
            if (currResult != null) {
                currResult.add(val);
                if (bestResult == null || bestResult.size() > currResult.size()) {
                    bestResult = currResult;
                }
            }
        }
        return bestResult;
    }
}
