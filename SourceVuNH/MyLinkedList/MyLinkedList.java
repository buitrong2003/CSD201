/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author d
 */
public class MyLinkedList {

    Node head, tail;

    public MyLinkedList() {
        head = tail = null;
    }

    void add(int value) {
        Node node = new Node(value);
        if (head == null || tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    void traverse() {
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.value + " ");
        }
    }

    void search(int x) {
        int index = 0, count = 0;
        for (Node node = head; node != null; node = node.next) {
            if (node.value == x) {
                count++;
                System.out.println("Found at the " + index + "-th position.");
            }
            index++;
        }
        if (count == 0) {
            System.out.println("\nNot found");
        }
    }

    void max() {
        int max = head.value;
        for (Node node = head; node != null; node = node.next) {
            if (max < node.value) {
                max = node.value;
            }
        }
        System.out.println(max);
    }

    void sum() {
        int sum = 0;
        for (Node node = head; node != null; node = node.next) {
            sum += node.value;
        }
        System.out.println("sum: " + sum);
    }

    void avg() {
        int count = 0;
        int sum = 0;
        for (Node node = head; node != null; node = node.next) {
            sum += node.value;
            count++;
        }
        System.out.println("avg: " + sum / count);
    }

    void count() {
        int count = 0;
        for (Node node = head; node != null; node = node.next) {
            count++;
        }
        System.out.println("count: " + count);
    }

    void sort() {
        if (head == null) {
            return;
        }
        Node pi = head, pj;
        while (pi != null) {
            pj = pi.next;
            while (pj != null) {
                if (pi.value > pj.value) {
                    int temp = pi.value;
                    pi.value = pj.value;
                    pj.value = temp;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
        for (Node node = head; node != null; node = node.next) {
            System.out.print(node.value + " ");
        }
    }

    void delFirst() {
        head = head.next;
    }

    void delLast() {
        Node node = head;
        while (node.next.next != null) {
            node = node.next;
        }
        node.next = null;
        tail = node;
    }

    void delPosition(int pos) {
        Node p = head;
        while (pos-- > 1) {
            p = p.next;
        }
        p.next = p.next.next;
    }

    void delete(int x) {
        int count = 0;
        int size = 0;
        for (Node node = head; node != null; node = node.next) {
            size++;
        }
        for (Node node = head; node != null; node = node.next) {
            if (x == node.value) {
                break;
            }
            count++;
        }
        if (count == 0) {
            delFirst();
        } else if (count == size - 1) {
            delLast();
        } else {
            delPosition(count);
        }
        System.out.println();
    }

    void findMax() {
        int max = head.value;
        for (Node node = head; node != null; node = node.next) {
            if (max < node.value) {
                max = node.value;
            }
        }
        int max2 = 0;
        for (Node node = head; node != null; node = node.next) {
            if (node.value != max) {
                max2 = node.value;
                break;
            }
        }
        for (Node node = head; node != null; node = node.next) {
            if (max2 < node.value && node.value != max) {
                max2 = node.value;
            }
        }
        System.out.println(max2);
    }

}

class Main {

    public static void main(String[] args) {
        MyLinkedList a = new MyLinkedList();
        a.add(5);
        a.add(7);
        a.add(2);
        a.add(8);
        a.add(3);
        a.traverse();
        a.search(1);
        a.search(8);
        a.max();
        a.sum();
        a.avg();
        a.count();
        a.sort();
        a.delete(5);
        a.traverse();
        System.out.println("");
        a.findMax();
    }
}

class Node {

    int value;
    Node next;

    public Node(int x) {
        value = x;
        next = null;
    }

    public Node(int x, Node n) {
        value = x;
        next = n;
    }
}
