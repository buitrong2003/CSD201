/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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

    public static int getInteger(String message, int min, int max, String erro) {
        System.out.print(message);
        while (true) {
            try {
                String input = scanner.nextLine();
                if (!input.isEmpty()) {
                    int number = Integer.parseInt(input);
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.err.println("Number must be range: " + min + " -> " + max);
                        System.out.print("Please enter again: ");
                    }
                } else {
                    System.err.println("Input not Empty.");
                    System.out.print("Please enter again: ");
                }
            } catch (Exception e) {
                System.err.println(erro);
                System.out.print("Please enter again: ");
            }
        }
    }

    public static double getDouble(String message, double min, double max, String erro) {
        System.out.print(message);
        while (true) {
            try {
                String input = scanner.nextLine();
                if (!input.isEmpty()) {
                    double number = Double.parseDouble(input);
                    if (number >= min && number <= max) {
                        return number;
                    } else {
                        System.err.println("Number must be range: " + min + " -> " + max);
                        System.out.print("Please enter again: ");
                    }
                } else {
                    System.err.println("Input not Empty.");
                    System.out.print("Please enter again: ");
                }
            } catch (Exception e) {
                System.err.println(erro);
                System.out.print("Please enter again: ");
            }
        }
    }

    public static Date getDate(String message, String regex, String error) {
        System.out.print(message);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        while (true) {
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                if (input.matches(regex)) {
                    if (checkDateExist(input)) {
                        try {
                            return simpleDateFormat.parse(input);
                        } catch (ParseException ex) {
                        }
                    } else {
                        System.err.println("Date not Valid.");
                        System.out.print("Please enter again: ");
                    }
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

    private static boolean checkDateExist(String input) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        simpleDateFormat.setLenient(false);
        try {
            Date date = simpleDateFormat.parse(input);
            Date curreDate = new Date();
            if (date.before(curreDate)) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException ex) {
            return false;
        }
    }

    public static boolean checkInputYN(String message, String error) {
        System.out.print(message);
        while (true) {
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                if (input.equalsIgnoreCase("y")) {
                    return true;
                } else if (input.equalsIgnoreCase("n")) {
                    return false;
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
}
