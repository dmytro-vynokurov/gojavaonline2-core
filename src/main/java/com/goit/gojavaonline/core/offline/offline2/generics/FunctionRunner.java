package com.goit.gojavaonline.core.offline.offline2.generics;

import java.util.function.Function;

class MyFunction implements Function<Integer, Integer> {

    private int constantMultiplier;

    public MyFunction(int constantMultiplier) {
        this.constantMultiplier = constantMultiplier;
    }

    @Override
    public Integer apply(Integer x) {
        return x * 6 * constantMultiplier;
    }
}

public class FunctionRunner {
    public static void main(String[] args) {
        int constantMultiplier = 2;
        Function<Integer, Integer> fiveAdder =
                x -> x + 5;
        Function<Integer, Integer> sixMultiplier =
                x -> x * 6 * constantMultiplier;


        Function<Integer, Integer> adder = new MyFunction(constantMultiplier);

        System.out.println(compute(67, fiveAdder));
        System.out.println(compute(67, sixMultiplier));

    }

    private static <T, R extends Number> R compute(T input,
                                                   Function<? super T, ? extends R> computer) {
        System.out.println("Received value: " + input);
        R computationResult = computer.apply(input);
        System.out.println("Computation result: " + computationResult);
        return computationResult;
    }
}
