package com.goit.gojavaonline.core.codegym.setbit;

public class SetZero {
    public int set(int num, int index) {
        char[] maskArray = new char[32];
        for(int i=0;i<32;i++){
            if(i==32-index) maskArray[i]='0';
            else maskArray[i]='1';
        }
        String maskString = new String(maskArray);
        Long mask = Long.parseLong(maskString,2);
        return num & mask.intValue();

    }
}
