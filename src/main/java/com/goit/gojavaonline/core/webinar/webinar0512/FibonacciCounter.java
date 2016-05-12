package com.goit.gojavaonline.core.webinar.webinar0512;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class FibonacciCounter {

    // fib(35)
    // fib(34)
    // fib(33)
    // fib(32)
    // ....
    // fib(0)



    private static int fib(int n) {
        int[] intermediateResults = new int[n+1];
        return fibDP(n, intermediateResults);
    }

    private static int fibDP(int n, int[] intermediateResults) {
        if(n<0) throw new IllegalArgumentException();
        if(n==0 || n==1) return 1;
        if(intermediateResults[n]!=0){
            return intermediateResults[n];
        } else{
            System.out.println("Counting fib("+n+")");
            int previous = fibDP(n - 1, intermediateResults);
            int prePrevious = fibDP(n - 2, intermediateResults);
            int result = previous+prePrevious;
            intermediateResults[n] = result;
            return result;
        }
    }

    public static void main(String[] args) {
        Instant startedTime = Instant.now();
        for (int i = 0; i < 50; i++) {
            System.out.println(i+": "+fib(i));
        }
//        System.out.println(fib(35));
        System.out.println("Time elapsed: "+ Duration.between(startedTime, Instant.now()));
    }
}
