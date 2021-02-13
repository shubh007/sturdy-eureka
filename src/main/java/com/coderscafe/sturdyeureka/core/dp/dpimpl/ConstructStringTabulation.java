package com.coderscafe.sturdyeureka.core.dp.dpimpl;

import com.coderscafe.sturdyeureka.constant.enums.DpApproachType;
import com.coderscafe.sturdyeureka.core.dp.ConstructString;

import java.util.List;

public class ConstructStringTabulation extends ConstructString {

    public ConstructStringTabulation() {
        dpApproachType = DpApproachType.TABULATION;
    }

    @Override
    public boolean canConstruct(List<String> availableString, String targetString) {
        return false;
    }

    @Override
    public int countConstruct(List<String> availableString, String targetString) {
        return 0;
    }

    @Override
    public List<List<String>> allConstruct(List<String> availableString, String targetString) {
        return null;
    }
}
