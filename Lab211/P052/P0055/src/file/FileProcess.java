/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Doctor;

/**
 *
 * @author d
 */
public class FileProcess {

    public static void writeFile(String fileName, Doctor doctor) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(doctor.getCode() + ", " + doctor.getName()
                    + ", " + doctor.getSpecialization() + ", " + doctor.getAvailability());
            bufferedWriter.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }

    public static ArrayList<Doctor> readFromFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        ArrayList<Doctor> listDoctor = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] data = line.split("[,]");
                String code = data[0].trim();
                String name = data[1].trim();
                String specialization = data[2].trim();
                int availability = Integer.parseInt(data[3].trim());
                listDoctor.add(new Doctor(code, name, specialization, availability));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return listDoctor;
    }
}
