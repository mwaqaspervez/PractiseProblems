package com.demo.assessment.Problems;

import java.util.HashSet;
import java.util.Set;

/**
 * Find a pair with given target in BST
 * <p>
 * Given a Binary Search Tree and a target sum. Check whether there's a
 * pair of Nodes in the BST with value summing up to the target sum.
 */
public class FindSumBST {

    public static void main(String[] args) {

        /*Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);*/
        Node root = new Node(6);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.left.left = new Node(1);
        root.left.left.right = new Node(4);
        for (int i = 1; i < 20; i++) {
          //  System.out.println(i + " = " + findPair(root, root, i));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < 20; i++) {
            System.out.println(i + " = " + find(root, set, i));
        }
    }

    private static boolean find(Node root, Set<Integer> set, int sum) {
        if (root == null) {
            return false;
        }

        int diff = sum - root.data;
        if (root.data != diff && set.contains(diff)) {
            return true;
        }

        if(find(root.left, set, sum)) {
            return true;
        }
        set.add(root.data);
        return find(root.right, set, sum);
    }

    private static boolean findPair(Node root, Node parent, int sum) {
        if (root == null) {
            return false;
        }
        int diff = sum - root.data;

        if (findDiff(parent, root.data, diff)) {
            return true;
        }

        return findPair(root.left, parent, sum) || findPair(root.right, parent, sum);
    }

    private static boolean findDiff(Node root, int current, int diff) {
        if (root == null) {
            return false;
        }
        if (root.data != current && root.data == diff) {
            return true;
        }
        return findDiff(root.left, current, diff) || findDiff(root.right, current, diff);
    }

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
}
