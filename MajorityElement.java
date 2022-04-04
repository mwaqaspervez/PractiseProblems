package com.demo.assessment.Problems;

/**
 * Given an array A of N elements. Find the majority element in the array.
 * A majority element in an array A of size N is an element that appears more than N/2 times in the array.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * N = 3
 * A[] = {1,2,3}
 * Output:
 * -1
 * Explanation:
 * Since, each element in
 * {1,2,3} appears only once so there
 * is no majority element.
 * <p>
 * Input:
 * N = 5
 * A[] = {3,1,3,3,2}
 * Output:
 * 3
 * Explanation:
 * Since, 3 is present more
 * than N/2 times, so it is
 * the majority element.
 */
public class MajorityElement {

    public static void main(String[] args) {

        int[] array = new int[]{3, 1, 1, 1, 1, 1, 3, 3, 2};
        System.out.println(findMajorityElement(array));
    }

    private static int findMajorityElement(int[] array) {
        int n = array.length;
        int count = 0;
        int candidate = -1;

        for (int k : array) {
            if (count == 0) {
                candidate = k;
                count = 1;
            } else {
                if (k == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        count = 0;
        for (int j : array) {
            if (candidate == j) {
                count++;
            }
        }
        return candidate > n / 2 ? candidate : -1;
    }
}
