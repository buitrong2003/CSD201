/*
 * Copyright(C) Bui Duc Trong
 * J1.S.P0052
 * Manage Geographic
 */
package view;

import validation.Validation;


/**
 *
 * @author Bui Duc Trong
 */
public class Main {

    private static void displayMenu() {
        System.out.println("                               MENU\n"
                + "==========================================================================\n"
                + "1. Input the information of 11 countries in East Asia\n"
                + "2. Display the information of country you've just input\n"
                + "3. Search the information of country by user-entered name\n"
                + "4. Display the information of countries sorted name in ascending order  \n"
                + "5. Exit \n"
                + "==========================================================================");
    }

    public static void main(String[] args) {
        ViewCountry view = new ViewCountry();
        while (true) {
            // display menu
            displayMenu();
            // enter option function
            int choice = Validation.getInteger("Enter yout choice:", 1, 5, "Number must be number Integer");
            switch (choice) {
                // 1. Input the information of 11 countries in East Asia
                case 1:
                    view.inputCountry();
                    break;
                // 2. Display the information of country you've just input
                case 2:
                    view.displayInformationofCountryJustInput();
                    break;
                // 3. Search the information of country by user-entered name
                case 3:
                    view.searchCountriesByName();
                    break;
                // 4. Display the information of countries sorted name in ascending order  
                case 4:
                    view.sortCountryByName();
                    break;
                // 5. Exit
                case 5:
                    System.out.println("-------- Exit --------");
                    return;
            }
        }
    }
}
