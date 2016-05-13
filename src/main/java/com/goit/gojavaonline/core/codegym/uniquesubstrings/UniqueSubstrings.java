package com.goit.gojavaonline.core.codegym.uniquesubstrings;

import java.util.List;
import java.util.ArrayList;

public class UniqueSubstrings {
    public int count(String input) {
        List<String> subs = getAllSubStrings(input);
        int counter=0;
        for(String sub: subs){
            if(!substringRepeats(input,sub)) counter++;
        }

        return counter;
    }

    public boolean substringRepeats(String input, String sub){
        int si = input.indexOf(sub);
        int ei = si+sub.length();
        String sec = input.substring(ei);
        return sec.contains(sub);
    }

    public List<String> getAllSubStrings(String input){
        List<String> substrings = new ArrayList<>();
        for(int i=2; i<= input.length(); i++){
            for(int j=0; j<input.length()-i+1; j++){
                substrings.add(input.substring(j,j+i));
            }
        }
        return substrings;
    }
}