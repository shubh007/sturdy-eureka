package com.coderscafe.sturdyeureka.core.dp.dpimpl;

import com.coderscafe.sturdyeureka.constant.enums.DpApproachType;
import com.coderscafe.sturdyeureka.core.dp.ConstructString;

import java.util.ArrayList;
import java.util.List;

public class ConstructStringTabulation extends ConstructString {

    public ConstructStringTabulation() {
        dpApproachType = DpApproachType.TABULATION;
    }

    @Override
    public boolean canConstruct(List<String> availableString, String targetString) {
        int len = targetString.length();
        boolean[] isPossible = new boolean[len+1];
        isPossible[0] = true;
        for (int currLen = 0 ; currLen <= len ; currLen++){
            if(isPossible[currLen]){
                for(String word : availableString){
                    if(targetString.startsWith(word,currLen)){
                        int index = currLen+word.length();
                        if(index == len){
                            return true;
                        }
                        isPossible[index] = true;
                    }
                }
            }
        }
        return isPossible[targetString.length()];
    }

    @Override
    public int countConstruct(List<String> availableString, String targetString) {
        int len = targetString.length();
        int[] countWays = new int[len+1];
        countWays[0] = 1;
        for (int currLen = 0 ; currLen <= len ; currLen++){
            if(countWays[currLen] > 0){
                for(String word:availableString){
                    if(targetString.startsWith(word,currLen)){
                        countWays[currLen+word.length()] += countWays[currLen];
                    }
                }
            }
        }
        return countWays[targetString.length()];
    }

    @Override
    public List<List<String>> allConstruct(List<String> availableString, String targetString) {
        int len = targetString.length();
        List<List<List<String>>> constructs = new ArrayList<>();
        for (int index = 0 ; index <= len ; index++){
            constructs.add(new ArrayList<>());
        }
        constructs.get(0).add(new ArrayList<>());
        for (int currLen = 0 ; currLen <= len ; currLen++){
            if(!constructs.get(currLen).isEmpty()){
                List<List<String>> currConst = constructs.get(currLen);
                for(String word:availableString){
                    if(targetString.startsWith(word,currLen)){
                        List<List<String>> newConst = constructs.get(currLen+word.length());
                        for (List<String> temp : currConst){
                            List<String> tempL = new ArrayList<>(temp);
                            tempL.add(word);
                            newConst.add(tempL);
                        }
                        constructs.set(currLen+word.length(),newConst);
                    }
                }
            }
        }
        return constructs.get(len);
    }
}
