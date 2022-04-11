package com.demo.assessment.Problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary grid of order r * c and an initial position.
 * The task is to find the minimum distance from the source to get to the
 * any corner of the grid.
 * A move can be made to a cell grid[i][j] only if grid[i][j] = 0
 * and only left, right, up and down movements are permitted.
 * If no valid path exists then print -1.
 * Examples:
 * <p>
 * <p>
 * Input: i = 1, j = 1, grid[][] = {{0, 0, 1}, {0, 0, 0}, {1, 1, 1}}
 * Output: 2
 * (1, 1) -> (1, 0) -> (0, 0)
 * <p>
 * <p>
 * Input: i = 0, j = 0, grid[][] = {{0, 1}, {1, 1}}
 * Output: 0
 * Source is already a corner of the grid.
 */
public class MinDistanceFromCorner {

    public static void main(String[] args) {

        int sourceRow = 3, sourceCol = 3;
        int[][] grid = new int[][]{
                {0, 1, 1, 0, 1},
                {0, 0, 1, 0, 1},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 0, 0, 1}};

        System.out.println(minDistance(grid, new Pair(sourceRow, sourceCol)));
    }

    // Corners of a grid will be  (0,0)  (0, column - 1), (row - 1,0), (column - 1, row - 1)
    public static boolean minDistance(int[][] grid, Pair position) {
        int x = position.first;
        int y = position.second;
        int m = grid.length;
        // Check if the current position is already on the edge
        if ((x == 0 && y == 0) || (x == 0 && y == m - 1) || (x == m - 1 && y == 0)
                || (x == m - 1 && y == m - 1)) {
            return true;
        }

        int[][] distances = new int[m + 1][m + 1];
        boolean[][] isVisited = new boolean[m + 1][m + 1];
        for (int[] distance : distances) {
            Arrays.fill(distance, Integer.MAX_VALUE);
        }
        distances[x][y] = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(position);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            // check left
            if (isValid(grid, isVisited, current.first, current.second - 1)) {
                queue.add(new Pair(current.first, current.second - 1));
                distances[current.first][current.second - 1] = Math.min(
                        distances[current.first][current.second - 1],
                        distances[current.first][current.second] + 1
                );
                isVisited[current.first][current.second - 1] = true;
            }

            // check top
            if (isValid(grid, isVisited, current.first - 1, current.second)) {
                queue.add(new Pair(current.first - 1, current.second));
                distances[current.first - 1][current.second] = Math.min(
                        distances[current.first - 1][current.second],
                        distances[current.first][current.second] + 1
                );
                isVisited[current.first - 1][current.second] = true;
            }

            // check right
            if (isValid(grid, isVisited, current.first, current.second + 1)) {
                queue.add(new Pair(current.first, current.second + 1));
                distances[current.first][current.second + 1] = Math.min(
                        distances[current.first][current.second + 1],
                        distances[current.first][current.second] + 1
                );
                isVisited[current.first][current.second + 1] = true;
            }

            // check down
            if (isValid(grid, isVisited, current.first + 1, current.second)) {
                queue.add(new Pair(current.first + 1, current.second));
                distances[current.first + 1][current.second] = Math.min(
                        distances[current.first + 1][current.second],
                        distances[current.first][current.second] + 1
                );
                isVisited[current.first + 1][current.second] = true;
            }
        }


        int distance = Math.min(distances[0][0], distances[0][m - 1]);
        System.out.println(distance);
        distance = Math.min(distance, distances[m - 1][0]);
        System.out.println(distance);
        distance = Math.min(distance, distances[m - 1][m - 1]);
        System.out.println(distance);

        return distance != Integer.MAX_VALUE;
    }

    private static boolean isValid(int[][] grid, boolean[][] isVisited, int first, int second) {
        int size = grid.length;

        if (first < 0 || second < 0 || first >= size || second >= size ||
                grid[first][second] == 1 || isVisited[first][second]) {
            return false;
        }
        return true;
    }

    public static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
