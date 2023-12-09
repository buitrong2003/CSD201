/*
 * Copyright(C) Bui Duc Trong
 * J1.S.P0102
 * Format Date
 */
package datedayofweekfinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Bui Duc Trong
 */
public class Main {

    public static void main(String[] args) {
        // User enter date with [dd/mm/yyyy] format
        String inputDate = inputDateFormat("Please enter date with format [dd/mm/yyyy]: ",
                "\\d{1,2}[/]\\d{1,2}[/]\\d{4}", "Date must be format [dd/mm/yyyy].");
        // check user input date exits
        boolean isDateExist = checkInputDateExist(inputDate);
        // Determine day of week with input date
        determineDayOfWeek(isDateExist, inputDate);
    }

    /**
     * This function if input Empty and incorrect with regex be tell wrong and
     * enter again else return
     *
     * @param message
     * @param regex
     * @param error
     * @return
     */
    private static String inputDateFormat(String message, String regex, String error) {
        System.out.print(message);
        // The loop user enter correct regex and not Empty be will return if no
        // enter again
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            // check input Empty 
            if (!input.isEmpty()) {
                // check input correct regex
                if (input.matches(regex)) {
                    if(checkInputDateExist(input)) {
                        return input;
                    }
                    else {
                        System.err.println("Date not Exist.");
                        System.out.print("Please enter again: ");
                    }
                    
                } // else tell wrong and enter again
                else {
                    System.err.println(error);
                    System.out.print("Please enter again: ");
                }
            } // else tell wrong and enter again
            else {
                System.err.println("Input not Empty.");
                System.out.print("Please enter again: ");
            }
        }
    }

    /**
     * This function if date exist and parse successfully be will return true
     * else it will return false
     *
     * @param inputDate
     * @return
     */
    private static boolean checkInputDateExist(String inputDate) {
        // Create object simpleDateFormat to check format of date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        // ensure date can exist 
        simpleDateFormat.setLenient(false);
        try {
            Date date = simpleDateFormat.parse(inputDate);
            // if parse success be date exist 
            return true;
        } catch (Exception e) {
            // else parse not success 
            return false;
        }
    }

    /**
     * This function if isDateExist is true and parse successfully, create
     * format to can parse day in week if isDateExist is false tell date not
     * exist
     *
     * @param isDateExist
     * @param inputDate
     */
    private static void determineDayOfWeek(boolean isDateExist, String inputDate) {
        // Create object simpleDateFormat to check format of date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        // if isDateExist is true be determine day of week
        if (isDateExist) {
            try {
                // parse success be will determine day in week
                Date date = simpleDateFormat.parse(inputDate);
                // determine date
                simpleDateFormat = new SimpleDateFormat("EEEE");
                System.out.println("Your day is " + simpleDateFormat.format(date));
            } catch (Exception e) {
            }
        } else {
            // else display date not exist
            System.out.println("Day of week is not Exist.");
        }
    }
}
