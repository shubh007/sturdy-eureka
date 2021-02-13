package com.coderscafe.sturdyeureka.core.dp.dpimpl;

import com.coderscafe.sturdyeureka.core.dp.TargetSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TargetSumMemoized implements TargetSum {
    @Override
    public boolean canSum(List<Integer> numbers, int targetSum) {
        return canSum(numbers, targetSum, new HashMap<>());
    }

    @Override
    public List<Integer> howSum(List<Integer> numbers, int targetSum) {
        return howSum(numbers, targetSum, new HashMap<>());
    }

    @Override
    public List<Integer> bestSum(List<Integer> numbers, int targetSum) {
        return bestSum(numbers, targetSum, new HashMap<>());
    }

    private boolean canSum(List<Integer> numbers, int targetSum, Map<Integer, Boolean> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return true;
        }
        if (targetSum < 0) {
            return false;
        }
        for (int val : numbers) {
            if (canSum(numbers, targetSum - val, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }

    private List<Integer> howSum(List<Integer> numbers, int targetSum, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        if (targetSum < 0) {
            return null;
        }
        for (int val : numbers) {
            List<Integer> currList = howSum(numbers, targetSum - val, memo);
            if (currList != null) {
                currList.add(val);
                memo.put(targetSum, currList);
                return currList;
            }
        }
        memo.put(targetSum, null);
        return null;
    }

    private List<Integer> bestSum(List<Integer> numbers, int targetSum, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0) {
            return new ArrayList<>();
        }
        if (targetSum < 0) {
            return null;
        }
        List<Integer> bestResult = null;
        for (int val : numbers) {
            List<Integer> currResult = bestSum(numbers, targetSum - val, memo);
            if (currResult != null && (bestResult == null || bestResult.size() > (currResult.size() + 1))) {
                bestResult = new ArrayList<>(currResult);
                bestResult.add(val);
            }
        }
        memo.put(targetSum, bestResult);
        return bestResult;
    }
}
