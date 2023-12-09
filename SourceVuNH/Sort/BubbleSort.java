package BubbleSort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numberElement = getInteger("Enter number of array:", 1, Integer.MAX_VALUE, "Number must be number Integer.");
        int array[] = value(numberElement);
        displayValueInArray(array, "Unsorted array: ");
        bubbleSort(array);
        System.out.println();
        displayValueInArray(array, "Sorted array: ");
    }

    private static void bubbleSort(int array[]) {
        for (int i = array.length - 1; i > 0; i--) {
            boolean check = true;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
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
        System.out.println(Arrays.toString(array));
    }

    private static int getInteger(String mess, int min, int max, String error) {
        System.out.println(mess);
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n > 0) {
                    return n;
                } else {
                    System.err.println("Number must be in range: " + min + " -> " + max);
                    System.out.print("Please enter again: ");
                }
            } catch (NumberFormatException e) {
                System.err.println(error);
                System.out.print("Please enter again: ");
            }
        }
    }

    private static int[] value(int size) {
        int array[] = new int[size];
        Random random = new Random();
        int min = -99;
        int max = 99;
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }
}
