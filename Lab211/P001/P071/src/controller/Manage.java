/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Date;
import model.Task;

/**
 *
 * @author d
 */
public class Manage {

    public ArrayList<Task> listTask;

    public Manage() {
        listTask = new ArrayList<>();
    }

    public void addTask(Task task) {
        listTask.add(task);
    }

    public boolean isOverLap(Date date, String assignee, double planFrom, double planTo) {
        for (Task task : listTask) {
            if (date.equals(task.getDate()) && assignee.equalsIgnoreCase(task.getAssignee())) {
                if (planFrom < task.getPlanFrom() && planTo > task.getPlanFrom()) {
                    return true;
                }
                if (planFrom == task.getPlanFrom() || planFrom == task.getPlanTo()) {
                    return true;
                }
                if (planFrom > task.getPlanFrom() && planFrom < task.getPlanTo()) {
                    return true;
                }
            }
        }
        return false;
    }

    public Task getTask(int id) {
        for (Task task : listTask) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public boolean checkTaskExist(int idUpdate, int taskTypeID, String requirementName, Date date, double planFrom, double planTo, String assignee, String reviewer) {
        for (Task task : listTask) {
            if (idUpdate == task.getId() && taskTypeID == task.getTaskTypeID() && requirementName.equalsIgnoreCase(task.getRequirementName())
                    && date.equals(task.getDate()) && planFrom == task.getPlanFrom() && planTo == task.getPlanTo()
                    && assignee.equalsIgnoreCase(task.getAssignee()) && reviewer.equalsIgnoreCase(task.getReviewer())) {
                return true;
            }
        }
        return false;
    }

}
