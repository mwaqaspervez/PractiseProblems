package com.demo.assessment.Problems;

import java.math.BigDecimal;

/*
A vending machine has the following denominations: 1c, 5c, 10c, 25c, 50c, and $1.
Your task is to write a program that will be used in a vending machine to return change.
Assume that the vending machine will always want to return the least number of coins or notes.
Devise a function getChange(M, P) where M is how much money was inserted into the machine and P the price of the item selected,
that returns an array of integers representing the number of each denomination to return.

Example:
getChange(5, 0.99) // should return [1,0,0,0,0,4]
getChange(3.14, 1.99) // should return [0,1,1,0,0,1]
getChange(3, 0.01) // should return [4,0,2,1,1,2]
getChange(4, 3.14) // should return [1,0,1,1,1,0]
getChange(0.45, 0.34) // should return [1,0,1,0,0,0]
*/
public class VendingMachineProblem {

    static float[] coins = new float[]{1, 0.5f, 0.25f, 0.1f, 0.05f, 0.01f};
    static int [] result = new int [] { 0 , 0, 0 , 0 ,0 ,0};
    public static void main(String[] args) {
        float total = 4f;
        getChange((float) (total - 3.14));
        System.out.print("[");
        for (int j : result) {
            System.out.print(j +",");
        }
        System.out.println("]");
    }

    public static void getChange(float amount) {
        int i = 0;
        while (i != coins.length) {
            float remaining = amount - coins[i];
            if(remaining > 0) {
                amount = remaining;
                result[coins.length - i - 1] = result[coins.length - i - 1] + 1;
            } else {
                i++;
            }
        }
    }
}
