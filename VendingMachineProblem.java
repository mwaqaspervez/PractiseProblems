package com.demo.assessment.Problems;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * A vending machine has the following denominations: 1c, 5c, 10c, 25c, 50c, and $1.
 * Your task is to write a program that will be used in a vending machine to return change.
 * Assume that the vending machine will always want to return the least number of coins or notes.
 * Devise a function getChange(M, P) where M is how much money was inserted into the machine and P
 * the price of the item selected,
 * that returns an array of integers representing the number of each denomination to return.
 * <p>
 * Example:
 * getChange(5, 0.99) // should return [1,0,0,0,0,4]
 * getChange(3.14, 1.99) // should return [0,1,1,0,0,1]
 * getChange(3, 0.01) // should return [4,0,2,1,1,2]
 * getChange(4, 3.14) // should return [1,0,1,1,1,0]
 * getChange(0.45, 0.34) // should return [1,0,1,0,0,0]
 **/
public class VendingMachineProblem {

    static float[] coins = new float[]{1, 0.5f, 0.25f, 0.1f, 0.05f, 0.01f};
    static int[] result = new int[]{0, 0, 0, 0, 0, 0};

    public static void main(String[] args) {
        float[][] array = new float[][]{
                {5, 0.99f},
                {3.14f, 1.99f},
                {3, 0.01f},
                {4, 3.14f},
                {0.45f, 0.34f}
        };
        for (float[] floats : array) {
            getChange(floats[0], floats[1]);
            System.out.println(Arrays.toString(result));
            result = new int[]{0, 0, 0, 0, 0, 0};
        }
    }

    public static void getChange(float total, float price) {
        BigDecimal value = new BigDecimal(String.valueOf(total))
                .subtract(new BigDecimal(String.valueOf(price)));
        int i = 0;
        while (i != coins.length) {
            float remaining = value.subtract(new BigDecimal(String.valueOf(coins[i]))).floatValue();
            if (remaining >= 0) {
                value = new BigDecimal(String.valueOf(remaining));
                result[coins.length - i - 1] = result[coins.length - i - 1] + 1;
            } else {
                i++;
            }
        }
    }
}
