package com.demo.assessment.Problems;

import java.util.PriorityQueue;

public class KthLargestNumber {


    // Find the Kth Largest Number in a given array.
    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 23, 24, 11, 12, 90, 92, 54, 1};
        int k = 5;
        int largest = findKthLargest(array, k);
        System.out.println(largest);
    }


    private static int findKthLargest(int[] array, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // Add k elements to the priority queue
        // It will be sorted in ASC.
        for (int i = 0; i < k; i++) {
            queue.add(array[i]);
        }
        // Now loop through the array and if a number is greater
        // than the first element of queue. replace it.
        for (int i = k; i < array.length; i++) {
            int current = queue.peek();
            if (array[i] > current) {
                queue.remove();
                queue.add(array[i]);
            }
        }
        // The first element will be the kth largest element.
        return queue.peek();
    }

}

