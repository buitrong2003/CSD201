/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Manage;
import java.util.Date;
import model.Task;

/**
 *
 * @author d
 */
public class ViewTask {

    Manage manage = new Manage();

    public static void displayMenu() {
        System.out.println("========= Task program =========\n"
                + "1.	Add Task\n"
                + "2.	Delete task\n"
                + "3.	Display Task\n"
                + "4.	exit");
        System.out.println("5.   Update Task.");
    }

    void addTask() {
        System.out.println("------------Add Task---------------");
        String requirementName = Validation.getString("Requirement Name: ", "[a-zA-Z ]+",
                "Requirement Name must be String.");
        int taskTypeID = Validation.getInteger("Task Type: ", 1, 4,
                "Number must be number Integer.");
        Date date = Validation.getDate("Date: ", "\\d{1,2}[-]\\d{1,2}[-]\\d{4}",
                "Date must be format: [dd-MM-yyyy].");
        double planFrom;
        while (true) {
            planFrom = Validation.getDouble("From: ", 8, 17,
                    "Plan From must be number Double.");
            if (planFrom % 0.5 == 0) {
                break;
            } else {
                System.err.println("Plan From not Valid.");
            }
        }
        double planTo;
        while (true) {
            planTo = Validation.getDouble("To: ", planFrom + 0.5, 17.5,
                    "Plan To must be number Double.");
            if (planTo % 0.5 == 0) {
                break;
            } else {
                System.err.println("Plan To not Valid.");
            }
        }
        String assignee = Validation.getString("Assignee: ", "[a-zA-Z ]+",
                "Assignee must be String.");
        String reviewer = Validation.getString("Reviewer: ", "[a-zA-Z ]+",
                "Reviewer must be String.");
        if (!manage.isOverLap(date, assignee, planFrom, planTo)) {
            Task task = new Task(taskTypeID, requirementName, date, planFrom, planTo, assignee, reviewer);
            manage.addTask(task);
            System.out.println("Add successfully.");
        } else {
            System.out.println("Overlap Task.");
        }
    }

    void deleteTask() {
        System.out.println("---------Del Task------");
        if (manage.listTask.isEmpty()) {
            System.out.println("List Task Empty.");
        } else {
            int id = Validation.getInteger("ID: ", 1, Integer.MAX_VALUE,
                    "ID must be number Integer.");
            Task task = manage.getTask(id);
            if (task == null) {
                System.out.println("Not found.");
            } else {
                manage.listTask.remove(task);
                System.out.println("Remove successfully.");
            }
        }
    }

    void displayTask() {
        System.out.println("----------------------------------------- Task ---------------------------------------");
        if (manage.listTask.isEmpty()) {
            System.out.println("List Task Empty.");
        } else {
            System.out.printf("%-5s %-15s %-15s %-15s %-15s %-15s %-15s\n", "ID", "Name", "Task Type",
                    "Date", "Time", "Assignee", "Reviewer");
            for (Task task : manage.listTask) {
                task.display();
            }
        }
    }

    void updateTask() {
        if (manage.listTask.isEmpty()) {
            System.out.println("List Task Empty.");
        } else {
            int id = Validation.getInteger("ID: ", 1, Integer.MAX_VALUE,
                    "ID must be number Integer.");
            Task task = manage.getTask(id);
            if (task == null) {
                System.out.println("Not found.");
            } else {
                int idUpdate = task.getId();
                int taskTypeID = task.getTaskTypeID();
                String requirementName = task.getRequirementName();
                Date date = task.getDate();
                double planFrom = task.getPlanFrom();
                double planTo = task.getPlanTo();
                String assignee = task.getAssignee();
                String reviewer = task.getReviewer();
                if (Validation.checkInputYN("You want update Id? (y/n): ", "Please enter y/Y or n/N")) {
                    idUpdate = Validation.getInteger("Enter Id Update: ", 1,
                            Integer.MAX_VALUE, "ID must be number Integer.");
                }
                if (Validation.checkInputYN("You want update requirementName? (y/n): ", "Please enter y/Y or n/N")) {
                    requirementName = Validation.getString("Requirement Name: ", "[a-zA-Z ]+",
                            "Requirement Name must be String.");
                }
                if (Validation.checkInputYN("You want update TypeID? (y/n): ", "Please enter y/Y or n/N")) {
                    taskTypeID = Validation.getInteger("Task Type: ", 1, 4,
                            "Number must be number Integer.");
                }
                if (Validation.checkInputYN("You want update Date? (y/n): ", "Please enter y/Y or n/N")) {
                    date = Validation.getDate("Date: ", "\\d{1,2}[-]\\d{1,2}[-]\\d{4}",
                            "Date must be format: [dd-MM-yyyy].");
                }
                if (Validation.checkInputYN("You want update From? (y/n): ", "Please enter y/Y or n/N")) {
                    while (true) {
                        planFrom = Validation.getDouble("From: ", 8, 17,
                                "Plan From must be number Double.");
                        if (planFrom % 0.5 == 0) {
                            break;
                        } else {
                            System.err.println("Plan From not Valid.");
                        }
                    }
                }
                if (Validation.checkInputYN("You want update To? (y/n): ", "Please enter y/Y or n/N")) {
                    while (true) {
                        planTo = Validation.getDouble("To: ", planFrom + 0.5, 17.5,
                                "Plan To must be number Double.");
                        if (planTo % 0.5 == 0) {
                            break;
                        } else {
                            System.err.println("Plan To not Valid.");
                        }
                    }
                }
                if (Validation.checkInputYN("You want update Assignee? (y/n): ", "Please enter y/Y or n/N")) {
                    assignee = Validation.getString("Assignee: ", "[a-zA-Z ]+",
                            "Assignee must be String.");
                }
                if (Validation.checkInputYN("You want update Reviewer? (y/n): ", "Please enter y/Y or n/N")) {
                    reviewer = Validation.getString("Reviewer: ", "[a-zA-Z ]+",
                            "Reviewer must be String.");
                }
                if (task.getId() == idUpdate && taskTypeID == task.getTaskTypeID()
                        && requirementName.equalsIgnoreCase(task.getRequirementName())
                        && date.equals(task.getDate()) && planFrom == task.getPlanFrom()
                        && planTo == task.getPlanTo() && assignee.equalsIgnoreCase(task.getAssignee())
                        && reviewer.equalsIgnoreCase(task.getReviewer())) {
                    System.out.println("You not Update.");
                } else if (manage.checkTaskExist(idUpdate, taskTypeID, requirementName, date, planFrom, planTo,
                        assignee, reviewer)) {
                    System.out.println("Duplicate.");
                } else if (manage.isOverLap(date, assignee, planFrom, planTo)) {
                    System.out.println("Overlap Task. Not Update");
                } else {
                    task.setId(idUpdate);
                    task.setTaskTypeID(taskTypeID);
                    task.setRequirementName(requirementName);
                    task.setDate(date);
                    task.setPlanFrom(planFrom);
                    task.setPlanTo(planTo);
                    task.setAssignee(assignee);
                    task.setReviewer(reviewer);
                    System.out.println("Update successfully.");
                }
            }
        }
    }
}
