package com.demo.assessment.Problems;

/**
 * Given two numbers a and b, find out the sum of their carries when they are added.
 * Example
 * a = 2999
 * b = 1999
 * answer would be 3 -> e.g 9 + 9 = 1 (carry), 9 + 9 + 1 = 1 (carry), 9 + 9 + 1 = 1(CARRY)
 */
public class SumOfCarry {

    public static void main(String[] args) {

        int a = 2999;
        int b = 1999;
        System.out.println(sumOfCarries(a, b));
    }

    private static int sumOfCarries(int a, int b) {
        int r1, r2;
        int sum = 0;
        int carry = 0;
        while (a != 0 || b != 0) {
            r1 = a % 10;
            r2 = b % 10;
            if (r1 + r2 + carry > 9) {
                sum++;
                carry = 1;
            } else {
                carry = 0;
            }
            a = a / 10;
            b = b / 10;
        }
        return sum;
    }
}
