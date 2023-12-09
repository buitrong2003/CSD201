

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author d
 */
public class demoRecursion {

    public static void main(String[] args) {
        System.out.println("F(10) = " + Rec.sum(10));
        int a[] = {5, 7, 9, 30, 11, 26};
        Rec.findMax(a, a.length - 1, 0);
        Rec.display();
        Rec.convert(19);
        Rec.print();
        int[] arr = {72, 24, 64};
        int n = 3;
        int result = Rec.findGCD(arr, n);
        System.out.println("Gcd is: " + result);
        int av[] = {5, 7, 9, 11, 30, 26};
        int x = 9;
        for (int i : av) {
            System.out.print(i + " ");
        }
        System.out.println("Search : " + x);
        Rec.binarySearch(x, av, 0, av.length - 1);
        System.out.println("Gcd(a,b): ");
        System.out.println(Rec.gcd(35, 100));
        System.out.println("Number Power of 2 ^ 3: ");
        Rec.power(3, 2);
        Rec.printPower();
    }
}

class Rec {

    static int max = Integer.MIN_VALUE;

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n - 1);
    }

    public static void findMax(int[] a, int lenght, int i) {
        if (max < a[i]) {
            max = a[i];
        }
        if (lenght == 0) {
            return;
        }
        findMax(a, lenght - 1, i + 1);
    }

    public static void display() {
        System.out.println("Mas is: " + max);
    }
    static String sum = "";

    public static void convert(int n) {
        int k = n % 2;
        if (n == 0) {
            return;
        }
        sum = k + sum;
        convert(n / 2);
    }

    public static void print() {
        System.out.println(sum);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static int findGCD(int[] a, int n) {
        int result = a[0];
        for (int i = 1; i < n; i++) {
            result = gcd(result, a[i]);
        }
        return result;
    }

    public static void binarySearch(int x, int array[], int left, int right) {
        int mid = (right + left) / 2;
        if (left > right) {
            return;
        }
        if (x == array[mid]) {
            System.out.println(mid);
        } else if (x < array[mid]) {
            binarySearch(x, array, left, mid - 1);
        } else {
            binarySearch(x, array, mid + 1, right);
        }
    }
    static int number = 1;

    public static void power(int n, int x) {
        if (n == 0) {
            return;
        }
        number *= x;
        power(n - 1, x);
    }

    public static void printPower() {
        System.out.println(number);
    }

}
