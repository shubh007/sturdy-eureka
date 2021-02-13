package com.coderscafe.sturdyeureka.core.dp;

import com.coderscafe.sturdyeureka.constant.enums.DpApproachType;

import java.util.List;

public abstract class TargetSum {

    public DpApproachType dpApproachType;

    public abstract boolean canSum(List<Integer> numbers, int targetSum);

    public abstract List<Integer> howSum(List<Integer> numbers, int targetSum);

    public abstract List<Integer> bestSum(List<Integer> numbers, int targetSum);
}
