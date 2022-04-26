package com.demo.assessment.Problems;

/**
 * Triplet Sum in Array
 * Medium Accuracy: 49.0% Submissions: 95638 Points: 4
 * Given an array arr of size n and an integer X. Find if there's a triplet in the
 * array which sums up to the given integer X.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * n = 6, X = 13
 * arr[] = [1 4 45 6 10 8]
 * Output:
 * 1
 * Explanation:
 * The triplet {1, 4, 8} in
 * the array sums up to 13.
 */
public class TripletSumInArray {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 2, 3, 1, 4, 8};
        System.out.println(hasTripletSum(arr, 3));
    }

    public static boolean hasTripletSum(int[] arr, int sum) {

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int k = i;
            int j = arr.length - 1;

            // for two pointers approach to triverse the array.
            while (k < j) {
                int currentSum = current + arr[j] + arr[k];
                if (currentSum == sum) {
                    return true;
                }
                if (currentSum < sum) {
                    k++;
                } else {
                    j--;
                }
            }

        }
        return false;
    }
}
