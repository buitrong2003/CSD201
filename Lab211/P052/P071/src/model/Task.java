/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author d
 */
public class Task {
    
    private static int auto_Increment = 1;
    private int id;
    private int taskTypeID;
    private String requirementName;
    private Date date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;
    
    public Task(int taskTypeID, String requirementName, Date date, double planFrom, double planTo, String assignee, String reviewer) {
        this.id = auto_Increment++;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getTaskTypeID() {
        return taskTypeID;
    }
    
    public void setTaskTypeID(int taskTypeID) {
        this.taskTypeID = taskTypeID;
    }
    
    public String getRequirementName() {
        return requirementName;
    }
    
    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public double getPlanFrom() {
        return planFrom;
    }
    
    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }
    
    public double getPlanTo() {
        return planTo;
    }
    
    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }
    
    public String getAssignee() {
        return assignee;
    }
    
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }
    
    public String getReviewer() {
        return reviewer;
    }
    
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    
    public String getTaskType(int taskTypeID) {
        String result = null;
        switch (taskTypeID) {
            case 1:
                result = "Code";
                break;
            case 2:
                result = "Test";
                break;
            case 3:
                result = "Design";
                break;
            case 4:
                result = "Review";
                break;
        }
        return result;
    }
    
    public void display() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.printf("%-5d %-15s %-15s %-15s %-15.1f %-15s %-15s\n", id, requirementName, getTaskType(taskTypeID),
                simpleDateFormat.format(date), (planTo - planFrom), assignee, reviewer);
    }
}
