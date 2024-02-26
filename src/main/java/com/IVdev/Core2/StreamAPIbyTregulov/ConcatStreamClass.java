package com.IVdev.Core2.StreamAPIbyTregulov;

import java.util.stream.Stream;

public class ConcatStreamClass {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(2,8,4,6,15,47);
        Stream<Integer> stream2 = Stream.of(-2,7,75,15,64,1);
        Stream<Integer> stream3 = Stream.concat(stream2, stream1);
        stream3.forEach(System.out::println);
    }
}
