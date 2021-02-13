package com.coderscafe.sturdyeureka.core.dp;

import java.util.List;

public interface TargetSum {
     boolean canSum(List<Integer> numbers,int targetSum);
     List<Integer> howSum(List<Integer> numbers,int targetSum);
     List<Integer> bestSum(List<Integer> numbers,int targetSum);
}
