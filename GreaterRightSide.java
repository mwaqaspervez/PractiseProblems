package com.demo.assessment.Problems;

import java.util.Arrays;

/**
 * Greater on right side
 * Basic Accuracy: 73.45% Submissions: 6106 Points: 1
 * You are given an array Arr of size N. Replace every element with the next greatest element
 * (greatest element on its right side) in the array. Also, since there is no element next to the last element,
 * replace it with -1.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * N = 6
 * Arr[] = {16, 17, 4, 3, 5, 2}
 * Output:
 * 17 5 5 5 2 -1
 * Explanation: For 16 the greatest element
 * on its right is 17. For 17 it's 5.
 * For 4 it's 5. For 3 it's 5. For 5 it's 2.
 * For 2 it's -1(no element to its right).
 * So the answer is 17 5 5 5 2 -1
 */
public class GreaterRightSide {

    public static void main(String[] args) {
        int[] array = new int[]{16, 17, 4, 3, 5, 2};
        System.out.println(Arrays.toString(shiftRight(array)));
    }

    private static int [] shiftRight(int[] array) {
        int n = array.length;
        int max = array[n - 1];
        // set the last element to --1
        array[n - 1] = -1;
        // reverse loop to get the maximum;
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] >= max) {
                max = array[i];
            } else {
                array[i] = max;
            }
        }
        return Arrays.copyOfRange(array, 1, array.length);
    }
}
