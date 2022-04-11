package com.demo.assessment.Problems;

/**
 * Connect Nodes at Same Level
 * Medium Accuracy: 45.67% Submissions: 73582 Points: 4
 * Given a binary tree, connect the nodes that are at same level.
 * You'll be given an addition nextRight pointer for the same.
 * <p>
 * Initially, all the nextRight pointers point to garbage values.
 * Your function should set these pointers to point next right for each node.
 * 10                       10 ------> NULL
 * / \                       /      \
 * 3   5       =>     3 ------> 5 --------> NULL
 * / \   \               /  \           \
 * 4   1   2          4 --> 1 -----> 2 -------> NULL
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 3
 * /  \
 * 1    2
 * / \
 * 4   5
 * Output:
 * 3 1 2
 * 1 3 2
 * Explanation:The connected tree is
 * 3 ------> NULL
 * /    \
 * 1-----> 2 ------ NULL
 * Example 2:
 * <p>
 * Input:
 * 10
 * /   \
 * 20   30
 * /  \
 * 40  60
 * Output:
 * 10 20 30 40 60
 * 40 20 60 10 30
 * Explanation:The connected tree is
 * 10 ----------> NULL
 * /     \
 * 20 ------> 30 -------> NULL
 * /    \
 * 40 ----> 60 ----------> NULL
 */
public class ConnectNodesAtSameLevel {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);

        print(root);
        connectNode(root);
        System.out.println();
        print(root);
    }

    private static void connectNode(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.nextRight = root.right != null ? root.right : getRight(root.nextRight);
        }

        if (root.right != null) {
            root.right.nextRight = getRight(root.nextRight);
        }
        connectNode(root.left);
        connectNode(root.right);
    }

    private static void print(Node root) {
        if (root == null) {
            return;
        }
        print(root.left);
        System.out.println(root);
        print(root.right);
    }

    public static Node getRight(Node n) {
        while (n != null) {
            if (n.left != null) return n.left;
            if (n.right != null) return n.right;
            n = n.nextRight;
        }
        return null;
    }

     static class Node {
        int data;
        Node left, right, nextRight;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return " data = " + data + " nextRight -> " + (nextRight == null ? "NULL" : nextRight.data);
        }
    }
}