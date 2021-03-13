package com.coderscafe.sturdyeureka.core.unionfind;

import java.util.*;

public class AccountsMerge {

    public List<List<String>> mergeAccounts(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap<>();
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name.isEmpty()) {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                dsu.union(account.get(1), email);
            }
        }
        Map<String, List<String>> ans = new HashMap<>();
        for (String email : emailToName.keySet()) {
            ans.computeIfAbsent(dsu.find(email), x -> new ArrayList<>()).add(email);
        }
        for (List<String> component : ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList<>(ans.values());
    }
}

