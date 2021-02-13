package com.coderscafe.sturdyeureka.core.dp;


import com.coderscafe.sturdyeureka.constant.enums.DpApproachType;

public abstract class GridTraveler {
    public DpApproachType dpApproachType;

    public abstract long travelGrid(int rows, int cols);
}
