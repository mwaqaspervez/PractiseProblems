package com.demo.assessment.Problems;

/**
 * Check for BST
 * Easy Accuracy: 21.58% Submissions: 100k+ Points: 2
 * Given the root of a binary tree. Check whether it is a BST or not.
 * Note: We are considering that BSTs can not contain duplicate Nodes.
 * A BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class CheckIfBST {

    public static void main(String[] args) {

        Node root = new Node(2);
        root.right = new Node(7);
        root.right.right = new Node(6);
        root.right.right.right = new Node(5);
        root.right.right.right.right = new Node(9);
        root.right.right.right.right.right = new Node(2);
        root.right.right.right.right.right.right = new Node(6);

        System.out.println(isBST(root));
    }

    public static boolean isBST(Node root) {

        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.data >= root.data)
            return false;

        if (root.right != null && root.right.data < root.data)
            return false;

        return isBST(root.left) && isBST(root.right);
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
}
