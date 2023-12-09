/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Manage;
import controller.Validation;
import java.util.ArrayList;
import java.util.Map;
import model.Student;

/**
 *
 * @author d
 */
public class ViewStudent {

    Manage manage = new Manage();

    void displayMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
    }

    void createStudent() {
        System.out.println("-------- Create --------");
        while (true) {
            if (manage.listStudent.size() >= 10) {
                if (!Validation.checkInputYN("Do you want to continue? (y/n): ",
                        "Input must be y/Y or n/N")) {
                    break;
                }
            }
            String id = Validation.getString("Enter ID of Student: ", "[a-zA-Z0-9 ]+",
                    "ID must be String.");
            String name = Validation.getString("Enter Name of Student: ", "[a-zA-Z ]+",
                    "Name must be String.");
            if (manage.checkIDAndName(id, name)) {
                System.out.println("ID of Student Exist.");
                continue;
            }
            String semester = Validation.getString("Enter Semester of Student: ", "[a-zA-Z0-9 ]+",
                    "Course must be String.");
            String course = Validation.getCourse("Enter Course of Student: ",
                    "There are three course: Java, .Net or C/C++");
            if (manage.isStudentExist(id, name, semester, course)) {
                System.out.println("This record is existed.");
            } else {
                Student student = new Student(id, name, semester, course);
                manage.listStudent.add(new Student(id, "an", semester, course));
                if (manage.checkIDAndName(id, name)) {
                    System.out.println("Id Exist.");
                    continue;
                }
                if (manage.isStudentExist(id, name, semester, course)) {
                    System.out.println("This record is existed.");
                } else {
                    manage.addStudent(student);
                    System.out.println("Add successfully.");
                }
            }

        }
    }

    void findAndSort() {
        System.out.println("-------- Find and Sort --------");
        if (manage.listStudent.isEmpty()) {
            System.out.println("List Student Empty.");
        } else {
            String name = Validation.getString("Enter Name of Student: ", "[a-zA-Z ]+",
                    "Name must be String.");
            ArrayList<Student> listStudentByName = manage.getListStudentByName(name);
            if (listStudentByName.isEmpty()) {
                System.out.println("Not found.");
            } else {
                manage.sortStudentByName(listStudentByName);
                System.out.printf("%-7s | %-15s | %-10s | %-7s\n", "ID", "Name", "Semester", "Course");
                for (Student student : listStudentByName) {
                    student.display();
                }
            }
        }
    }

    void updateOrDelete() {
        System.out.println("-------- Update/Delete --------");
        if (manage.listStudent.isEmpty()) {
            System.out.println("List Student Empty.");
        } else {
            String id = Validation.getString("Enter ID Student: ", "[a-zA-Z0-9 ]+",
                    "ID must be String.");
            ArrayList<Student> listStudentByID = manage.getListStudentByID(id);
            if (listStudentByID.isEmpty()) {
                System.out.println("Not found.");
            } else {
                System.out.printf("%-15s | %-7s | %-15s | %-10s | %-7s\n", "Numerical Order",
                        "ID", "Name", "Semester", "Course");
                manage.displayStudent(listStudentByID);
                int index = Validation.getInteger("Enter numerical order of Student want update or delete: ",
                        1, listStudentByID.size(),
                        "Numerical order must be Integer.");
                Student student = listStudentByID.get(index - 1);
                if (Validation.checkInputUD("Do you want to update(U) or delete(D) student: ",
                        "Input must be u/U or d/D")) {
                    String idUpdate = student.getId();
                    String nameUpdate = student.getName();
                    String semesterUpdate = student.getSemester();
                    String courseUpdate = student.getCourse();
                    if (Validation.checkInputYN("You want update ID? (y/n): ", "Input must be y/Y or n/N")) {
                        idUpdate = Validation.getString("Enter ID of Student: ", "[a-zA-Z0-9 ]+",
                                "ID must be String.");
                    }
                    if (Validation.checkInputYN("You want update Name? (y/n): ", "Input must be y/Y or n/N")) {
                        nameUpdate = Validation.getString("Enter Name of Student: ", "[a-zA-Z ]+",
                                "Name must be String.");
                    }
                    if (Validation.checkInputYN("You want update Semester? (y/n): ", "Input must be y/Y or n/N")) {
                        semesterUpdate = Validation.getString("Enter Semester of Student: ", "[a-zA-Z0-9 ]+",
                                "Course must be String.");
                    }
                    if (Validation.checkInputYN("You want update Course? (y/n): ", "Input must be y/Y or n/N")) {
                        courseUpdate = Validation.getCourse("Enter Course of Student: ",
                                "There are three course: Java, .Net or C/C++");
                    }
                    if (idUpdate.equalsIgnoreCase(student.getId()) && nameUpdate.equalsIgnoreCase(student.getName()) && semesterUpdate.equalsIgnoreCase(student.getSemester())
                            && courseUpdate.equalsIgnoreCase(student.getCourse())) {
                        System.out.println("You not Update.");
                    } else if (manage.isStudentExist(idUpdate, nameUpdate, semesterUpdate, courseUpdate)) {
                        System.out.println("Duplicate.");
                    } else if (manage.checkIDAndName(idUpdate, nameUpdate) && manage.checkIDSemesterCourse(idUpdate, semesterUpdate, courseUpdate)
                            && !idUpdate.equalsIgnoreCase(student.getId())) {
                        System.out.println("Duplicate.");
                    } else if (idUpdate.equalsIgnoreCase(student.getId()) && manage.checkIDAndName(idUpdate, nameUpdate)
                            && manage.checkIDSemesterCourse(idUpdate, semesterUpdate, courseUpdate)
                            && !semesterUpdate.equalsIgnoreCase(student.getSemester())
                            && !courseUpdate.equalsIgnoreCase(student.getCourse())) {
                        System.out.println("Duplicate.");
                    } else {
                        student.setId(idUpdate);
                        manage.setAllNameStudent(idUpdate, nameUpdate);
                        student.setName(nameUpdate);
                        student.setSemester(semesterUpdate);
                        student.setCourse(courseUpdate);
                        System.out.println("Update successfully.");
                    }
                } else {
                    manage.listStudent.remove(student);
                    System.out.println("Remove successfully.");
                }
            }
        }
    }

    void reportStudent() {
        System.out.println("-------- Report --------");
        if (manage.listStudent.isEmpty()) {
            System.out.println("List Student Empty.");
        } else {
            Map<String, Integer> listReport = manage.getListReport();
            System.out.printf("%-10s | %-10s | %-5s\n", "Name", "Course", "Total");
            manage.displayListReport(listReport);
        }
    }
}
