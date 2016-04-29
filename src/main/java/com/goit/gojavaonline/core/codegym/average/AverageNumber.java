package com.goit.gojavaonline.core.codegym.average;

public class AverageNumber {
    public int average(int a, int b) {
        int ha = a%2;
        int hb = b%2;
        int o=0;
        if(ha*hb==1 && sgn(a)==sgn(b)) o=1;
        return a/2+b/2+sgn(a)*o;
    }

    public int sgn(int n){
        if(n>0) return 1;
        if(n<0) return -1;
        return 0;
    }
}
