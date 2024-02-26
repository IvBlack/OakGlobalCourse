package com.IVdev.Core2.functionalJavaByAmigos;

import org.w3c.dom.ls.LSOutput;

import java.util.function.Function;


/*
Function<T,R>
Represents a function that accepts one argument and produces a result.
*/
public class _Function {
    public static void main(String[] args) {
        System.out.println(increment(0));
        System.out.println(incrementByOneFunction.apply(55));

        //Returns a composed function that first applies this function to its input, and then applies the after function to the result
        System.out.println(sqrtFunc.andThen(cubeFunc).apply(2));
        System.out.println(cubeFunc.andThen(sqrtFunc).apply(5));

        //Returns a composed function that first applies the before function to its input, and then applies this function to the result
        System.out.println(sqrtFunc.compose(cubeFunc).apply(6));
    }

    //this takes one input and have one output
    static int increment(int number) {
        return number + 1;
    }

    //the same? but more functional and laconic form with Function interface will be...
    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;


    //---------------------------------------------------------------------
    static Function<Integer, Integer> sqrtFunc = x -> x * x;
    static Function<Integer, Integer> cubeFunc = x -> x * x * x;
}
