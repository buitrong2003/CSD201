package newpackage;

public class ArrayInsert {

    public static void merge(int[] a, int n, int[] b, int m) {
        int k = n + m;
        int c[] = new int[k];
        int count = 0;
        for (int i = 0; i < c.length; i++) {
            c[i] = a[i];
            count++;
            if (count == n) {
                break;
            }
        }
        int min = 0;
        int lengthC = a.length - 1;
        for (int i = 0; i < b.length; i++) {
            boolean check = false;
            for (int j = lengthC; j >= 0; j--) {
                if (b[i] < c[j]) {
                    min = j;
                    check = true;
                }
            }
            lengthC++;
            if (lengthC == c.length) {
                break;
            }
            if (check) {
                int g = lengthC;
                while (g > min) {
                    c[g] = c[g - 1];
                    g--;
                }
                c[min] = b[i];
            } else {
                int l = lengthC;
                c[l] = b[i];
            }
        }
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int b[] = {2, 5, 6, 7};
        int a[] = {1, 2, 3, 8};
        merge(a, a.length, b, b.length);
    }
}
