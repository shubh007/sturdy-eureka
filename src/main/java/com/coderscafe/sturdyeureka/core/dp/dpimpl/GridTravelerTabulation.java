package com.coderscafe.sturdyeureka.core.dp.dpimpl;

import com.coderscafe.sturdyeureka.constant.enums.DpApproachType;
import com.coderscafe.sturdyeureka.core.dp.GridTraveler;

public class GridTravelerTabulation extends GridTraveler {

    public GridTravelerTabulation() {
        dpApproachType = DpApproachType.TABULATION;
    }

    @Override
    public long travelGrid(int rows, int cols) {
        long[][] grid = new long[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0 || col == 0) {
                    grid[row][col] = 1;
                } else {
                    grid[row][col] = grid[row - 1][col] + grid[row][col - 1];
                }
            }
        }
        return grid[rows - 1][cols - 1];
    }
}
