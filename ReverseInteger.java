package com.demo.assessment.Problems;

/**
 * 7. Reverse Integer
 * Medium
 *
 * 7038
 *
 * 9650
 *
 * Add to List
 *
 * Share
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 *
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 */
public class ReverseInteger {

    public static void main (String [] args) {

        int number = 1534236469;

        System.out.println(reverse(number));
    }

    private static int reverse(int number) {
        int result = 0;
        while(number != 0) {
            int remainder = number % 10;
            long newResult = (long) result * 10 + remainder;
            if(newResult > Integer.MAX_VALUE || newResult < Integer.MIN_VALUE) {
                result = 0;
                break;
            } else {
                result = (int) newResult;
            }
            number /= 10;
        }
        return result;
    }
}
