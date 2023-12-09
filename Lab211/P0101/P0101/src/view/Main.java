/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import utils.Validation;

/**
 *
 * @author d
 */
public class Main {

    public static void main(String[] args) {
        ViewEmployee view = new ViewEmployee();
        while (true) {
            // display menu
            view.displayMenu();
            // enter option
            int choice = Validation.getInteger("Enter your choice: ", 1, 6,
                    "Choice must be number Integer.");
            switch (choice) {
                // Add employees
                case 1:
                    view.addEmployee();
                    break;
                // Update employees
                case 2:
                    view.updateEmployee();
                    break;
                // Remove employees
                case 3:
                    view.removeEmployee();
                    break;
                // Search employees
                case 4:
                    view.searchEmployee();
                    break;
                // Sort employees by salary
                case 5:
                    view.sortEmployee();
                    break;
                // Exit
                case 6:
                    return;
            }
        }
    }
}
