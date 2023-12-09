/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import model.Employee;

/**
 *
 * @author d
 */
public class Manage {

    public ArrayList<Employee> listEmployee;

    public Manage() {
        listEmployee = new ArrayList<>();
    }

    public Employee getEmployee(String id) {
        for (Employee employee : listEmployee) {
            if (employee.getId().equalsIgnoreCase(id)) {
                return employee;
            }
        }
        return null;
    }

    public boolean isDuplicatePhone(String phone) {
        for (Employee employee : listEmployee) {
            if (employee.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public boolean isDuplicateEmail(String email) {
        for (Employee employee : listEmployee) {
            if (employee.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public void addEmployee(Employee employee) {
        listEmployee.add(employee);
    }

    public boolean checkEmployExist(String id, String firstName, String lastName, String phone, String email, String address, Date dob, String sex, double salary, String agency) {
        for (Employee employee : listEmployee) {
            if (id.equalsIgnoreCase(employee.getId()) && firstName.equalsIgnoreCase(employee.getFirstName())
                    && lastName.equalsIgnoreCase(employee.getLastName()) && phone.equals(employee.getPhone())
                    && email.equalsIgnoreCase(employee.getEmail()) && address.equalsIgnoreCase(employee.getAddress())
                    && dob.equals(employee.getDob()) && sex.equalsIgnoreCase(employee.getSex())
                    && salary == employee.getSalary() && agency.equalsIgnoreCase(employee.getAgency())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Employee> getListSearchByName(String name) {
        ArrayList<Employee> listSearchByName = new ArrayList<>();
        for (Employee employee : listEmployee) {
            if (employee.getFirstName().toUpperCase().contains(name.toUpperCase())
                    || employee.getLastName().toUpperCase().contains(name.toUpperCase())) {
                listSearchByName.add(employee);
            }
        }
        return listSearchByName;
    }

    public void sortEmployeeBySalary(int mode) {
        Collections.sort(listEmployee, new Comparator<Employee>() {
            @Override
            public int compare(Employee firstEmployee, Employee secondEmployee) {
                if (mode == 1) {
                    return Double.compare(firstEmployee.getSalary(), secondEmployee.getSalary());
                } else {
                    return Double.compare(secondEmployee.getSalary(), firstEmployee.getSalary());
                }
            }
        });
    }
}
