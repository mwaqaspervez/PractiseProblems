package com.demo.assessment.Problems;

/**
 * Given a Binary Tree, check if all leaves are at same level or not.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 1
 * /   \
 * 2     3
 * <p>
 * Output: 1
 * <p>
 * Explanation:
 * Leaves 2 and 3 are at same level.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * 10
 * /    \
 * 20      30
 * /  \
 * 10    15
 * <p>
 * Output: 0
 * <p>
 * Explanation:
 * Leaves 10, 15 and 30 are not at same level.
 */
public class LeafAtSameLevel {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
       /* root.left.left = new Node(10);
        root.left.right = new Node(15);*/
        System.out.println(isOnSameLevel(root) == -1);
    }

    private static int isOnSameLevel(Node root) {
        if (root == null) {
            return -1;
        }

        int left = isOnSameLevel(root.left);
        int right = isOnSameLevel(root.right);
        if (root.left != null && root.right != null) {
            if (left != right) {
                return -1;
            }
        }
        return Math.max(left, right) + 1;
    }

    public static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
}
