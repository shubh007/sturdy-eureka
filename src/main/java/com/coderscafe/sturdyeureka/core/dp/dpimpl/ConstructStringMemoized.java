package com.coderscafe.sturdyeureka.core.dp.dpimpl;

import com.coderscafe.sturdyeureka.core.dp.ConstructString;

import java.util.*;

public class ConstructStringMemoized implements ConstructString {

    @Override
    public boolean canConstruct(List<String> availableString, String targetString) {
        return canConstruct(availableString,targetString,new HashMap<>());
    }

    @Override
    public int countConstruct(List<String> availableString, String targetString) {
        return countConstruct(availableString,targetString,new HashMap<>());
    }

    @Override
    public List<List<String>> allConstruct(List<String> availableString, String targetString) {
        return allConstruct(availableString,targetString,new HashMap<>());
    }

    private boolean canConstruct(List<String> availableString, String targetString,Map<String,Boolean> memo) {
        if(memo.containsKey(targetString)){
            return memo.get(targetString);
        }
        if(targetString.equals("")){
            return true;
        }
        for (String prefix:availableString){
            if(targetString.startsWith(prefix) && canConstruct(availableString,targetString.substring(prefix.length()),memo)){
                memo.put(targetString,true);
                return true;
            }
        }
        memo.put(targetString,false);
        return false;
    }

    private int countConstruct(List<String> availableString, String targetString,Map<String,Integer> memo) {
        if(memo.containsKey(targetString)){
            return memo.get(targetString);
        }
        if(targetString.equals("")){
            return 1;
        }
        int count = 0 ;
        for(String prefix:availableString){
            if(targetString.startsWith(prefix)){
                count += countConstruct(availableString,targetString.substring(prefix.length()),memo);
            }
        }
        memo.put(targetString,count);
        return count;
    }

    private List<List<String>> allConstruct(List<String> availableString, String targetString, Map<String,List<List<String>>> memo) {
        if(memo.containsKey(targetString)){
            return memo.get(targetString);
        }
        if(targetString.equals("")){
            return Collections.singletonList(new ArrayList<>());
        }
        List<List<String>> result = new ArrayList<>();
        for(String prefix:availableString){
            if(targetString.startsWith(prefix)){
                List<List<String>> currResult = allConstruct(availableString,targetString.substring(prefix.length()),memo);
                for (List<String> construct:currResult){
                    List<String> tempConstruct = new ArrayList<>(construct);
                    tempConstruct.add(prefix);
                    result.add(tempConstruct);
                }
            }
        }
        memo.put(targetString,result);
        return result;
    }
}
