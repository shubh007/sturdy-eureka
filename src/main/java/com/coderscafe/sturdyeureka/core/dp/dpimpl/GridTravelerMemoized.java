package com.coderscafe.sturdyeureka.core.dp.dpimpl;

import com.coderscafe.sturdyeureka.core.dp.GridTraveler;


public class GridTravelerMemoized implements GridTraveler {

    @Override
    public long travelGrid(int row, int col, int noOfRows, int noOfCols) {
        return travelGrid(row, col, noOfRows, noOfCols, new long[noOfRows][noOfCols]);
    }

    private long travelGrid(int row, int col, int noOfRows, int noOfCols, long[][] memo) {
        if (row <= 0 || col <= 0) {
            return 0;
        }
        if (row == 1 && col == 1) {
            return 1;
        }
        if (memo[row - 1][col - 1] > 0) {
            return memo[row - 1][col - 1];
        }
        memo[row - 1][col - 1] = travelGrid(row - 1, col, noOfRows, noOfCols, memo) + travelGrid(row, col - 1, noOfRows, noOfCols, memo);
        return memo[row - 1][col - 1];
    }
}
