package com.coderscafe.sturdyeureka.core.dp.dpimpl;

import com.coderscafe.sturdyeureka.core.dp.GridTraveler;

public class GridTravelerBruteForce implements GridTraveler {

    @Override
    public long travelGrid(int row, int col, int noOfRows, int noOfCols) {
        if (row <= 0 || col <= 0) {
            return 0;
        }
        if (row == 1 && col == 1) {
            return 1;
        }
        return travelGrid(row - 1, col, noOfRows, noOfCols) + travelGrid(row, col - 1, noOfRows, noOfCols);
    }
}
