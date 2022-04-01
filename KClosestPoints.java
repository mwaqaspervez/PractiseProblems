package com.demo.assessment.Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 * <p>
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 * <p>
 * Example 1:
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 */
public class KClosestPoints {

    public static void main(String[] args) {

        int[][] points = new int[][]{
                {1, 3}, {-2, -2}
        };
        int k = 1;

        int[][] result = getKClosest(points, k);
        for (int[] ints : result) {
            System.out.println(ints[0] + "," + ints[1]);
        }
    }

    private static int[][] getKClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        List<Distance> distances = new ArrayList<>();

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
            distances.add(new Distance(distance, x, y));
        }
        Collections.sort(distances);
        for (int i = 0; i < k; i++) {
            result[i][0] = distances.get(i).x;
            result[i][1] = distances.get(i).y;
        }
        return result;
    }

    public static class Distance implements Comparable<Distance> {
        public double distance;
        public int x;
        public int y;

        public Distance(double distance, int x, int y) {
            this.distance = distance;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Distance distance) {
            if (this.distance > distance.distance) {
                return 1;
            } else if (this.distance == distance.distance) {
                return 0;
            }
            return -1;
        }
    }
}
