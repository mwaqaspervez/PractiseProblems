package com.demo.assessment.Problems;

/**
 * Given two binary trees with head reference as T and S having at most N nodes.
 * The task is to check if S is present as subtree in T.
 * A subtree of a tree T1 is a tree T2 consisting of a node in T1 and all of its descendants in T1.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * T:      1          S:   3
 * /   \            /
 * 2     3          4
 * /  \    /
 * N    N  4
 * Output: 1
 * Explanation: S is present in T
 * <p>
 * Example 2:
 * <p>
 * Input:
 * T:      26         S:   26
 * /   \           /  \
 * 10     N        10    N
 * /    \           /  \
 * 20    30        20  30
 * /  \            /  \
 * 40   60         40  60
 * Output: 1
 * Explanation:
 * S and T are both same. Hence,
 * it can be said that S is a subtree
 * of T.
 */
public class SubtreeProblem {
    public static void main(String[] args) {
        Node tree = new Node(10);
        tree.left = new Node(15);
        tree.left.left = new Node(20);

        Node subtree = new Node(110);
        subtree.left = new Node(15);

       /* root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);*/

        System.out.println(isSubtree(tree, subtree));
    }

    private static boolean isSubtree(Node tree, Node subtree) {
        if (tree == null) {
            return true;
        }

        if (isIdentical(tree, subtree)) {
            return true;
        }

        return isSubtree(tree.left, subtree) || isSubtree(tree.right, subtree);
    }

    private static boolean isIdentical(Node t, Node s) {
        if (t == null && s == null) {
            return true;
        }

        if (t == null || s == null) {
            return false;
        }
        if (t.data == s.data) {
            return isIdentical(t.left, s.left) && isIdentical(t.left, s.right);
        }

        return false;
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }
}
