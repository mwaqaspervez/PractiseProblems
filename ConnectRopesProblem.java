package com.demo.assessment.Problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * There are given n ropes of different lengths, we need to connect these ropes into one rope.
 * The cost to connect two ropes is equal to the sum of their lengths. We need to connect the ropes with minimum cost.
 * <p>
 * For example, if we are given 4 ropes of lengths 4, 3, 2, and 6. We can connect the ropes in the following ways.
 * 1) First, connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6, and 5.
 * 2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
 * 3) Finally connect the two ropes and all ropes have connected.
 * Total cost for connecting all ropes is 5 + 9 + 15 = 29. This is the optimized cost for connecting ropes. Other ways of connecting ropes would always have same or more cost. For example, if we connect 4 and 6 first (we get three strings of 3, 2, and 10), then connect 10 and 3 (we get two strings of 13 and 2).
 * Finally, we connect 13 and 2. Total cost in this way is 10 + 13 + 15 = 38.
 */
public class ConnectRopesProblem {

    public static void main(String[] args) {
        int[] ropes = new int[]{4, 3, 2, 6};
        System.out.println(connectRopesWithPriorityQueue(ropes));
        System.out.println(connectRopes(ropes));
    }

    // Time -> nlogn
    // Space -> n
    private static int connectRopesWithPriorityQueue(int[] ropes) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int rope : ropes) {
            queue.add(rope);
        }
        int result = 0;
        while (queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            result += first + second;
            queue.add(first + second);
        }
        return result;
    }

    // Time -> nlogn
    // Space -> 1
    private static int connectRopes(int[] ropes) {
        int sum = 0;

        Arrays.sort(ropes);
        for (int i = 0; i < ropes.length - 1; i++) {
            int first = ropes[i];
            int second = ropes[i + 1];
            sum += first + second;
            ropes[i + 1] = first + second;
            ropes[i] = 0;
            Arrays.sort(ropes);
        }
        return sum;
    }
}
