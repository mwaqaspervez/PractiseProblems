package com.demo.assessment.Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n.
 * You are also given an integer startValue representing the value of the start node s,
 * and a different integer destValue representing the value of the destination node t.
 * <p>
 * Find the shortest path starting from node s and ending at node t.
 * Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'.
 * Each letter indicates a specific direction:
 * <p>
 * 'L' means to go from a node to its left child node.
 * 'R' means to go from a node to its right child node.
 * 'U' means to go from a node to its parent node.
 * Return the step-by-step directions of the shortest path from node s to node t.
 */
public class StepByStepDirections {

    public static void main(String[] args) {
        //[5,1,2,3,null,6,4], startValue = 3, destValue = 6
        Node root = new Node(5);
        root.left = new Node(1);
        root.left.left = new Node(3);
        root.right = new Node(2);
        root.right.left = new Node(6);
        root.right.right = new Node(4);

        int start = 2;
        int destination = 1;

        System.out.println(getDirections(root, start, destination));
    }

    private static List<String> getDirections(Node root, int start, int destination) {
        List<String> leftList = new ArrayList<>();
        List<String> rightList = new ArrayList<>();
        Node lca = getLCA(root, start, destination);

        getPath(lca, leftList, start);
        getPath(lca, rightList, destination);

        for (int i = 0; i < leftList.size(); i++) {
            leftList.set(i, "U");
        }
        List<String> result = new ArrayList<>(leftList);
        result.addAll(rightList);
        return result;
    }

    private static boolean getPath(Node root, List<String> list, int start) {
        if (root == null) {
            return false;
        }

        if (start == root.data) {
            return true;
        }

        if (getPath(root.left, list, start)) {
            list.add("L");
            return true;
        }

        if (getPath(root.right, list, start)) {
            list.add("R");
            return true;
        }

        return false;
    }

    private static Node getLCA(Node root, int start, int destination) {
        if (root == null) {
            return null;
        }
        if (root.data == start || root.data == destination) {
            return root;
        }

        Node left = getLCA(root.left, start, destination);
        Node right = getLCA(root.right, start, destination);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;

    }

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return " " + data;
        }
    }
}
