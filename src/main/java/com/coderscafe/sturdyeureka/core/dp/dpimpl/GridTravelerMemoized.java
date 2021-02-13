package com.coderscafe.sturdyeureka.core.dp.dpimpl;

import com.coderscafe.sturdyeureka.constant.enums.DpApproachType;
import com.coderscafe.sturdyeureka.core.dp.GridTraveler;


public class GridTravelerMemoized extends GridTraveler {

    public GridTravelerMemoized() {
        dpApproachType = DpApproachType.MEMOIZATION;
    }

    @Override
    public long travelGrid(int row, int col) {
        return travelGrid(row, col, new long[row][col]);
    }

    private long travelGrid(int row, int col, long[][] memo) {
        if (row <= 0 || col <= 0) {
            return 0;
        }
        if (row == 1 && col == 1) {
            return 1;
        }
        if (memo[row - 1][col - 1] > 0) {
            return memo[row - 1][col - 1];
        }
        memo[row - 1][col - 1] = travelGrid(row - 1, col, memo) + travelGrid(row, col - 1, memo);
        return memo[row - 1][col - 1];
    }
}
