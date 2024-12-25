package com.huylq.LinkedList;

import javax.xml.transform.Source;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1, null);
        Node<Integer> node2 = new Node<>(2, null);
        Node<Integer> node3 = new Node<>(3, null);
        Node<Integer> node4 = new Node<>(4, null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("Traversal of LinkedList:");
        traverse(node1);

        System.out.println("Is exist value 1 in LinkedList:");
        System.out.println(isExist(node1, 1));
        System.out.println("Is exist value 10 in LinkedList:");
        System.out.println(isExist(node1, 10));

        System.out.println("LinkedList length:");
        System.out.println(length(node1));

        System.out.println("Insert value 2 to head:");
        node1 = insertHead(node1, 2);
        traverse(node1);

        System.out.println("Insert value 3 to tail:");
        node1 = insertTail(node1, 3);
        traverse(node1);

        System.out.println("Insert value 10 to pos 3:");
        node1 = insertPos(node1, 3, 10);
        traverse(node1);

        System.out.println("Delete head");
        node1 = deleteHead(node1);
        traverse(node1);

        System.out.println("Delete tail");
        node1 = deleteTail(node1);
        traverse(node1);

        System.out.println("Delete pos");
        node1 = deletePos(node1, 3);
        traverse(node1);
    }

    public static <T> void traverse(Node<T> head) {
        Node<T> current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public static <T> boolean isExist(Node<T> head, T data) {
        if (head == null) {
            return false;
        }
        Node<T> current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static <T> int length(Node<T> head) {
        if (head == null) {
            return 0;
        }
        return 1 + length(head.next);
    }

    public static <T> Node<T> insertHead(Node<T> head, T data) {
        Node<T> newNode = new Node<>(data, null);
        newNode.next = head;
        head = newNode;
        return head;
    }

    public static <T> Node<T> insertTail(Node<T> head, T data) {
        Node<T> newNode = new Node<>(data, null);
        if(head == null) {
            return newNode;
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    public static <T> Node<T> insertPos(Node<T> head, int pos, T data) {
        if(pos < 1){
            System.out.println("INVALID POS");
            return head;
        }
        if(pos == 1){
            return insertHead(head, data);
        }
        Node<T> prev = head;
        int count = 0;
        while(count < pos - 2 && prev != null) {
            prev = prev.next;
            count++;
        }
        if(prev == null){
            System.out.println("INVALID POS");
            return head;
        }
        Node<T> temp = new Node<>(data, null);
        temp.next = prev.next;
        prev.next = temp;

        return head;
    }

    public static <T> Node<T> deleteHead(Node<T> head) {
        if (head == null) {
            return null;
        }
        head = head.next;
        return head;
    }

    public static <T> Node<T> deleteTail(Node<T> head) {
        if (head == null) {
            return null;
        }
        if(head.next == null){
            head = null;
            return head;
        }
        Node<T> secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        secondLast.next = null;
        return head;
    }

    public static <T> Node<T> deletePos(Node<T> head, int pos) {
        if (head == null || pos < 1) {
            System.out.println("INVALID POS");
            return head;
        }
        if (pos == 1) {
            return deleteHead(head);
        }

        Node<T> current = head;
        for (int i = 1; i < pos - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("INVALID POS");
            return head;
        }

        current.next = current.next.next;

        return head;
    }

}
