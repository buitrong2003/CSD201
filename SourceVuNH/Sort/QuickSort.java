package quicksort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {

    private static final Scanner sc = new Scanner(System.in);
// chọn chốt ở giữa
//    private static int partition(int left, int right, int array[]) {
//        int mid = (left + right) / 2;
//        int pivot = array[mid];
//        int i = left, j = right;
//        while (i <= j) {
//            while (array[i] < pivot) {
//                i++;
//            }
//            while (array[j] > pivot) {
//                j--;
//            }
//            if (i <= j) {
//                int temp = array[i];
//                array[i] = array[j];
//                array[j] = temp;
//                i++;
//                j--;
//            }
//        }
//        return i - 1;
//    }
//-------------------------------------------------------------------------------
// chọn chốt ở đầu

    private static int partition(int left, int right, int array[]) {
        int pivot = array[left], i = left + 1, j = right;
        while (i < j) {
            while (pivot > array[i] && i < j) {
                i++;
            }
            while (pivot < array[j] && j > i) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

            }
        }

        int temp = array[i - 1];
        array[i - 1] = array[left];
        array[left] = temp;

        return i - 1;
    }
//    
    //---------------------------------------------------------------------------
    // chọn chốt ở cuối
//    private static int partition(int left, int right, int array[]) {
//        int pivot = array[right], i = left, j = right - 1;
//        while (i <= j) {
//            while (pivot > array[i]) {
//                i++;
//            }
//            while (pivot < array[j]) {
//                j--;
//            }
//            if (i <= j) {
//                int temp = array[i];
//                array[i] = array[j];
//                array[j] = temp;
//                i++;
//                j--;
//            }
//        }
//        int temp = array[i];
//        array[i] = array[right];
//        array[right] = temp;
//        return i;
//    }

    private static void quickSort(int left, int right, int array[]) {
        if (left >= right) {
            return;
        }
        int partition = partition(left, right, array);
        // chọn chốt ở giữa
//        quickSort(left, partition, array);
//        quickSort(partition + 1, right, array);
//-----------------------------------
// chọn chốt ở đầu và cuối
        quickSort(left, partition - 1, array);
        quickSort(partition + 1, right, array);
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

    private static void displayValueInArray(int array[], String mess) {
        System.out.print(mess);
        System.out.print(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int numberElement = getNumberElement();
        int array[] = value(numberElement);
        displayValueInArray(array, "Unsorted array: ");
        quickSort(0, array.length - 1, array);
        System.out.println();
        displayValueInArray(array, "Sorted array: ");
    }

}
