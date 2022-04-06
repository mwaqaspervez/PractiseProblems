package com.demo.assessment.Problems;

import java.util.*;

/**
 * Given k sorted arrays of size n each, merge them and print the sorted output.
 * <p>
 * Example:
 * Input:
 * k = 3, n = 4
 * arr[][] = { {1, 3, 5, 7},
 * {2, 4, 6, 8},
 * {0, 9, 10, 11}} ;
 * Output: 0 1 2 3 4 5 6 7 8 9 10 11
 * Explanation: The output array is a sorted array that contains all the elements of the input matrix.
 * <p>
 * Input:
 * k = 4, n = 4
 * arr[][] = { {1, 5, 6, 8},
 * {2, 4, 10, 12},
 * {3, 7, 9, 11},
 * {13, 14, 15, 16}} ;
 * Output: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * Explanation: The output array is a sorted array that contains all the elements of the input matrix.
 */
public class MergeKArrays {

    public static void main(String[] args) {
        int[][] arrays = new int[][]{
                {1, 5, 6, 8},
                {2, 4, 18, 12, 45},
                {3, 7, 9, 11},
                {13, 14, 15, 16}
        };

        System.out.println(mergeArrays(arrays));
    }

    private static List<Integer> mergeArrays(int[][] arrays) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.value == o2.value) {
                return 0;
            }
            return o1.value > o2.value ? 1 : -1;
        });
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrays.length; i++) {
            queue.add(new Pair(arrays[i][0], i, 0));
        }

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int value = pair.value;
            int i = pair.x;
            int j = pair.y;

            result.add(value);

            if (j + 1 < arrays[i].length) {
                queue.add(new Pair(arrays[i][j + 1], i, j + 1));
            }
        }

        return result;
    }

    private static class Pair {
        int value;
        int x, y;

        public Pair(int value, int x, int y) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
