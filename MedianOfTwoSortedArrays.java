package com.demo.assessment.Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Median of Two Sorted Arrays
 * Hard
 * <p>
 * 16151
 * <p>
 * 1981
 * <p>
 * Add to List
 * <p>
 * Share
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] arr1 = new int[]{1};
        int[] arr2 = new int[]{};
        System.out.println(getMedian(arr1, arr2));
    }

    private static double getMedian(int[] arr1, int[] arr2) {
        int first = 0;
        int second = 0;
        List<Integer> list = new ArrayList<>();
        while (first < arr1.length || second < arr2.length) {
            if (first < arr1.length && (second < arr2.length && arr1[first] < arr2[second])) {
                list.add(arr1[first]);
                first++;
            } else {
                list.add(arr2[second]);
                second++;
            }
        }
        double result;
        if (list.size() % 2 == 0) {
            result = (double) ((list.get(list.size() / 2) - 1)
                    + list.get(list.size() / 2)) / 2;
        } else {
            result = list.get(list.size() / 2);
        }
        return result;
    }
}
