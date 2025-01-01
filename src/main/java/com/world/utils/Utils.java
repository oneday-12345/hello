package com.world.utils;

public class Utils {

    public static <E extends Comparable<E>> E max(E... args) {
        E max = args[0];
        for (int i = 1; i < args.length; ++i) {
            E elem = args[i];
            if (max.compareTo(elem) < 0) {
                max = elem;
            }
        }
        return max;
    }

    public static <E extends Comparable<E>> E min(E... args) {
        E min = args[0];
        for (int i = 1; i < args.length; ++i) {
            E elem = args[i];
            if (min.compareTo(elem) > 0) {
                min = elem;
            }
        }
        return min;
    }

}
