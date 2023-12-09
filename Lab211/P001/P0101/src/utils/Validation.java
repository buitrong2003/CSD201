/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
                        System.err.println("Number Integer must be range: " + min + " -> " + max);
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

    public static double getDouble(String message, double min, double max, String error) {
        System.out.print(message);
        while (true) {
            try {
                String input = scanner.nextLine();
                if (!input.isEmpty()) {
                    double number = Double.parseDouble(input);
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.err.println("Number Double must be range: " + min + " -> " + max);
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

    public static Date getDate(String message, String regex, String error) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print(message);
        while (true) {
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                if (input.matches(regex)) {
                    if (checkInputDateExist(input)) {
                        try {
                            return simpleDateFormat.parse(input);
                        } catch (ParseException ex) {
                        }
                    } else {
                        System.err.println("Date not Valid.");
                        System.out.print("PLease enter again: ");
                    }
                } else {
                    System.err.println(error);
                    System.out.println("Please enter again: ");
                }
            } else {
                System.err.println("Input not Empty.");
                System.out.print("Please enter again: ");
            }
        }
    }

    private static boolean checkInputDateExist(String input) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);
        try {
            Date currdate = new Date();
            Date date = simpleDateFormat.parse(input);
            long result = (currdate.getTime() - date.getTime())
                    / (60 * 60 * 24 * 365 * 1000l);
            if (result >= 18 && result <= 60) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
