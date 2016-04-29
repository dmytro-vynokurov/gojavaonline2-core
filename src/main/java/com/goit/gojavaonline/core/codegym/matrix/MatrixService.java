package com.goit.gojavaonline.core.codegym.matrix;

public class MatrixService {
    public int[] print(int[][] input) {
        if(input.length==0 || input[0].length==0) return new int[]{};
        int[] result = new int[input.length*input[0].length];
        int k = 0;

        int i=0;
        int j=0;
        int di=0;
        int dj=1;
        int fi=0;
        int li=input.length-1;
        int fj=0;
        int lj=input[0].length-1;
        while(fi<li || fj<lj){
            while(i>=fi && i<=li && j>=fj && j<=lj){
                result[k] = input[i][j];
                k++;
                i+=di;
                j+=dj;
            }
            if(i>li){
                i--;
                j--;
                di=0;
                dj=-1;
                lj--;
            }
            if(i<fi){
                i++;
                j++;
                di=0;
                dj=1;
                fj++;
            }
            if(j>lj){
                j--;
                i++;
                di=1;
                dj=0;
                fi++;
            }
            if(j<fj){
                j++;
                i--;
                di=-1;
                dj=0;
                li--;
            }
        }
        if(k<result.length) result[k] = input[fi][fj];
        return result;
    }
}
