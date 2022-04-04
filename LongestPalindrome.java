package com.demo.assessment.Problems;

/**
 * Find the longest palindrome in a string
 * <p>
 * example
 * <p>
 * 'abracecar' -> racecar
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String input = "bdaadx";
 // a
        System.out.println(longestPalindrome(input));
    }

    private static String longestPalindrome(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            // get the odd length
            String first = getPalindromeLength(input, i, i);
            // get the even length
            String second = getPalindromeLength(input, i, i + 1);
            System.out.println("First =  " + first + "  Second = " + second);
            if (first.length() > result.length()) {
                result = first;
            }
            if (second.length() > result.length()) {
                result = second;
            }
        }
        return result;
    }

    public static String getPalindromeLength(String input, int left, int right) {
        while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
            left--;
            right++;
        }
        return input.substring(left + 1, right);
    }
}
