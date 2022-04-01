package com.demo.assessment.Problems;

/**
 * Find the only repeating element in a sorted array of size n
 * Difficulty Level : Easy
 * Last Updated : 24 Jan, 2022
 * Given a sorted array of n elements containing elements in range from 1 to n-1 i.e.
 * one element occurs twice, the task is to find the repeating element in an array.
 * Examples :
 * <p>
 * <p>
 * Input :  arr[] = { 1, 2 , 3 , 4 , 4}
 * Output :  4
 * <p>
 * Input :  arr[] = { 1 , 1 , 2 , 3 , 4}
 * Output :  1
 */
public class FindFirstRepeating {

    // Linear search would take 0(n) time
    // Using binary search will take 0(logN)
    public static void main(String[] args) {

        int[] values = new int[]{ 1, 2 , 3 , 4 , 4};
        System.out.println(findRepeating(values));
    }

    // { 1,2,3,4,4,5 }
    //  s -> 0 0
    //  e -> 2 1
    private static int findRepeating(int[] values) {
        int start = 0;
        int end = values.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            System.out.println(start + " end = " + end);
            int current = values[mid];

            if(current != mid + 1) {
                if(values[mid] == values[mid - 1])
                    return values[mid];

                start = 0;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return  -1;
    }
}
