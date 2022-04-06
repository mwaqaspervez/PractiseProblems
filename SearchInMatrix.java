package com.demo.assessment.Problems;

/**
 * Given a matrix mat[][] of size N x M, where every row and column is sorted in increasing order,
 * and a number X is given. The task is to find whether element X is present in the matrix or not.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * N = 3, M = 3
 * mat[][] =
 * 3 30 38
 * 44 52 54
 * 57 60 69
 * X = 62
 * Output:
 * 0
 * Explanation:
 * 62 is not present in the
 * matrix, so output is 0
 * <p>
 * Example 2:
 * <p>
 * Input:
 * N = 1, M = 6
 * mat[][] = 18 21 27 38 55 67
 * X = 55
 * Output:
 * 1
 * Explanation:
 * 55 is present in the
 * matrix at 5th cell.
 */
public class SearchInMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                /*{3, 30, 38},
                {44, 52, 54},
                {57, 60, 69}*/
                {18, 21, 27, 38, 55, 67}
        };
        int value = 18;
        System.out.println(findInMatrix(matrix, value));
    }

    private static boolean findInMatrix(int[][] matrix, int value) {
        int i = 0;
        int j = matrix[i].length - 1;

        while (i < matrix.length && j >= 0) {
            int current = matrix[i][j];
            if (current == value) {
                return true;
            }

            if (current > value) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
