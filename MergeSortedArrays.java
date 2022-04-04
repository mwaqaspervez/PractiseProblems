package com.demo.assessment.Problems;

import java.util.Arrays;

/**
 * Merge two sorted arrays with O(1) extra space
 * Difficulty Level : Medium
 * Last Updated : 13 Mar, 2022
 * We are given two sorted arrays. We need to merge these two arrays such that the initial
 * numbers (after complete sorting) are in the first array and the remaining numbers are in the second array.
 * Extra space allowed in O(1).
 * <p>
 * Example:
 * <p>
 * <p>
 * <p>
 * Input: ar1[] = {10};
 * ar2[] = {2, 3};
 * Output: ar1[] = {2}
 * ar2[] = {3, 10}
 * <p>
 * Input: ar1[] = {1, 5, 9, 10, 15, 20};
 * ar2[] = {2, 3, 8, 13};
 * Output: ar1[] = {1, 2, 3, 5, 8, 9}
 * ar2[] = {10, 13, 15, 20}
 */
public class MergeSortedArrays {

    public static void main(String[] args) {

        int[] array1 = new int[]{1, 5, 9, 10, 15, 20};
        int[] array2 = new int[]{2, 3, 8, 13};
        mergeArrays(array1, array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    private static void mergeArrays(int[] array1, int[] array2) {

        int i = 0, j = 0, n = array1.length - 1;
        // traverse until we reach at the end of second array.
        while(j < array2.length) {
            if(array1[i] > array2[j]) {
                int temp = array1[i];
                array1[i] = array2[j];
                array2[j] = temp;
            }
            i++;
            if(i > n) {
                j++;
                i = 0;
            }
        }
        Arrays.sort(array2);
    }
}
