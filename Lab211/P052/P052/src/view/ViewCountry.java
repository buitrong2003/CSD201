/*
 * Copyright(C) Bui Duc Trong
 * J1.S.P0052
 * Manage Geographic
 */
package view;

import controller.ManageEastAsiaCountries;
import java.util.ArrayList;
import model.EastAsiaCountries;
import validation.Validation;

/**
 *
 * @author Bui Duc Trong
 */
public class ViewCountry {

    ManageEastAsiaCountries manage = new ManageEastAsiaCountries();

    /**
     * This function input the information of 11 country in east Asia and check
     * name and code duplicate after create object and add in listCountry
     */
    void inputCountry() {
        System.out.println("-------- Input the information of 11 countries in East Asia --------");
        // if size of listCountry equal 11 be not input
        if (manage.listCountry.size() == 11) {
            System.out.println("Country enough.");
        } // else enter and add in listCountry
        else {
            String countryCode;
            while (true) {
                // input country 
                countryCode = Validation.getString("Enter code of country:",
                        "[a-zA-Z0-9 ]+", "Code of Country must be String.");
                // check duplicate code Country
                if (manage.isCodeOfCountryDuplicate(countryCode)) {
                    System.out.println("Code of Country not duplicate.");
                } else {
                    break;
                }
            }
            String countryName;
            // input name
            while (true) {
                countryName = Validation.getString("Enter name of country:",
                        "[a-zA-Z0-9 ]+", "Code of Country must be String.");
                // check duplicate name Country
                if (manage.isNameOfCountryDuplicate(countryName)) {
                    System.out.println("name of Country not duplicate.");
                } else {
                    break;
                }
            }
            // input total Area
            float totalArea = Validation.getFloat("Enter total Area:", 1,
                    Float.MAX_VALUE, "Number must be number Float.");
            // input terrain of country
            String countryTerrain = Validation.getString("Enter terrain of country:",
                    "[a-zA-Z0-9 ]+", "Terrain of country must be String.");
            // Create object
            EastAsiaCountries eastAsiaCountries = new EastAsiaCountries(countryCode,
                    countryName, totalArea, countryTerrain);
            // add in listCountry
            manage.listCountry.add(eastAsiaCountries);
            System.out.println("Add country successfully.");
        }
    }

    /**
     * This function will display information just input if listCountry Empty be
     * will display List Country Empty if no it will display information just
     * input
     */
    void displayInformationofCountryJustInput() {
        System.out.println("-------- Display the information of country you've just input --------");
        // check listCountry Empty
        if (manage.listCountry.isEmpty()) {
            System.out.println("List Country Empty.");
        } else {
            System.out.printf("%-10s %-15s %-15s%-11s%n", "ID", "Name", "Total Area", "Terrain");
            // get last index in listCountry 
            int lastIndex = manage.listCountry.size() - 1;
            // get country in index last
            EastAsiaCountries eastAsiaCountries = manage.listCountry.get(lastIndex);
            // display
            eastAsiaCountries.display();
        }
    }

    /**
     * This function will check listCountry Empty if not Empty be will enter
     * name need search and transmisson in function to check in listCountry
     * element contain countryName be add listCountryByName after will return
     * and assign
     *
     *
     */
    void searchCountriesByName() {
        System.out.println("-------- Search the information of country by user-entered name --------");
        // check listCountry Empty
        if (manage.listCountry.isEmpty()) {
            System.out.println("List Country Empty.");
        } else {
            // enter name need seatch
            String countryName = Validation.getString("Enter the name you want to search for:",
                    "[a-zA-Z0-9 ]+", "Code of Country must be String.");
            // search country by name 
            ArrayList<EastAsiaCountries> listCountryByName = manage.getListCountryByName(countryName);
            // check listCountryByName Empty to not found
            if (listCountryByName.isEmpty()) {
                System.out.println("Not found.");
            } else {
                System.out.printf("%-10s %-15s %-15s%-11s%n", "ID", "Name", "Total Area", "Terrain");
                // display each element in listCountryByName
                for (EastAsiaCountries eastAsiaCountries : listCountryByName) {
                    eastAsiaCountries.display();
                }
            }
        }
    }

    void sortCountryByName() {
        System.out.println("-------- Display the information of countries sorted name in ascending order --------");
        // check listCountry Empty
        if (manage.listCountry.isEmpty()) {
            System.out.println("List Country Empty.");
        } else {
            ArrayList<EastAsiaCountries> sortList = new ArrayList<>();
            // add all element to listCountry in sortList
            sortList.addAll(manage.listCountry);
            // sort all element by name
            manage.sortCountry(sortList);
            // display
            System.out.printf("%-10s %-15s %-15s%-11s%n", "ID", "Name", "Total Area", "Terrain");
            for (EastAsiaCountries eastAsiaCountries : sortList) {
                eastAsiaCountries.display();
            }
        }
    }
}
