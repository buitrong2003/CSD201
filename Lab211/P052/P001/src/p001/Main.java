/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p001;

import java.util.Scanner;

/**
 *
 * @author d
 */
public class Main {

    public static void main(String[] args) {
        // input a postitive decimal number
        int sizeOfArray = getInteger("Enter number of array:",
                "Size of array must be number Integer.", 1, Integer.MAX_VALUE);
        // Declaring array
        int[] array = new int[sizeOfArray];
        // Generate random integer in number range for each array element
        BubbleSort.generateRandomNumberInRange(array, sizeOfArray);
        // Display array before 
        BubbleSort.displayArray(array, "Unsorted array: ");
        // Sort all element's in array
        BubbleSort.sortArray(array);
        // Display array after 
        BubbleSort.displayArray(array, "Sorted array: ");
    }

    /**
     * This function use to get an integer number from user input. If user enter
     * wrong, not integer number tell error and prompt user enter again and
     * request user enter correct range min to max if enter incorrect in range
     * min and max be user enter again
     *
     * @param mess
     * @param error
     * @param min
     * @param max
     * @return
     */
    private static int getInteger(String mess, String error, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(mess);
        // The Loop to user input correct number integer if incorrect be enter
        // again
        while (true) {
            try {
                // user enter a number integer
                String input = scanner.nextLine();
                if (!input.isEmpty()) {
                    int number = Integer.parseInt(input);
                    // check input have in range min to max
                    if (number >= min && number <= max) {
                        return number;
                    } // if not in range min max be will tell wrong and enter again
                    else {
                        System.err.println("Number must in range: " + min + " -> " + max);
                        System.out.print("Please enter again: ");
                    }
                    // if input Empty be will tell wrong and enter again
                } else {
                    System.err.println("Input not Empty.");
                    System.out.print("Please enter again: ");
                }
            } catch (NumberFormatException e) {
                // if number not correct format be tell and enter again
                System.err.println(error);
                System.out.print("Please enter again: ");
            }
        }
    }
}
