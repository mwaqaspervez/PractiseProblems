package com.demo.assessment.Problems;

/**
 * 11. Container With Most Water
 * Medium
 * <p>
 * 16597
 * <p>
 * 940
 * <p>
 * Add to List
 * <p>
 * Share
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container,
 * such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 * <p>
 * Input: height = [1,1]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class MaxHeight {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    // This is calculated by getting the area which is defined as
    // area = width * height
    // Width = ( right - left)
    // height = min of (right || left) , taking min otherwise it will overflow
    // move the pointer of the value which is lower.
    public static int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left <= right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(area, max);

            if(height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return max;
    }
}
