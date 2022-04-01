package com.demo.assessment.Problems;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the
 * longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 * <p>
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 * <p>
 * Input: s = ""
 * Output: 0
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        String input = ")))()()";
        System.out.println(getLongestCount(input));
    }

    private static int getLongestCount(String input) {
        Stack<Integer> stack = new Stack<>();
        int longest = 0;
        stack.push(-1);
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.empty()) {
                    stack.push(i);
                } else {
                    longest = Math.max(longest, i - stack.peek());
                }
            }
        }
        return longest;
    }
}
