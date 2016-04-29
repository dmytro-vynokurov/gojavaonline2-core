package com.goit.gojavaonline.core.codegym.bitpalyndrome;

public class BitsPalindrome {
    public boolean isPalindrome(int input) {
        String s = Integer.toBinaryString(input);
        for(int i=0; i<s.length()/2; i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
        }
        return true;

    }

    public static void main(String[] args) {
        int i = Integer.parseInt("1000000000000000000000000000001", 2);
        System.out.println(i);
    }
}

