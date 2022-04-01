package com.demo.assessment.Problems;

/**
 * Given values of two values n1 and n2 in a Binary Search Tree, find the Lowest Common Ancestor (LCA).
 * You may assume that both the values exist in the tree.
 * <p>
 * Examples:
 * <p>
 * Tree:
 * <p>
 * <p>
 * Input: LCA of 10 and 14
 * Output:  12
 * Explanation: 12 is the closest node to both 10 and 14
 * which is a ancestor of both the nodes.
 * <p>
 * Input: LCA of 8 and 14
 * Output:  8
 * Explanation: 8 is the closest node to both 8 and 14
 * which is a ancestor of both the nodes.
 * <p>
 * Input: LCA of 10 and 22
 * Output:  20
 * Explanation: 20 is the closest node to both 10 and 22
 * which is a ancestor of both the nodes.
 */
public class LCABinarySearchTree {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    /*
     *           20
     *          /   \
     *         8     22
     *        / \
     *       4   12
     *           / \
     *          10  14
     * */
    static class BinaryTree {
        Node root;

        Node lca(Node node, int n1, int n2) {

            if (node == null) {
                return null;
            }

            if (n1 < node.data && n2 < node.data) {
                return lca(node.left, n1, n2);
            }

            if (n1 >= node.data && n2 >= node.data) {
                return lca(node.right, n1, n2);
            }

            return node;
        }
    }

    public static void main(String[] args) {
        // Let us construct the BST shown in the above figure
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);

        int n1 = 10, n2 = 14;
        Node t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

    }
}
