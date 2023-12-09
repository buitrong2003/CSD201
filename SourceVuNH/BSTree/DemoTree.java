/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage2;

import java.util.ArrayList;

/**
 *
 * @author d
 */
class Node {

    Object info;
    Node left, right;

    public Node(Object x, Node le, Node ri) {
        info = x;
        left = le;
        right = ri;
    }

    public Node(Object x) {
        info = x;
        left = right = null;
    }
}

class MyQueue {

    ArrayList al;

    public MyQueue() {
        al = new ArrayList();
    }

    public boolean isEmpty() {
        return al.isEmpty();
    }

    public void enqueue(Object x) {
        al.add(x);
    }

    public Object dequeue() {
        return al.remove(0);
    }
}

class BinTree {

    Node root;

    public BinTree() {
        Node a, b, c, d, e, f, g, h, i;
        a = new Node("A");
        c = new Node("C");
        e = new Node("E");
        h = new Node("H");
        d = new Node("D", c, e);
        i = new Node("I", h, null);
        b = new Node("B", a, d);
        h = new Node("G", null, i);
        root = f = new Node("F", b, h);
    }

    public void visit(Node x) {
        System.out.print(x.info + " ");
    }

    void printLevels(Node root) {
        int height = getHeight(root);
        for (int level = 1; level <= height; level++) {
            printLevel(root, level, 1);
        }
    }

    void printLevel(Node p, int targetLevel, int currentLevel) {
        if (p == null) {
            return;
        }
        if (currentLevel == targetLevel) {
            System.out.print("(" + p.info + "," + targetLevel + ") ");
        } else if (currentLevel < targetLevel) {
            printLevel(p.left, targetLevel, currentLevel + 1);
            printLevel(p.right, targetLevel, currentLevel + 1);
        }
    }

    void displayLevel() {
        printLevels(root);

    }

    int getHeight(Node p) {
        if (p == null) {
            return 0;
        } else {
            int leftHeight = getHeight(p.left);
            int rightHeight = getHeight(p.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void displayOrder() {
        preOrder(root);
    }

    int height(Node p) {
        if (p == null) {
            return 0;
        } else {
            int lDepth = height(p.left);
            int rDepth = height(p.right);
            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }

    void displayHeight() {
        System.out.println(height(root));

    }

    public void breathFirstTraverse() {
        Node p = root;
        if (p == null) {
            return;
        }
        ArrayList<String> addLeft = new ArrayList<>();
        ArrayList<String> printInternal = new ArrayList<>();
        int count = 0;
        MyQueue m = new MyQueue();
        m.enqueue(p);
        while (!m.isEmpty()) {
            Node q = (Node) m.dequeue();
            count++;
            if (q.left != null) {
                m.enqueue(q.left);
            }
            if (q.right != null) {
                m.enqueue(q.right);
            }
            if (q.left == null && q.right == null) {
                addLeft.add((String) q.info);
            }
            if (q.left != null || q.right != null) {
                printInternal.add((String) q.info);
            }
        }
        System.out.println(count);
        int k = 0;
        for (String string : addLeft) {
            k++;
        }
        System.out.print(k + ": ");
        for (String string : addLeft) {
            System.out.print(string + " ");
        }
        System.out.println();
        for (String string : printInternal) {
            System.out.print(string + " ");
        }
    }

}

public class DemoTree {

    public static void main(String[] args) {
        BinTree bin = new BinTree();
        bin.breathFirstTraverse();
        System.out.println();
        bin.displayOrder();
        System.out.println();
        bin.displayHeight();
        bin.displayLevel();

    }
}
