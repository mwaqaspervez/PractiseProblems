package com.demo.assessment.Problems;

/**
 * Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->6->7->8->NULL, K = 3
 * Output: 3->2->1->6->5->4->8->7->NULL
 * Input: 1->2->3->4->5->6->7->8->NULL, K = 5
 * Output: 5->4->3->2->1->8->7->6->NULL
 */
public class ReverseLinkedListInKSize {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);
        root.next.next.next.next.next = new Node(6);
        root.next.next.next.next.next.next = new Node(7);
        root.next.next.next.next.next.next.next = new Node(8);

        print(reverse(root, 3));
    }

    private static void print(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node reverse(Node root, int k) {
        Node current = root;
        Node prev = null;
        Node next = null;
        int count = 0;
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null) {
            root.next = reverse(next, k);
        }

        return prev;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

}
