package SelectionSort;

import java.util.Random;
import java.util.Scanner;

public class SelectionSort {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numberElement = getNumberElement();
        int array[] = value(numberElement);
        displayValueInArray(array, "Unsorted array: ");
        selectionSort(array);
        System.out.println();
        displayValueInArray(array, "Sorted array: ");
    }

    private static void selectionSort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean check = true;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    check = false;
                }
            }
            if (check) {
                break;
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
