package com.demo.assessment.Problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Clone a linked list with next and random pointer | Set 2
 * Difficulty Level : Medium
 * Last Updated : 02 Jul, 2021
 * We have already discussed 2 different ways to clone a linked list. In this post,
 * one more simple method to clone a linked list is discussed.
 */
public class CloneLinkedListWithRandomPointer {

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.random = head.next.next.next.next;
        head.next.random = head.next.next.next;
        print(head);

        print(clone(head));
    }

    private static void print(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data);
            System.out.print(temp.random == null ? "" :  " -> " + temp.random.data);
            System.out.println();
            temp = temp.next;
        }
        System.out.println();
    }

    private static Node clone(Node head) {

        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        Node current = null;
        while (temp != null) {
            current = new Node(temp.data);
            map.put(temp, current);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            current = map.get(temp);
            current.next = map.get(temp.next);
            current.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }

    static class Node {
        int data;
        Node next, random;

        public Node(int data) {
            this.data = data;
        }
    }
}
