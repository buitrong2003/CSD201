package mergesort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {

    private static final Scanner sc = new Scanner(System.in);

    private static void merge(int left, int mid, int right, int array[]) {
        int[] array1 = Arrays.copyOfRange(array, left, mid + 1);
        int[] array2 = Arrays.copyOfRange(array, mid + 1, right + 1);
        int lowerIndex = left, i = 0, j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                array[lowerIndex] = array1[i];
                i++;
                lowerIndex++;
            } else {
                array[lowerIndex] = array2[j];
                j++;
                lowerIndex++;
            }
        }
        while (i < array1.length) {
            array[lowerIndex] = array1[i];
            i++;
            lowerIndex++;
        }
        while (j < array2.length) {
            array[lowerIndex] = array2[j];
            j++;
            lowerIndex++;
        }
    }

    private static void mergeSort(int left, int right, int array[]) {
        int mid = (left + right) / 2;
        if (left >= right) {
            return;
        }
        mergeSort(left, mid, array);
        mergeSort(mid + 1, right, array);
        merge(left, mid, right, array);
    }

    private static int[] value(int size) {
        int array[] = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(((99 + 99) + 1) - 99);
        }
        return array;
    }

    private static void displayValueInArray(int array[], String mess) {
        System.out.print(mess);
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length - 1) {
                System.out.print(array[i] + " ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.print("]");
    }

    private static int getNumberElement() {
        System.out.println("Enter number of array: ");
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n > 0) {
                    return n;
                } else {
                    System.out.println("Number element of array must be number Integer greater 0");
                    System.out.println("Please enter again: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Number element of array must be number Integer");
                System.out.println("Please enter again: ");
            }
        }
    }

    public static void main(String[] args) {
        int numberElement = getNumberElement();
        int array[] = value(numberElement);
        displayValueInArray(array, "Unsorted array: ");
        mergeSort(0, numberElement - 1, array);
        System.out.println();
        displayValueInArray(array, "Sorted array: ");
    }

}
