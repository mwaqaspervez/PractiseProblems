package com.demo.assessment.Problems;

/**
 * Given two strings A and B, find if A is a subsequence of B.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * A = AXY
 * B = YADXCP
 * Output: 0
 * Explanation: A is not a subsequence of B
 * as 'Y' appears before 'A'.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input:
 * A = gksrek
 * B = geeksforgeeks
 * Output: 1
 * Explanation: A is a subsequence of B.
 */
public class StringWithSubsequence {

    public static void main(String[] args) {
        String second = "AXY";
        String first = "YADXCP";

        System.out.println(isSubsequence(first, second));
    }

    private static boolean isSubsequence(String first, String second) {

        int i = 0;
        for (char current : first.toCharArray()) {
            if (second.charAt(i) == current) {
                i++;
                if (i == second.length()) return true;
            }
        }
        return false;
    }
}
