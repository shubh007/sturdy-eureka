package com.coderscafe.sturdyeureka.core.dp;

import java.util.List;

public interface ConstructString {
    boolean canConstruct(List<String> availableString, String targetString);
    int countConstruct(List<String> availableString, String targetString);
    List<List<String>> allConstruct(List<String> availableString, String targetString);
}
