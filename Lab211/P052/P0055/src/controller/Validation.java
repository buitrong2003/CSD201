/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Scanner;

/**
 *
 * @author d
 */
public class Validation {

    private static Scanner scanner = new Scanner(System.in);

    public static String getString(String message, String regex, String error) {
        System.out.print(message);
        while (true) {
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.err.println(error);
                    System.out.print("Please enter again: ");
                }
            } else {
                System.err.println("Input not Empty.");
                System.out.print("Please enter again: ");
            }
        }
    }

    public static int getInteger(String message, int min, int max, String error) {
        System.out.print(message);
        while (true) {
            try {
                String input = scanner.nextLine();
                if (!input.isEmpty()) {
                    int number = Integer.parseInt(input);
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.err.println("Number Integer must be in range: " + min + " -> " + max);
                        System.out.print("Please enter again: ");
                    }
                } else {
                    System.err.println("Input not Empty.");
                    System.out.print("Please enter again: ");
                }
            } catch (Exception e) {
                System.err.println(error);
                System.out.print("Please enter again: ");
            }
        }
    }

    public static boolean checkInputYN(String message, String error) {
        System.out.print(message);
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("y")) {
                return true;
            } else if (input.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.err.println(error);
                System.out.print("Please enter again: ");
            }
        }
    }
}
