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
        ViewFruit view = new ViewFruit();
        while (true) {
            // display menu
            view.displayMenu();
            // choice option
            int choice = Validation.getInteger("Enter your choice: ", 1, 4,
                    "Choice must be number Integer.");
            switch (choice) {
                // Create Fruit
                case 1:
                    view.createFruit();
                    break;
                // View orders
                case 2:
                    view.viewOrder();
                    break;
                // Shopping (for buyer)
                case 3:
                    view.shopping();
                    break;
                // exit
                case 4:
                    return;
            }
        }
    }
}
