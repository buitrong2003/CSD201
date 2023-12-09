/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Validation;

/**
 *
 * @author d
 */
public class Main {

    public static void main(String[] args) {
        ViewStudent view = new ViewStudent();
        while (true) {
            // display menu
            view.displayMenu();
            // enter choice
            int choice = Validation.getInteger("Enter your choice: ", 1, 5,
                    "Choice must be number Integer.");
            switch (choice) {
                // Create
                case 1:
                    view.createStudent();
                    break;
                // Find and Sort
                case 2:
                    view.findAndSort();
                    break;
                // Update/Delete
                case 3:
                    view.updateOrDelete();
                    break;
                // Report
                case 4:
                    view.reportStudent();
                    break;
                // Exit
                case 5:
                    return;
            }
        }
    }
}
