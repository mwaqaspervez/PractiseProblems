package com.demo.assessment.Problems;

/**
 * Find the maximum element in an array which is first increasing and then decreasing
 * Difficulty Level : Easy
 * Last Updated : 21 Feb, 2022
 * Given an array of integers which is initially increasing and then decreasing, find the maximum value in the array.
 * Examples :
 * <p>
 * <p>
 * Input: arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}
 * Output: 500
 * <p>
 * Input: arr[] = {1, 3, 50, 10, 9, 7, 6}
 * Output: 50
 * <p>
 * Corner case (No decreasing part)
 * Input: arr[] = {10, 20, 30, 40, 50}
 * Output: 50
 * <p>
 * Corner case (No increasing part)
 * Input: arr[] = {120, 100, 80, 20, 0}
 * Output: 120
 */
public class FindMaximumInIncreasingDecreasing {

    public static void main(String[] args) {
        int[] array = new int[]{10, 20, 30, 40, 50};
        System.out.println(findDecreasing(array));
    }

    private static int findDecreasing(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = right - ((right - left) / 2);
            // base case
            if( right == left + 1 && array[left] >= array[right]) {
                return array[left];
            }

            if(right == left + 1 && array[right] >= array[left]) {
                return array[right];
            }

            if (array[mid] > array[mid + 1] && array[mid] > array[mid - 1]) {
                return array[mid];
            }

            if (array[mid] > array[mid + 1] && array[mid] < array[mid - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
