package com.codegym.math;

public final class Example {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java -cp quadratic-lib-1.0.0.jar com.codegym.math.Example a b c");
            return;
        }
        var result = QuadraticEquation.solve(Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        System.out.println(result.kind() + " " + result.roots());
    }
}
