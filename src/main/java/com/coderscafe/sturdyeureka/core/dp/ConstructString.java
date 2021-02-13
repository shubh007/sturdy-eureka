package com.coderscafe.sturdyeureka.core.dp;


import com.coderscafe.sturdyeureka.constant.enums.DpApproachType;

import java.util.List;

public abstract class ConstructString {

    public DpApproachType dpApproachType;

    public abstract boolean canConstruct(List<String> availableString, String targetString);

    public abstract int countConstruct(List<String> availableString, String targetString);

    public abstract List<List<String>> allConstruct(List<String> availableString, String targetString);
}
