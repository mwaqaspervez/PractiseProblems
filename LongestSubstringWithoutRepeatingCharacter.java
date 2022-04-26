package com.demo.assessment.Problems;

import java.util.HashSet;

/**
 * 3. Longest Substring Without Repeating Characters
 * Medium
 *
 * 23177
 *
 * 1042
 *
 * Add to List
 *
 * Share
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String input = "abcabcbb";

        System.out.println(getLongest(input));
    }

    // Use slow and fast pointer approach
    // start with 0, 0 and increase j until a character
    // that already exists is found, then increase i
    private static int getLongest(String input) {
        if (input.length() == 0) return 0;
        int i = 0, j = 0, max = 0;
        HashSet<Character> set = new HashSet<>();
        while (j < input.length()) {
            if (!set.contains(input.charAt(j))) {
                set.add(input.charAt(j));
                j++;
                max = Math.max(max, set.size());
            } else {
                set.remove(input.charAt(i));
                i++;
            }
        }
        return max;
    }
}
