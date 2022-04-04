package com.demo.assessment.Problems;

import java.util.Stack;

/**
 * Design a data-structure SpecialStack that supports all the stack operations
 * like push(), pop(), isEmpty(), isFull() and an additional operation getMin()
 * which should return minimum element from the SpecialStack.
 * Your task is to complete all the functions, using stack data-Structure.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * Stack: 18 19 29 15 16
 * Output: 15
 * Explanation:
 * The minimum element of the stack is 15.
 */
public class SpecialStack {
    private static final Stack<Integer> stack = new Stack<>();

    public void push(int value) {
        stack.push(value);
    }

    public int pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean isFull(int size) {
        return stack.size() == size;
    }

    public static int getMin() {
        if (stack.size() == 1) return stack.pop();

        int top = stack.pop();
        int min = Math.min(top, getMin());
        stack.push(top);
        return min;
    }

    public static void main(String[] args) {
        stack.push(11);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        stack.push(2);

        System.out.println(getMin());
    }

}
