package com.demo.assessment.Problems;

/**
 * Given a binary tree (not a binary search tree) and two values say n1 and n2,
 * write a program to find the least common ancestor.
 * <p>
 * Following is definition of LCA from Wikipedia:
 * Let T be a rooted tree. The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node in T
 * that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).
 * The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located farthest from the root.
 * Computation of lowest common ancestors may be useful, for instance, as part of a procedure for determining the
 * distance between pairs of nodes in a tree: the distance from n1 to n2 can be computed as the distance from the root to n1,
 * plus the distance from the root to n2,
 * minus twice the distance from the root to their lowest common ancestor. (Source Wiki)
 */
public class LCABinaryTree {

    /*
    *           1
    *         /    \
    *        2      3
    *       / \    / \
    *      4   5  6   7
    * */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("LCA(4, 5): " + findLCA(root, 4, 5));
        System.out.println("LCA(4, 6): " + findLCA(root, 4, 6));
        System.out.println("LCA(3, 4): " + findLCA(root, 3, 4));
        System.out.println("LCA(2, 4): " + findLCA(root, 2, 4));

    }

    private static Node findLCA(Node root, int n1, int n2) {

        if (root == null) {
            return null;
        }

        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node left = findLCA(root.left, n1, n2);
        Node right = findLCA(root.right, n1, n2);

        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }
}
