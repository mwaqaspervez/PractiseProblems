package com.demo.assessment.Problems;

/**
 * Given the head of the linked list representing a positive integer,
 * the task is to print the updated linked list after subtracting 1 from it.
 * <p>
 * Examples:
 * <p>
 * Input: LL = 1 -> 2 -> 3 -> 4
 * Output: 1 -> 2 -> 3 -> 3
 * <p>
 * Input: LL = 1 -> 2
 * Output: 1 -> 1
 */
public class SubtractFromLinkList {

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(2);
        head.next.next = new Node(0);
        /*head.next.next.next = new Node(1);*/

        System.out.print("List is ");
        printList(head);

        head = subtractOne(head);

        System.out.print("Resultant list is ");
        printList(head);
    }

    // Time -> n
    // Space -> 1
    private static Node subtractOne(Node head) {
        nodeUtil(head);
        while (head != null && head.data == 0) {
            head = head.next;
        }

        return head;
    }

    private static int nodeUtil(Node head) {
        if (head == null) {
            return -1;
        }

        int carry = nodeUtil(head.next);
        if (carry == -1) {
            if (head.data == 0) {
                head.data = 9;
                return -1;
            } else {
                head.data = head.data - 1;
                return 0;
            }
        }
        return 0;
    }

    static void printList(Node node) {

        // Iterate until node is null
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

}
