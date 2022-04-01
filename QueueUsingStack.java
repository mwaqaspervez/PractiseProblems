package com.demo.assessment.Problems;

import java.util.Stack;

/**
 * Queue using Stacks
 * Difficulty Level : Medium
 * Last Updated : 27 Dec, 2021
 * The problem is opposite of this post. We are given a stack data structure with push and pop operations,
 * the task is to implement a queue using instances of stack data structure and operations on them.
 */
public class QueueUsingStack {

    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.print();
        queue.dequeue();
        queue.dequeue();
        queue.print();
    }


    static class Queue {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public void enqueue(Integer data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public int dequeue() {
            if (s1.isEmpty()) {
                return -1;
            }
            return s1.pop();
        }

        public void print() {
            Stack<Integer> temp = new Stack<>();
            temp.addAll(s1);
            while (!temp.isEmpty()) {
                System.out.print(temp.pop() + " ");
            }
            System.out.println();
        }
    }
}
