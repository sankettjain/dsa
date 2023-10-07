package com.pratice.dsa.dynamic;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FibonacciSeries {

    static Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(fibonacciSeries(5,memo));
    }

    private static int fibonacciSeries(int n, Map<Integer, Integer> memo) {

        if (FibonacciSeries.memo.containsKey(n)) {
            return FibonacciSeries.memo.get(n);
        }
        if (n <= 1) {
            return n;
        }
        FibonacciSeries.memo.put(n, fibonacciSeries(n - 2, memo) + fibonacciSeries(n - 1, memo));
        return FibonacciSeries.memo.get(n);
    }
}
