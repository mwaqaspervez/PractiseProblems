package com.demo.assessment.Problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement Stack using Queues
 * Difficulty Level : Medium
 * Last Updated : 04 Oct, 2021
 * <p>
 * The problem is opposite of this post. We are given a Queue data structure that supports standard operations like enqueue() and dequeue().
 * We need to implement a Stack data structure using only instances of Queue and queue operations allowed on the instances.
 */
public class StackUsingQueue {

    public static void main(String[] arg) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.print();
        stack.pop();
        stack.pop();
        stack.print();
    }

    public static class Stack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        public void push(int data) {
            while (!q1.isEmpty()) {
                q2.add(q1.poll());
            }
            q1.add(data);

            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }
        }

        public int pop() {
            if (q1.isEmpty()) {
                return -1;
            }
            return q1.poll();
        }

        public void print() {
            Queue<Integer> temp = new LinkedList<>(q1);
            while (!temp.isEmpty()) {
                System.out.print(temp.poll() + " ");
            }
            System.out.println();
        }
    }
}
