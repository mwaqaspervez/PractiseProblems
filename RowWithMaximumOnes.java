package com.demo.assessment.Problems;

/**
 * Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.
 * <p>
 * Example:
 * <p>
 * Input matrix
 * 0 1 1 1
 * 0 0 1 1
 * 1 1 1 1  // this row has maximum 1s
 * 0 0 0 0
 * <p>
 * Output: 2
 */
public class RowWithMaximumOnes {

    public static void main(String[] args) {

        int[][] array = new int[][]{
                {0, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 1},  {0, 0, 0, 0}
        };
        System.out.println(findMax(array));
    }

    private static int findMax(int[][] array) {
        int result = -1;
        int maximum = -1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int current = array[i][j];
                if (current == 1) {
                    int ones = array[j].length - j;
                    if (ones > maximum) {
                        maximum = ones;
                        result = i + 1;
                        break;
                    }
                }
            }
        }

        return result;
    }
}
