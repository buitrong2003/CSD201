/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import utils.Validation;
import constant.Constant;
import controller.Manage;
import java.util.ArrayList;
import java.util.Date;
import model.Employee;

/**
 *
 * @author d
 */
public class ViewEmployee {

    Manage manage = new Manage();

    public void displayMenu() {
        System.out.println("Main menu:\n"
                + "1. Add employees \n"
                + "2. Update employees\n"
                + "3. Remove employees\n"
                + "4. Search employees\n"
                + "5. Sort employees by salary\n"
                + "6. Exit");
    }

    void addEmployee() {
        System.out.println("-------- Add employees --------");
        String id;
        while (true) {
            id = Validation.getString("Enter ID of Employee: ",
                    Constant.REGEX_STRING, "ID must be String.");
            if (manage.getEmployee(id) != null) {
                System.err.println("ID of Employee duplicate.");
            } else {
                break;
            }
        }
        String firstName = Validation.getString("Enter First Name of Employee: ",
                "[a-zA-Z ]+", "Name must be String.");
        String lastName = Validation.getString("Enter Last Name of Employee: ",
                "[a-zA-Z ]+", "Name must be String.");
        String phone;
        while (true) {
            phone = Validation.getString("Enter Phone of Employee: ", Constant.REGEX_PHONE,
                    "Phone not Valid.");
            if (manage.isDuplicatePhone(phone)) {
                System.err.println("Phone of Employee duplicate.");
            } else {
                break;
            }
        }
        String email;
        while (true) {
            email = Validation.getString("Enter Email of Employee: ", Constant.REGEX_EMAIL,
                    "Email must be String.");
            if (manage.isDuplicateEmail(email)) {
                System.err.println("Email of Employee duplicate.");
            } else {
                break;
            }
        }
        String address = Validation.getString("Enter Address of Employee: ",
                Constant.REGEX_STRING, "Address must be String.");
        Date dob = Validation.getDate("Enter DOB of Employee: ",
                Constant.REGEX_DATE, "Date must be format [dd/MM/yyyy].");
        int choice = Validation.getInteger("Enter Sex of Employee (0: Male; 1: Female): ",
                0, 1, "Choice mus be number Integer.");
        String sex;
        if (choice == 0) {
            sex = "Male";
        } else {
            sex = "Female";
        }
        double salary = Validation.getDouble("Enter Salary of Employee: ", 1,
                Double.MAX_VALUE, "Salary must be number Double.");
        String agency = Validation.getString("Enter Agency of Employee: ",
                Constant.REGEX_STRING, "Agency must be String.");
        Employee employee = new Employee(id, firstName, lastName, phone, email,
                address, dob, sex, salary, agency);
        manage.addEmployee(employee);
        System.out.println("Add successfully.");
    }

    void updateEmployee() {
        System.out.println("-------- Update employees --------");
        if (manage.listEmployee.isEmpty()) {
            System.out.println("List Employee Empty.");
        } else {
            String id = Validation.getString("Enter ID of Employee want Update: ",
                    Constant.REGEX_STRING, "ID must be String.");
            Employee employee = manage.getEmployee(id);
            if (employee == null) {
                System.out.println("Not found.");
            } else {
                System.out.println("You want to update:");
                System.out.println("1. Id\n"
                        + "2. FirstName\n"
                        + "3. LastName\n"
                        + "4. Phone\n"
                        + "5. Email\n"
                        + "6. Address\n"
                        + "7. Dob\n"
                        + "8. Sex\n"
                        + "9. Salary\n"
                        + "10. Agency");
                System.out.println("11. Update all properties.");
                int option = Validation.getInteger("Enter option you want Uppdate: ",
                        1, 11, "Option must be number Integer.");
                switch (option) {
                    case 1:
                        while (true) {
                            id = Validation.getString("Enter ID of Employee: ",
                                    Constant.REGEX_STRING, "ID must be String.");
                            if (!id.equalsIgnoreCase(employee.getId()) && manage.getEmployee(id) != null) {
                                System.err.println("ID Employee duplicate.");
                            } else if (id.equalsIgnoreCase(employee.getId())) {
                                System.out.println("You do not Update.");
                                break;
                            } else {
                                employee.setId(id);
                                System.out.println("Update successfully.");
                                break;
                            }
                        }
                        break;
                    case 2:
                        String firstName = Validation.getString("Enter First Name of Employee: ",
                                Constant.REGEX_STRING, "Name must be String.");
                        if (firstName.equalsIgnoreCase(employee.getFirstName())) {
                            System.out.println("You do not Update.");
                        } else {
                            employee.setFirstName(firstName);
                            System.out.println("Update successfully.");
                        }
                        break;
                    case 3:
                        String lastName = Validation.getString("Enter Last Name of Employee: ",
                                Constant.REGEX_STRING, "Name must be String.");
                        if (lastName.equalsIgnoreCase(employee.getLastName())) {
                            System.out.println("You do not Update.");
                        } else {
                            employee.setFirstName(lastName);
                            System.out.println("Update successfully.");
                        }
                        break;
                    case 4:
                        while (true) {
                            String phone = Validation.getString("Enter Phone of Employee: ", Constant.REGEX_PHONE,
                                    "Phone not Valid.");
                            if (!phone.equals(employee.getPhone()) && manage.isDuplicatePhone(phone)) {
                                System.out.println("Phone of Employee duplicate.");
                            } else if (phone.equals(employee.getPhone())) {
                                System.out.println("You do not update.");
                                break;
                            } else {
                                employee.setPhone(phone);
                                System.out.println("Update successfully.");
                                break;
                            }
                        }
                        break;
                    case 5:
                        while (true) {
                            String email = Validation.getString("Enter Email of Employee: ", Constant.REGEX_EMAIL,
                                    "Email must be String.");
                            if (!email.equalsIgnoreCase(employee.getEmail()) && manage.isDuplicateEmail(email)) {
                                System.out.println("Email of Employee duplicate.");
                            } else if (email.equalsIgnoreCase(email)) {
                                System.out.println("You do not Update.");
                                break;
                            } else {
                                employee.setEmail(email);
                                System.out.println("Update successfully.");
                                break;
                            }
                        }
                        break;
                    case 6:
                        String address = Validation.getString("Enter Address of Employee: ",
                                Constant.REGEX_STRING, "Address must be String.");
                        if (address.equalsIgnoreCase(employee.getAddress())) {
                            System.out.println("You do not Update.");
                        } else {
                            employee.setAddress(address);
                            System.out.println("Update successfully.");
                        }
                        break;
                    case 7:
                        Date dob = Validation.getDate("Enter DOB of Employee: ",
                                Constant.REGEX_DATE, "Date must be format [dd/MM/yyyy].");
                        if (dob.equals(employee.getDob())) {
                            System.out.println("You do not Update.");
                        } else {
                            employee.setDob(dob);
                            System.out.println("Update successfully.");
                        }
                        break;
                    case 8:
                        int choice = Validation.getInteger("Enter Sex of Employee (0: Male; 1: Female): ",
                                0, 1, "Choice mus be number Integer.");
                        String sex;
                        if (choice == 0) {
                            sex = "Male";
                        } else {
                            sex = "Female";
                        }
                        if (sex.equalsIgnoreCase(employee.getSex())) {
                            System.out.println("You do not Update.");
                        } else {
                            employee.setSex(sex);
                            System.out.println("Update successfully.");
                        }
                        break;
                    case 9:
                        double salary = Validation.getDouble("Enter Salary of Employee: ", 1,
                                Double.MAX_VALUE, "Salary must be number Double.");
                        if (salary == employee.getSalary()) {
                            System.out.println("You do not Update.");
                        } else {
                            employee.setSalary(salary);
                            System.out.println("Update successfully.");
                        }
                        break;
                    case 10:
                        String agency = Validation.getString("Enter Agency of Employee: ",
                                Constant.REGEX_STRING, "Agency must be String.");
                        if (agency.equalsIgnoreCase(employee.getAgency())) {
                            System.out.println("You do not Update.");
                        } else {
                            System.out.println("Update successfully.");
                        }
                        break;
                    case 11:
                        id = Validation.getString("Enter ID of Employee: ",
                                Constant.REGEX_STRING, "ID must be String.");
                        firstName = Validation.getString("Enter First Name of Employee: ",
                                Constant.REGEX_STRING, "Name must be String.");
                        lastName = Validation.getString("Enter Last Name of Employee: ",
                                Constant.REGEX_STRING, "Name must be String.");
                        String phone = Validation.getString("Enter Phone of Employee: ", Constant.REGEX_PHONE,
                                "Phone must be Disgit.");
                        String email = Validation.getString("Enter Email of Employee: ", Constant.REGEX_EMAIL,
                                "Email must be String.");
                        address = Validation.getString("Enter Address of Employee: ",
                                Constant.REGEX_STRING, "Address must be String.");
                        dob = Validation.getDate("Enter DOB of Employee: ",
                                Constant.REGEX_DATE, "Date must be format [dd/MM/yyyy].");
                        choice = Validation.getInteger("Enter Sex of Employee (0: Male; 1: Female): ",
                                0, 1, "Choice mus be number Integer.");
                        if (choice == 0) {
                            sex = "Male";
                        } else {
                            sex = "Female";
                        }
                        salary = Validation.getDouble("Enter Salary of Employee: ", 1,
                                Double.MAX_VALUE, "Salary must be number Double.");
                        agency = Validation.getString("Enter Agency of Employee: ",
                                Constant.REGEX_STRING, "Agency must be String.");
                        if (!id.equalsIgnoreCase(employee.getId()) && manage.getEmployee(id) != null
                                || !phone.equals(employee.getPhone()) && manage.isDuplicatePhone(phone)
                                || !email.equalsIgnoreCase(employee.getEmail()) && manage.isDuplicateEmail(email)) {
                            System.out.println("Duplicate.");
                        } else {
                            if (id.equalsIgnoreCase(employee.getId()) && firstName.equalsIgnoreCase(employee.getFirstName())
                                    && lastName.equalsIgnoreCase(employee.getLastName()) && phone.equals(employee.getPhone())
                                    && email.equalsIgnoreCase(employee.getEmail()) && address.equalsIgnoreCase(employee.getAddress())
                                    && dob.equals(employee.getDob()) && sex.equalsIgnoreCase(employee.getSex())
                                    && salary == employee.getSalary() && agency.equalsIgnoreCase(employee.getAgency())) {
                                System.out.println("You do not Update.");
                            } else {
                                if (manage.checkEmployExist(id, firstName, lastName, phone, email,
                                        address, dob, sex, salary, agency)) {
                                    System.out.println("Duplicate.");
                                } else {
                                    employee.setId(id);
                                    employee.setFirstName(firstName);
                                    employee.setLastName(lastName);
                                    employee.setPhone(phone);
                                    employee.setEmail(email);
                                    employee.setAddress(address);
                                    employee.setDob(dob);
                                    employee.setSex(sex);
                                    employee.setSalary(salary);
                                    employee.setAgency(agency);
                                    System.out.println("Update successfully.");
                                }
                            }
                        }
                        break;
                }
            }
        }
    }

    void removeEmployee() {
        System.out.println("-------- Remove employees --------");
        if (manage.listEmployee.isEmpty()) {
            System.out.println("List Employee Empty.");
        } else {
            String id = Validation.getString("Enter ID of Employee: ",
                    Constant.REGEX_STRING, "ID must be String.");
            Employee employee = manage.getEmployee(id);
            if (employee == null) {
                System.out.println("Not found.");
            } else {
                manage.listEmployee.remove(employee);
                System.out.println("Remove successfully.");
            }
        }
    }

    void searchEmployee() {
        System.out.println("-------- Search employees --------");
        if (manage.listEmployee.isEmpty()) {
            System.out.println("List Employee Empty.");
        } else {
            String name = Validation.getString("Enter First Name or Last Name of Employee: ",
                    Constant.REGEX_STRING, "Name must be String.");
            ArrayList<Employee> listSearchByName = manage.getListSearchByName(name);
            if (listSearchByName.isEmpty()) {
                System.out.println("Not found.");
            } else {
                System.out.printf("%-15s %-15s %-15s %-15s %-15s %-25s %-15s %-15s %-15s %-15s\n", "ID", "FirstName", "LastName",
                        "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
                for (Employee employee : listSearchByName) {
                    employee.display();
                }
            }
        }
    }

    void sortEmployee() {
        System.out.println("-------- Sort employees by salary --------");
        if (manage.listEmployee.isEmpty()) {
            System.out.println("List Employee Empty.");
        } else {
            int choice = Validation.getInteger("Enter choice (1. Sort salary ascending, 2. Sort salary decrease: ", 1, 2, "Choice must be number Integer.");
            manage.sortEmployeeBySalary(choice);
            System.out.printf("%-15s %-15s %-15s %-15s %-15s %-25s %-15s %-15s %-15s %-15s\n", "ID", "FirstName", "LastName",
                    "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
            for (Employee employee : manage.listEmployee) {
                employee.display();
            }
        }
    }
}
