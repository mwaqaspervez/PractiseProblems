package com.demo.assessment.Problems;

/**
 * 12. Integer to Roman
 * Medium
 * <p>
 * 3083
 * <p>
 * 3981
 * <p>
 * Add to List
 * <p>
 * Share
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 3
 * Output: "III"
 * Explanation: 3 is represented as 3 ones.
 * Example 2:
 * <p>
 * Input: num = 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 3:
 * <p>
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= num <= 3999
 */
public class IntegerToRoman {

    public static void main(String[] args) {
        String input = "24";
        int value = Integer.parseInt(input);
        System.out.println(toRoman(value));
    }

    private static String toRoman(Integer value) {
        String result = "";
        if (value < 5) {
            if (value == 4) {
                result += "IV";
            } else {
                result = append(result, value, "I");
            }
        } else if (value < 10) {
            if (value == 9) {
                result += "IX";
            } else {
                result = "V" + append(result, value - 5, "I");
            }
        } else if (value < 50) {
            if (value == 40) {
                result += "XL";
            } else {
                result = append(result, value - (value % 10), "X");
            }

        } else if (value < 100) {

        }
        return result;
    }

    private static String append(String result, int value, String character) {
        for (int i = 0; i < value; i++) {
            result += character;
        }
        return result;
    }
}
