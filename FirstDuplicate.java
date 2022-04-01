package com.demo.assessment.Problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the first duplicate value in an array
 */
public class FirstDuplicate {

    public static void main(String[] args) {

        int[] array = new int[]{5, 2, 3, 1, 0, 5, 1, 7};
        System.out.println(findDuplicate(array));
    }

    private static int findDuplicate(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                return array[i];
            } else {
                set.add(array[i]);
            }
        }
        return -1;
    }
}
