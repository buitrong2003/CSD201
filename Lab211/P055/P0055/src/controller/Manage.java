/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import file.FileProcess;
import java.util.ArrayList;
import model.Doctor;

/**
 *
 * @author d
 */
public class Manage {

    public ArrayList<Doctor> listDoctor;

    public Manage() {
        listDoctor = FileProcess.readFromFile("listDoctor.txt");
    }

    public void writeFile(Doctor doctor) {
        FileProcess.writeFile("listDoctor.txt", doctor);
    }

    public Doctor getDoctor(String code) {
        for (Doctor doctor : listDoctor) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    public void addDoctor(Doctor doctor) {
        listDoctor.add(doctor);
    }

    public boolean checkDoctorExist(String codeUpdate, String nameUpdate, String specializationUpdate, int availabilityUpdate) {
        for (Doctor doctor : listDoctor) {
            if (codeUpdate.equalsIgnoreCase(doctor.getCode()) && nameUpdate.equalsIgnoreCase(doctor.getName())
                    && specializationUpdate.equalsIgnoreCase(doctor.getSpecialization()) && availabilityUpdate == doctor.getAvailability()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Doctor> getListDoctorByText(String text) {
        ArrayList<Doctor> listDoctorByText = new ArrayList<>();
        for (Doctor doctor : listDoctor) {
            String data = doctor.getCode() + doctor.getName() + doctor.getSpecialization() + doctor.getAvailability();
            if (data.contains(data)) {
                listDoctorByText.add(doctor);
            }
        }
        return listDoctorByText;
    }

    public void displayDoctor(ArrayList<Doctor> listDoctorByText) {
        for (Doctor doctor : listDoctorByText) {
            doctor.displayDoctor();
        }
    }

}
