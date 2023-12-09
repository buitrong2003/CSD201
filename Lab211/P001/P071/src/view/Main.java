/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author d
 */
public class Main {

    public static void main(String[] args) {
        ViewTask view = new ViewTask();
        while (true) {
            // display menu
            view.displayMenu();
            // enter choice
            int choice = Validation.getInteger("Enter your choice: ", 1, 5,
                    "Choice must be number Integer.");
            switch (choice) {
                // Add Task
                case 1:
                    view.addTask();
                    break;
                // Delete task
                case 2:
                    view.deleteTask();
                    break;
                // Display Task
                case 3:
                    view.displayTask();
                    break;
                // exit
                case 4:
                    return;
                case 5:
                    view.updateTask();
                    break;
            }
        }
    }
}
