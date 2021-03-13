package com.coderscafe.sturdyeureka.core.unionfind;

import java.util.HashMap;
import java.util.Map;

public class DSU {

    private final Map<String, String> parentChildMap;

    public DSU() {
        parentChildMap = new HashMap<>();
    }

    public String find(String email) {
        parentChildMap.putIfAbsent(email, email);
        if (!parentChildMap.get(email).equals(email)) {
            return find(parentChildMap.get(email));
        }
        return email;
    }

    public void union(String emailOne, String emailTwo) {
        parentChildMap.put(find(emailOne), find(emailTwo));
    }
}
