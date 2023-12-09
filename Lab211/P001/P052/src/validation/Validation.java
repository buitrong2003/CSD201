/*
 * Copyright(C) Bui Duc Trong
 * J1.S.P0052
 * Manage Geographic
 */
package validation;

import java.util.Scanner;

/**
 *
 * @author Bui Duc Trong
 */
public class Validation {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * This function will user enter String and return String if user enter not
     * Empty and matches with regex else tell wrong and enter again
     *
     * @param message
     * @param regex
     * @param error
     * @return
     */
    public static String getString(String message, String regex, String error) {
        System.out.println(message);
        // Create the loop can enter when correct return if nos will enter again
        while (true) {
            String input = scanner.nextLine();
            // check Empty to input 
            // if no Empty
            if (!input.isEmpty()) {
                // check input matches regex
                if (input.matches(regex)) {
                    return input;
                } // else tell wrong and enter again
                else {
                    System.out.println(error);
                    System.out.println("Please enter again:");
                }
            } // else empty tell wrong and enter again
            else {
                System.out.println("Input not Empty.");
                System.out.println("Please enter again:");
            }
        }
    }

    /**
     * This function use to get an integer number from user input. If user enter
     * wrong , not integer number tell error and enter again. If user not enter
     * number in range min to max tell wrong and enter again. If enter correct
     * be will return number
     *
     * @param message
     * @param min
     * @param max
     * @param error
     * @return
     */
    public static int getInteger(String message, int min, int max, String error) {
        System.out.println(message);
        // Create the loop can enter when correct return if nos will enter again
        while (true) {
            try {
                String input = scanner.nextLine();
                // check Empty to input 
                // if no Empty
                if (!input.isEmpty()) {
                    int number = Integer.parseInt(input);
                    // check number in range min to max
                    if (number >= min && number <= max) {
                        return number;
                    } // else tell wrong and enter again
                    else {
                        System.out.println("Number Integer must be range: " + min + " -> " + max);
                        System.out.println("Please enter again:");
                    }
                } // else tell wrong and enter again
                else {
                    System.out.println("Input not Empty.");
                    System.out.println("Please enter again:");
                }
            } catch (Exception e) {
                // if error format number tell wrong and enter again
                System.out.println(error);
                System.out.println("Please enter again:");
            }
        }
    }

    /**
     * This function use to get an float number from user input. If user enter
     * wrong , not float number tell error and enter again. If user not enter
     * number in range min to max tell wrong and enter again. If enter correct
     * be will return number
     *
     * @param message
     * @param min
     * @param max
     * @param error
     * @return
     */
    public static float getFloat(String message, float min, float max, String error) {
        System.out.println(message);
        // Create the loop can enter when correct return if nos will enter again
        while (true) {
            try {
                String input = scanner.nextLine();
                // check Empty to input 
                // if no Empty
                if (!input.isEmpty()) {
                    float number = Float.parseFloat(input);
                    // check number in range min to max
                    if (number >= min && number <= max) {
                        return number;
                    } // else tell wrong and enter again
                    else {
                        System.out.println("Number Float must be range: " + min + " -> " + max);
                        System.out.println("Please enter again:");
                    }
                } // else empty tell wrong and enter again
                else {
                    System.out.println("Input not Empty.");
                    System.out.println("Please enter again:");
                }
            } catch (Exception e) {
                // if error format number tell wrong and enter again
                System.out.println(error);
                System.out.println("Please enter again:");
            }
        }
    }
}
