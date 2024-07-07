package org.anton.hexlet.module2.functions;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//**************************************************************************************************************|
//                                                   Memoization                                                |
//______________________________________________________________________________________________________________|
//                                             My Solution same as Hexlet                                       |
public class Fibonacci {
    private static final Map<Long, Long> fibonacci = new ConcurrentHashMap<>();

    public static long fib(long n) {
        if (n == 1) {
            return 0L;
        } else if (n == 2) {
            return 1L;
        }
        long result = 0L;
        if (fibonacci.containsKey(n)) return fibonacci.get(n);
        else {
            result = fib(n - 1) + fib(n - 2);
            fibonacci.putIfAbsent(n, result);
        }
        return result;
    }
}
//______________________________________________________________________________________________________________|
//                                              Hexlet Solution                                                 |
/*
public class Fibonacci {
    private static Map<Long, Long> cache = new ConcurrentHashMap<>();

    public static long fib(long n) {
        return cache.computeIfAbsent(n, num -> {
            if (n == 1) {
                return 0L;
            } else if (n == 2) {
                return 1L;
            }
            return fib(n - 1) + fib(n - 2);
        });
    }
}
 */
