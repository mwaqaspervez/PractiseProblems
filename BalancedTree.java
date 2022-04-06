package com.demo.assessment.Problems;

/**
 * Given a binary tree, find if it is height balanced or not.
 * A tree is height balanced if difference between heights of left
 * and right subtrees is not more than one for all nodes of tree.
 * <p>
 * A height balanced tree
 * 1
 * /     \
 * 10      39
 * /
 * 5
 * <p>
 * An unbalanced tree
 * 1
 * /
 * 10
 * /
 * 5
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 1
 * /
 * 2
 * \
 * 3
 * Output: 0
 * Explanation: The max difference in height
 * of left subtree and right subtree is 2,
 * which is greater than 1. Hence unbalanced
 * Example 2:
 * <p>
 * Input:
 * 10
 * /   \
 * 20   30
 * /   \
 * 40   60
 * Output: 1
 * Explanation: The max difference in height
 * of left subtree and right subtree is 1.
 * Hence balanced.
 */
public class BalancedTree {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(15);
        root.left.left = new Node(20);
       /* root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);*/

        System.out.println(getHeight(root, 0) != -1);
    }

    private static int getHeight(Node root, int height) {
        if (root == null) {
            return height;
        }

        int left = getHeight(root.left, height + 1);
        int right = getHeight(root.right, height + 1);

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right);
    }

    private static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
}
