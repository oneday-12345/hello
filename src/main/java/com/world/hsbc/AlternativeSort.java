package com.world.hsbc;


import java.util.Arrays;
import java.util.stream.IntStream;

public class AlternativeSort {

    public int[] alternativeSort(int[] arr) {
        Arrays.sort(arr);
        return IntStream
                .range(0, arr.length)
                .filter(n -> n % 2 == 0)
                .map(i -> arr[i])
                .toArray();
    }

    public void test_AlternativeSort_alternativeSort() {
        int[] arr = { 3, 5, 1, 5, 9, 10, 2, 6 };
        int[] result = alternativeSort(arr);
        Arrays
                .stream(result)
                .forEach(n -> System.out.println(n));
    }

    public static  void test_main_AlternativeSort() {
        AlternativeSort alternativeSort = new AlternativeSort();
        alternativeSort.test_AlternativeSort_alternativeSort();
    }

}
