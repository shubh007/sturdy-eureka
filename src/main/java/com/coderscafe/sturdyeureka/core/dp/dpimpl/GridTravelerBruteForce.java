package com.coderscafe.sturdyeureka.core.dp.dpimpl;

import com.coderscafe.sturdyeureka.constant.enums.DpApproachType;
import com.coderscafe.sturdyeureka.core.dp.GridTraveler;

public class GridTravelerBruteForce extends GridTraveler {

    public GridTravelerBruteForce() {
        dpApproachType = DpApproachType.BRUTEFORCE;
    }

    @Override
    public long travelGrid(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            return 0;
        }
        if (rows == 1 && cols == 1) {
            return 1;
        }
        return travelGrid(rows - 1, cols) + travelGrid(rows, cols - 1);
    }
}
