package com.coderscafe.sturdyeureka.core.dp.dpimpl;

import com.coderscafe.sturdyeureka.constant.enums.DpApproachType;
import com.coderscafe.sturdyeureka.core.dp.TargetSum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TargetSumTabulation extends TargetSum {

    public TargetSumTabulation() {
        dpApproachType = DpApproachType.TABULATION;
    }

    @Override
    public boolean canSum(List<Integer> numbers, int targetSum) {
        boolean[] sums = new boolean[targetSum + 1];
        sums[0] = true;
        for (int sum = 0; sum <= targetSum; sum++) {
            if (sums[sum]) {
                for (int num : numbers) {
                    int index = sum + num;
                    if (index == targetSum) {
                        return true;
                    }
                    if (index <= targetSum) {
                        sums[index] = true;
                    }
                }
            }
        }
        return sums[targetSum];
    }

    @Override
    public List<Integer> howSum(List<Integer> numbers, int targetSum) {
        List<Deque<Integer>> sumLists = new ArrayList<>(targetSum + 1);
        for (int sum = 0; sum <= targetSum; sum++) {
            sumLists.add(null);
        }
        sumLists.set(0, new ArrayDeque<>());
        for (int sum = 0; sum <= targetSum; sum++) {
            Deque<Integer> currList = sumLists.get(sum);
            if (currList != null) {
                for (int num : numbers) {
                    int index = sum + num;
                    if (index > targetSum || sumLists.get(index) != null) {
                        continue;
                    }
                    currList.addFirst(num);
                    if (index == targetSum) {
                        return new ArrayList<>(currList);
                    }
                    sumLists.set(index, new ArrayDeque<>(currList));
                    currList.removeFirst();
                }
            }
        }
        return sumLists.get(targetSum) == null ? null : new ArrayList<>(sumLists.get(targetSum));
    }

    @Override
    public List<Integer> bestSum(List<Integer> numbers, int targetSum) {
        List<List<Integer>> sumLists = new ArrayList<>(targetSum + 1);
        for (int sum = 0; sum <= targetSum; sum++) {
            sumLists.add(null);
        }
        sumLists.set(0, new ArrayList<>());
        for (int sum = 0; sum <= targetSum; sum++) {
            List<Integer> currList = sumLists.get(sum);
            if (currList != null) {
                for (int num : numbers) {
                    int index = sum + num;
                    if (index > targetSum) {
                        continue;
                    }
                    List<Integer> tempList = new ArrayList<>(currList);
                    tempList.add(num);
                    if (sumLists.get(index) == null || currList.size() < sumLists.get(index).size()) {
                        sumLists.set(index, tempList);
                    }
                }
            }
        }
        return sumLists.get(targetSum) == null ? null : new ArrayList<>(sumLists.get(targetSum));
    }
}
