package com.demo.assessment.Problems;

public class JumpGame1 {

    /**
     * You are given an integer array nums. You are initially positioned at the array's first index,
     * and each element in the array represents your maximum jump length at that position.
     * <p>
     * Return true if you can reach the last index, or false otherwise.
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [2,3,1,1,4]
     * Output: true
     * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Example 2:
     * <p>
     * Input: nums = [3,2,1,0,4]
     * Output: false
     * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
     **/
    public static void main(String[] args) {
        int[] nums = new int[]{3,2, 1, 0, 4};
        System.out.println(canJump(nums));
    }

    private static boolean canJump(int[] nums) {

        int lastPosition = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }
}
