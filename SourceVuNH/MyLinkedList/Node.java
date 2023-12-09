
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author d
 */
//public class Node {
//
//    Object info;
//    Node next;
//
//    public Node(Object x) {
//        info = x;
//        next = null;
//    }
//
//    public Node(Object x, Node n) {
//        info = x;
//        next = n;
//    }
//}
//
//class MyStack {
//
//    Node head;
//
//    public MyStack() {
//        head = null;
//    }
//
//    public boolean isEmpty() {
//        return head == null;
//    }
//
//    public void push(Object x) {
//        head = new Node(x, head);
//    }
//
//    public Object pop() {
//        if (isEmpty()) {
//            return null;
//        }
//        Object x = head.info;
//        head = head.next;
//        return x;
//    }
//}
//
//class demo {
//
//    public static void main(String[] args) {
//        MyStack s = new MyStack();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter number need converst: ");
//        int number = scanner.nextInt();
//        System.out.println("Program to illustrate Stack converst binary: ");
//        while (number > 0) {
//            int converst = number % 2;
//            s.push(converst);
//            number /= 2;
//        }
//        while (!s.isEmpty()) {
//            System.out.print(s.pop());
//        }
//        System.out.println();
//        System.out.println("Program to illustrate Queue: ");
//        MyQueue q = new MyQueue();
//        q.enqueue("A");
//        q.enqueue("B");
//        q.enqueue("C");
//        while (!q.isEmpty()) {
//            System.out.print(q.dequeue() + " ");
//        }
//        System.out.println();
//    }
//}
//
//class MyQueue {
//
//    Node head, tail;
//
//    public MyQueue() {
//        head = tail = null;
//    }
//
//    public boolean isEmpty() {
//        return head == null;
//    }
//
//    public void enqueue(Object x) {
//        if (isEmpty()) {
//            head = tail = new Node(x, null);
//        } else {
//            tail.next = new Node(x, null);
//            tail = tail.next;
//        }
//    }
//
//    public Object dequeue() {
//        if (isEmpty()) {
//            return null;
//        }
//        Object x = head.info;
//        head = head.next;
//        if (head == null) {
//            tail = null;
//        }
//        return x;
//    }
//}
