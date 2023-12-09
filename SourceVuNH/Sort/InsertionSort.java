package InsertionSort;

import java.util.Random;
import java.util.Scanner;

public class InsertionSort {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numberElement = getNumberElement();
        int array[] = value(numberElement);
        displayValueInArray(array, "Unsorted array: ");
        insertionSort(array);
        System.out.println();
        displayValueInArray(array, "Sorted array: ");
    }

    private static void insertionSort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            int number = array[i];
            int j = i - 1, pos = -1;
            while (j >= 0) {
                if (number < array[j]) {
                    array[j + 1] = array[j];
                    pos = j;
                }
                j--;
            }
            if (pos != -1) {
                array[pos] = number;
            }
        }
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

    private static int[] value(int size) {
        int array[] = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(((99 + 99) + 1) - 99);
        }
        return array;
    }
}
