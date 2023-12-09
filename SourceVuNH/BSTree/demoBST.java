/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage4;

import java.util.LinkedList;

/**
 *
 * @author d
 */
public class demoBST {

    public static void main(String[] args) {
        int[] a = {4, 3, 1, 11, 5, 9, 2, 6, 15, 12};
        BSTree t = new BSTree();
        for (int i : a) {
            t.insert(i);
        }
        t.displayInOrder();
        System.out.println();
        t.del();
    }
}

class BSTree {

    Node root;

    public BSTree() {
        root = null;
    }

    public void insert(int x) {
        Node p = new Node(x);
        Node f = null, q = root;
        while (q != null) {
            if (q.info == x) {
                return;
            }
            if (q.info < x) {
                f = q;
                q = q.right;
            } else {
                f = q;
                q = q.left;
            }
        }
        if (f == null) {
            root = p;
        } else if (p.info > f.info) {
            f.right = p;
        } else {
            f.left = p;
        }
    }

    public void visit(Node x) {
        System.out.print(x.info + ", ");
    }

    public void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    int count = 0;

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        if (p.info == 11 && count == 0) {
            deleteByCopy(p.info);
            count++;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    public void displayInOrder() {
        inOrder(root);
    }
    public void del() {
        preOrder(root);
    }

    public Node search(Node p, int key) {
        if (p == null) {
            return null;
        }
        if (p.info == key) {
            return p;
        } else if (p.info > key) {
            return search(p.left, key);
        } else {
            return search(p.right, key);
        }
    }

    public void deleteByCopy(int x) {
        Node p = search(root, x);
        if (p == null) {
            System.out.println("Key " + x + " does not exists, deletion failed");
            return;
        }
        //find f is father of p
        Node f = null, q = root;
        while (q != p) {
            f = q;
            if (q.info > p.info) {
                q = q.left;
            } else {
                q = q.right;
            }
        }
        //1.p has no child
        if (p.left == null && p.right == null) {
            if (f == null) {
                root = null;
            } else if (f.left == p) {
                f.left = null;
            } else {
                f.right = null;
            }
        } //2.p has left child only
        else if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else if (f.left == p) {
                f.left = p.left;
            } else {
                f.right = p.left;
            }
        } //3.p has right child only
        else if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
            } else if (f.left == p) {
                f.left = p.right;
            } else {
                f.right = p.right;
            }
        } //4.p has both child
        else if (p.left != null && p.right != null) {
            //tim q la node lon nhat ben con trai cua p -> q la con phai nhat
            //cua con trai cua p
            q = p.left;
            f = null;
            while (q.right != null) {
                f = q;
                q = q.right;
            }
            p.info = q.info;
            //delete q
            if (f == null) {
                p.left = q.left;
            } else {
                f.right = q.left;
            }
        }
    }
}/////////////////////////////////////////////////////////////

class Node {

    int info;
    Node left, right;

    public Node(int info, Node left, Node right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public Node(int info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }
}

class Queue {

    LinkedList<Node> t;

    Queue() {
        t = new LinkedList<Node>();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void enqueue(Node p) {
        t.addLast(p);
    }

    Node dequeue() {
        if (isEmpty()) {
            return (null);
        }
        return (t.removeFirst());
    }

    Node front() {
        if (isEmpty()) {
            return (null);
        }
        return (t.getFirst());
    }
}
