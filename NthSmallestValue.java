package com.demo.assessment.Problems;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Find m-th smallest value in k sorted arrays
 * Difficulty Level : Hard
 * Last Updated : 25 May, 2021
 * Given k sorted arrays of possibly different sizes, find m-th smallest value in the merged array.
 * Examples:
 * <p>
 * <p>
 * Input: m = 5
 * arr[][] = { {1, 3},
 * {2, 4, 6},
 * {0, 9, 10, 11}} ;
 * Output: 4
 * Explanation The merged array would
 * be {0 1 2 3 4 6 9 10 11}.  The 5-th
 * smallest element in this merged
 * array is 4.
 * <p>
 * Input: m = 2
 * arr[][] = { {1, 3, 20},
 * {2, 4, 6}} ;
 * Explanation The merged array would
 * be {1 2 3 4 6 20}. The 2nd smallest element would be 2.
 * Output: 2
 */
public class NthSmallestValue {

    public static void main(String[] args) {

        int[][] array = new int[][]{{1, 3, 5}, {2, 4, 6}, {0, 9, 10, 11}};
        int k = 6;
        System.out.println(getNthSmallest(array, k));
    }

    private static int getNthSmallest(int[][] array, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int top = queue.size() == 0 ? Integer.MIN_VALUE : queue.peek();
                if (top > array[i][j] && queue.size() >= k) {
                    queue.poll();
                    queue.add(array[i][j]);
                }
                if (queue.size() < k) {
                    queue.add(array[i][j]);
                }
            }
        }
        return queue.poll();
    }
}
