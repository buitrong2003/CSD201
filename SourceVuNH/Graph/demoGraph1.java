/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.LinkedList;

/**
 *
 * @author d
 */
public class demoGraph1 {

    public static void main(String[] args) {
        MyGraph g = new MyGraph();
        g.printAdjE();
        g.printEdges();
        g.countEdges();
        g.adjWithE();
        g.sumDeg();
        g.visitBTF();
        g.depth(2);
    }
}

class MyGraph {

    char v[] = "abefgi".toCharArray();
    int n = 6;
    // a  b  e  f  g  i
    int a[][] = {{0, 0, 1, 1, 1, 1},// a
    {0, 0, 0, 0, 1, 0},//b
    {1, 0, 0, 1, 0, 1},//e
    {1, 0, 1, 0, 0, 1},//f
    {1, 1, 0, 0, 0, 0},//g
    {1, 0, 1, 1, 0, 0}};//i

    public void setData(char vertices[], int size, int adjMatrix[][]) {
        n = size;
        v = vertices;
        a = adjMatrix;
    }

    public void printAdjE() {
        System.out.println("Adj with E: ");
        for (int j = 0; j < n; j++) {
            if (a[2][j] > 0) {
                System.out.print(v[j] + ", ");
            }
        }
        System.out.println("");
    }

    public void printEdges() {
        System.out.print("Add edges: ");
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (a[i][j] > 0) {
                    System.out.print(v[i] + "" + v[j] + " ");
                }
            }
        }
        System.out.println();
    }

    public void countEdges() {
        System.out.print("Count Edges: ");
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i][j] > 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    void breadth(boolean[] visited, int k) {
        Queue q = new Queue();
        int r, i;
        boolean[] enqueued = new boolean[20];
        for (i = 0; i < n; i++) {
            enqueued[i] = false;
        }
        q.enqueue(k);
        enqueued[k] = true;
        while (!q.isEmpty()) {
            r = q.dequeue();
            if (!visited[r]) {
                System.out.print(v[r] + " ");//modifier function fvisit
                visited[r] = true;
            }
            for (i = 0; i < n; i++) {
                if (!visited[i] && !enqueued[i] && a[r][i] > 0) {
                    q.enqueue(i);
                    enqueued[i] = true;
                }
            }
        }
    }

    void visitBTF() {
        boolean visited[] = new boolean[n];
        breadth(visited, 2);
        System.out.println("");
    }

    void adjWithE() {
        System.out.print("Edges adj with E: ");
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] > 0) {
                    System.out.print(v[2] + "" + v[j] + " ");
                }
            }
            break;
        }
        System.out.println("");
    }

    void sumDeg() {
        int sum = 0;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] > 0) {
                    sum += a[i][j];
                }
            }
            break;
        }
        System.out.println("Deg(E): " + sum);
    }

    void fvisit(int i) {
        System.out.println(v[i]);
    }

    void depth(boolean[] visited, int k) {
        fvisit(k);
        visited[k] = true;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && a[k][i] > 0) {
                depth(visited, i);
            }
        }
    }

    void depth(int k) {
        boolean[] visited = new boolean[20];
        int i;
        for (i = 0; i < n; i++) {
            visited[i] = false;
        }
        depth(visited, k);
        for (i = 0; i < n; i++) {
            if (!visited[i]) {
                depth(visited, i);
            }
        }
    }

}

class Queue {

    LinkedList<Integer> t;

    Queue() {
        t = new LinkedList<Integer>();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void clear() {
        t.clear();
    }

    void enqueue(int x) {
        t.addLast(x);
    }

    Integer dequeue() {
        if (isEmpty()) {
            return (null);
        }
        return (t.removeFirst());
    }

    Integer front() {
        if (isEmpty()) {
            return (null);
        }
        return (t.getFirst());
    }
}
