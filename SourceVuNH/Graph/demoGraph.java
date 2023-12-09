/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage3;

/**
 *
 * @author d
 */
import java.util.ArrayList;

public class demoGraph {

    public static void main(String[] args) {
        MyGraph g = new MyGraph();
//        g.printVertices();
//        g.printAdjF();
//        g.breadthFirstTraverse(0);
//        g.depthFS(0);
//        g.sortDijkstra(0);
        g.Dijkstra(0, 6);
    }
}

class MyGraph {
//    //               A  B  E  F  G  I
//    int a[][] = {   {0, 0, 1, 1, 1, 1}, //A 0
//                    {0, 0, 0, 0, 1, 0}, //B 1
//                    {1, 0, 0, 1, 0, 1}, //E 2
//                    {1, 0, 1, 0, 0, 1}, //F 3
//                    {1, 1, 0, 0, 0, 0}, //G 4
//                    {1, 0, 1, 1, 0, 0}};//I 5
//    int n=6;
//    char labels[]={'A','B','E','F','G','I'};

    static int INF = 1000;
    //              A    B     C    D     E    F    G
    int a[][] = {{0, 10, INF, INF, INF, INF, 8}, //A
    {INF, 0, 2, 10, 25, 80, INF}, //B
    {30, INF, 0, 8, 3, 20, INF}, //C
    {20, INF, INF, 0, INF, 5, 10}, //D
    {INF, INF, INF, 4, 0, INF, INF}, //E
    {8, INF, INF, INF, INF, 0, 5}, //F
    {8, INF, INF, INF, INF, INF, 0}}; //G
    int n = 7;
    char labels[] = "ABCDEFG".toCharArray();

    public void sortDijkstra(int u) {
        ArrayList<Integer> listS = new ArrayList<>();
        int D[] = new int[n];
        int P[] = new int[n];
        for (int i = 0; i < n; i++) {
            P[i] = -1;
        }
        listS.add(u);
        for (int i = 0; i < n; i++) {
            D[i] = a[u][i];
        }
        while (listS.size() != n) {
            int Dmin = INF, imin = -1;
            for (int j = 0; j < n; j++) {
                if (!listS.contains(j) && D[j] < Dmin) {
                    Dmin = D[j];
                    imin = j;
                }
            }
            listS.add(imin);

            for (int j = 0; j < n; j++) {
                if (a[imin][j] > 0 && a[imin][j] < INF && !listS.contains(j)) {
                    if (D[j] > D[imin] + a[imin][j]) {
                        D[j] = D[imin] + a[imin][j];
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(labels[u] + "->" + labels[i] + ":" + D[i]);
        }
    }

    public void breadthFirstTraverse(int k) {
        boolean isVisited[] = new boolean[n];
        breadthFT(k, isVisited);
        for (int i = 0; i < n; i++) {
            if (isVisited[i] == false) {
                breadthFT(i, isVisited);
            }
        }

        System.out.println("");
    }

    public void breadthFT(int k, boolean isVisited[]) {
        MyQueue q = new MyQueue();
        q.enqueue(k);
        isVisited[k] = true;
        while (!q.isEmpty()) {
            int u = q.dequeue();
            visit(u);
            for (int i = 0; i < n; i++) {
                if (a[u][i] > 0 && isVisited[i] == false) {
                    q.enqueue(i);
                    isVisited[i] = true;
                }
            }
        }
    }

    public void depthFS(int k) {
        boolean isVisited[] = new boolean[n];
        depthFS(k, isVisited);

        for (int j = 0; j < n; j++) {
            if (isVisited[j] == false) {
                depthFS(j, isVisited);
            }
        }
    }

    public void depthFS(int k, boolean isVisited[]) {
        visit(k);
        isVisited[k] = true;
        for (int i = 0; i < n; i++) {
            if (a[k][i] > 0 && isVisited[i] == false) {
                depthFS(i, isVisited);
            }
        }
    }

    public void visit(int k) {
        System.out.print(labels[k] + ", ");
    }

    public void setGraph(int b[][], int size, char lbs[]) {
        n = size;
        a = b;
        labels = lbs;
    }

    public void printVertices() {
        for (int i = 0; i < n; i++) {
            System.out.print(labels[i] + ",");
        }
        System.out.println("");
    }

    public void printAdjF() {
        int iF = 3;
        for (int k = 0; k < n; k++) {
            if (a[iF][k] > 0) {
                System.out.print(labels[k] + ",");
            }
        }
        System.out.println("");
    }

    public void Dijkstra(int u, int v) {
        int[] d = new int[n];
        int[] t = new int[n];
        boolean[] c = new boolean[n];
        for (int i = 0; i < n; i++) {
            d[i] = a[u][i];
            t[i] = u;
        }

        int curr = u;

        while (curr != v) {
            int k = -1;
            int min = INF;
            for (int i = 0; i < n; i++) {
                if (!c[i] && d[i] < min) {
                    min = d[i];
                    k = i;
                }
            }

            if (min == INF) {
                System.out.println("Shortest path does not exist.");
                return;
            }
            c[k] = true;
            curr = k;
            for (int i = 0; i < n; i++) {
                if (d[i] > d[k] + a[k][i] && !c[i]) {
                    d[i] = d[k] + a[k][i];
                    t[i] = k;
                }
            }
        }
        System.out.print("Shortest path from " + labels[u] + " to " + labels[v] + " is: ");
        printPath(u, v, t);
        System.out.println(" with a total cost of " + d[v]);
    }

    public void printPath(int u, int v, int[] t) {
        if (u == v) {
            System.out.print(labels[u]);
        } else {
            printPath(u, t[v], t);
            System.out.print(" -> " + labels[v]);
        }
    }
}

class MyQueue {

    ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void enqueue(int x) {
        list.add(x);
    }

    public int dequeue() {
        return list.remove(0);
    }
}
