package com.demo.assessment.Problems;

import java.util.Arrays;

/**
 * Insertion sort algorithm
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] array = new int[]{5, 2, 3, 7, 1, 9};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length ; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }
}
