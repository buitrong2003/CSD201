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
        ViewDoctor view = new ViewDoctor();
        while (true) {
            // display menu
            view.displayMenu();
            // enter choice
            int choice = Validation.getInteger("Enter your choice: ", 1, 5,
                    "Number must be number Integer.");
            switch (choice) {
                // Add Doctor
                case 1:
                    view.addDoctor();
                    break;
                // Update Doctor
                case 2:
                    view.updateDoctor();
                    break;
                // Delete Doctor
                case 3:
                    view.deleteDoctor();
                    break;
                // Search Doctor
                case 4:
                    view.searchDoctor();
                    break;
                // exit
                case 5:
                    return;
            }

        }
    }
}
