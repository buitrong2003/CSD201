/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Manage;
import controller.Validation;
import java.util.ArrayList;
import model.Doctor;

/**
 *
 * @author d
 */
public class ViewDoctor {

    Manage manage = new Manage();

    void displayMenu() {
        System.out.println("========= Doctor Management =========");
        System.out.println("1. Add Doctor");
        System.out.println("2. Update Doctor");
        System.out.println("3. Delete Doctor");
        System.out.println("4. Search Doctor");
        System.out.println("5. Exit");
    }

    void addDoctor() {
        System.out.println("-------- Add Doctor --------");
        String code;
        while (true) {
            code = Validation.getString("Enter Code: ", "[Dd][Oo][Cc][ ][0-9]+",
                    "Code must be String.");
            if (manage.getDoctor(code) != null) {
                System.err.println("ID Doctor duplicate.");
            } else {
                break;
            }
        }
        String name = Validation.getString("Enter Name: ", "[a-zA-Z ]+",
                "Name must be String.");
        System.out.println("1. Department of internal medicine\n"
                + "2. Surgery\n"
                + "3. Obstetric\n"
                + "4. Pediatrics\n"
                + "5. Department of Infectious Diseases");
        int choice = Validation.getInteger("Enter your choice specialization: ", 1, 5,
                "Choice must be number Integer.");
        String specialization = null;
        if (choice == 1) {
            specialization = "Department of internal medicine";
        } else if (choice == 2) {
            specialization = "Surgery";
        } else if (choice == 3) {
            specialization = "Obstetric";
        } else if (choice == 4) {
            specialization = "Pediatrics";
        } else {
            specialization = "Department of Infectious Diseases";
        }
        int availability = Validation.getInteger("Enter Availability: ", 0, Integer.MAX_VALUE,
                "Availability must be number Integer.");
        Doctor doctor = new Doctor(code, name, specialization, availability);
        manage.addDoctor(doctor);
        System.out.println("Add successfully.");
        manage.writeFile(doctor);
    }

    void updateDoctor() {
        System.out.println("-------- Update Doctor --------");
        if (manage.listDoctor.isEmpty()) {
            System.out.println("List Doctor Empty.");
        } else {
            String code = Validation.getString("Enter Code: ", "[Dd][Oo][Cc][ ][0-9]+",
                    "Code must be String.");
            Doctor doctor = manage.getDoctor(code);
            if (doctor == null) {
                System.out.println("Not found.");
            } else {
                String codeUpdate = doctor.getCode();
                String nameUpdate = doctor.getName();
                String specializationUpdate = doctor.getSpecialization();
                int availabilityUpdate = doctor.getAvailability();
                if (Validation.checkInputYN("You want update Code? (y/n): ", "Input must be y/Y or n/N/.")) {
                    codeUpdate = Validation.getString("Enter Code: ", "[Dd][Oo][Cc][ ][0-9]+",
                            "Code must be String.");
                }
                if (Validation.checkInputYN("You want update Name? (y/n): ", "Input must be y/Y or n/N/.")) {
                    nameUpdate = Validation.getString("Enter Name: ", "[a-zA-Z ]+",
                            "Name must be String.");
                }
                if (Validation.checkInputYN("You want update Specialization? (y/n): ", "Input must be y/Y or n/N/.")) {
                    System.out.println("1. Department of internal medicine\n"
                            + "2. Surgery\n"
                            + "3. Obstetric\n"
                            + "4. Pediatrics\n"
                            + "5. Department of Infectious Diseases");
                    int choice = Validation.getInteger("Enter your choice specialization: ", 1, 5,
                            "Choice must be number Integer.");
                    if (choice == 1) {
                        specializationUpdate = "Department of internal medicine";
                    } else if (choice == 2) {
                        specializationUpdate = "Surgery";
                    } else if (choice == 3) {
                        specializationUpdate = "Obstetric";
                    } else if (choice == 4) {
                        specializationUpdate = "Pediatrics";
                    } else {
                        specializationUpdate = "Department of Infectious Diseases";
                    }
                }
                if (Validation.checkInputYN("You want update Availability? (y/n): ", "Input must be y/Y or n/N/.")) {
                    availabilityUpdate = Validation.getInteger("Enter Availability: ", 0, Integer.MAX_VALUE,
                            "Availability must be number Integer.");
                }
                if (codeUpdate.equalsIgnoreCase(doctor.getCode()) && nameUpdate.equalsIgnoreCase(doctor.getName())
                        && specializationUpdate.equalsIgnoreCase(doctor.getSpecialization()) && availabilityUpdate == doctor.getAvailability()) {
                    System.out.println("You not Update.");
                } else if ((manage.checkDoctorExist(codeUpdate, nameUpdate, specializationUpdate, availabilityUpdate)
                        || manage.getDoctor(codeUpdate) != null) && !codeUpdate.equalsIgnoreCase(doctor.getCode())) {
                    System.out.println("Duplicate.");
                } else {
                    doctor.setCode(codeUpdate);
                    doctor.setName(nameUpdate);
                    doctor.setSpecialization(specializationUpdate);
                    doctor.setAvailability(availabilityUpdate);
                    System.out.println("Update successfully.");

                }
            }
        }
    }

    void deleteDoctor() {
        System.out.println("-------- Delete Doctor --------");
        if (manage.listDoctor.isEmpty()) {
            System.out.println("List Doctor Empty.");
        } else {
            String code = Validation.getString("Enter Code: ", "[Dd][Oo][Cc][ ][0-9]+",
                    "Code must be String.");
            Doctor doctor = manage.getDoctor(code);
            if (doctor == null) {
                System.out.println("Not found.");
            } else {
                manage.listDoctor.remove(doctor);
                System.out.println("Remove successfully.");

            }
        }
    }

    void searchDoctor() {
        System.out.println("-------- Search Doctor --------");
        if (manage.listDoctor.isEmpty()) {
            System.out.println("List Doctor Empty.");
        } else {
            String text = Validation.getString("Enter text: ", "[a-zA-Z0-9 ]+",
                    "Text must be String.");
            ArrayList<Doctor> listDoctorByText = manage.getListDoctorByText(text);
            if (listDoctorByText.isEmpty()) {
                System.out.println("Not found.");
            } else {
                System.out.printf("%-10s %-15s %-35s %33s\n",
                        "Code", "Name", "Specialization", "Availability");
                manage.displayDoctor(listDoctorByText);
            }
        }
    }

}
