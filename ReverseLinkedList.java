package com.demo.assessment.Problems;

/**
 * Given pointer to the head node of a linked list, the task is to reverse the linked list. We need to reverse the list by changing the links between nodes.
 * <p>
 * Examples:
 * <p>
 * Input: Head of following linked list
 * 1->2->3->4->NULL
 * Output: Linked list should be changed to,
 * 4->3->2->1->NULL
 * <p>
 * Input: Head of following linked list
 * 1->2->3->4->5->NULL
 * Output: Linked list should be changed to,
 * 5->4->3->2->1->NULL
 * <p>
 * Input: NULL
 * Output: NULL
 * <p>
 * Input: 1->NULL
 * Output: 1->NULL
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);

        print(reverse(root));
    }

    private static void print(Node root) {

        while (root != null) {
            System.out.print(root.data);
            root = root.next;
        }
        System.out.println();
    }

    private static Node reverse(Node root) {
        // next -> NULL 2 3 4
        // prev -> NULL 1 2 3
        // curr -> root 2 3 4

        // 1 -> 2 -> 3 -> 4 -> NULL
        // 4 -> 3 -> 2 -> 1 -> NULL

        Node prev = null, next;
        while (root != null) {
            next = root.next;
            root.next = prev;
            prev = root;
            root = next;
        }
        return prev;
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

}
