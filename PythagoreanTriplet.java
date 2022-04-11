package com.demo.assessment.Problems;

import java.util.Arrays;

public class PythagoreanTriplet {

    /**
     * Given an array of integers, write a function that returns true if there is a triplet (a, b, c)
     * that satisfies a2 + b2 = c2.
     * <p>
     * Example:
     * Input: arr[] = {3, 1, 4, 6, 5}
     * Output: True
     * There is a Pythagorean triplet (3, 4, 5).
     * <p>
     * Input: arr[] = {10, 4, 6, 12, 5}
     * Output: False
     * There is no Pythagorean triplet.
     */
    public static void main(String[] args) {

        int[] array = new int[]{1, 3, 4, 5, 6};
        boolean isTriplet = isPythagoreanTriplet(array);
        System.out.println(isTriplet);
    }

  /*  private static boolean isPythagoreanTriplet(int[] array) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            int sumOfSquares = (array[i] * array[i]) + (array[i + 1] * array[i + 1]);
            int result = array[i + 2] * array[i + 2];
            if (sumOfSquares == result) {
                return true;
            }
        }
        return false;
    }*/

    private static boolean isPythagoreanTriplet(int[] array) {

        // Store the square of the value in the array
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i];
        }
        Arrays.sort(array);
        int n = array.length;

        // for every value in the array starting for greatest value
        // see if right and left = c2
        for (int i = n - 1; i >= 1; i--) {
            int left = 0;
            int right = array.length - 1;
            while (left < right) {
                System.out.println("left = " + array[left] + " right = " + array[right] + "  i = " + array[i]);
                if (array[left] + array[right] == array[i]) {
                    return true;
                }
                if (array[right] >= array[i]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return false;
    }
}
