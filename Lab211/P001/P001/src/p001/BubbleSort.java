/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p001;

import java.util.Random;

/**
 *
 * @author d
 */
public class BubbleSort {

    /**
     * This function use to generate number random and assign value given to
     * element's in array
     *
     * @param array
     */
    static void generateRandomNumberInRange(int array[], int sizeOfArray) {
        Random random = new Random();
        // The loop to assign number random with element's in array
        for (int i = 0; i < array.length; i++) {
            // generate random number
            int number = random.nextInt(sizeOfArray);
            // assign given value in array
            array[i] = number;
        }
    }

    /**
     * This function use to display to element's in array
     *
     * @param array
     */
    static void displayArray(int[] array, String mess) {
        System.out.print(mess);
        System.out.print("[");
        // The loop to input element's in array small has lenght - 1
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        // display element last in array
        System.out.print(array[array.length - 1]);
        System.out.println("]");
    }

    /**
     * This function to Sort all element's in array if element before small
     * after element will swap. After each sort be element bigger will floated
     *
     *
     * @param array
     */
    static void sortArray(int[] array) {
        // The loop give mark the number of iterations and each iteration the lagerst 
        // will floated, it will from end to beginning
        for (int i = array.length - 1; i > 0; i--) {
            // Generate boolen is true to check array sort
            boolean sorted = true;
            // The loop it iterates over each pair of consecutive elements in the list to compare and sort.
            for (int j = 0; j < i; j++) {
                // compare pair element's in array
                if (array[j] > array[j + 1]) {
                    // swap element
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    sorted = false;
                }
            }
            // if check array sort is true be it will break loop and not repeat one more time
            if (sorted) {
                break;
            }
        }
    }
}
