/*
 * Copyright(C) Bui Duc Trong
 * J1.S.P0052
 * Manage Geographic
 */
package controller;

import model.EastAsiaCountries;
import java.util.ArrayList;

/**
 *
 * @author Bui Duc Trong
 */
public class ManageEastAsiaCountries {

    public ArrayList<EastAsiaCountries> listCountry;

    public ManageEastAsiaCountries() {
        listCountry = new ArrayList<>();
    }

    /**
     * This function will check code if code equal code of object in listContry
     * and duplicate return true else return false
     *
     * @param countryCode
     * @return
     */
    public boolean isCodeOfCountryDuplicate(String countryCode) {
        // The loop for each element in countryList
        for (EastAsiaCountries eastAsiaCountries : listCountry) {
            // check element's have code equal code 
            if (countryCode.equalsIgnoreCase(eastAsiaCountries.getCountryCode())) {
                // duplicate
                return true;
            }
        }
        return false;
    }

    /**
     * This function will check name if code equal name of object in listContry
     * and duplicate return true else return false
     *
     * @param countryName
     * @return
     */
    public boolean isNameOfCountryDuplicate(String countryName) {
        // The loop for each element in countryList
        for (EastAsiaCountries eastAsiaCountries : listCountry) {
            // check element's have code equal code 
            if (countryName.equalsIgnoreCase(eastAsiaCountries.getCountryName())) {
                // duplicate
                return true;
            }
        }
        return false;
    }

    public ArrayList<EastAsiaCountries> getListCountryByName(String countryName) {
        // create an empty list to store EastAsiaCountries object whose names 
        // contain country name
        ArrayList<EastAsiaCountries> listCountryByName = new ArrayList<>();
        // The loop for each element in countryList
        for (EastAsiaCountries eastAsiaCountries : listCountry) {
            // if element's contain countryname be add listCountryByName
            if (eastAsiaCountries.getCountryName().toUpperCase().contains(
                    countryName.toUpperCase())) {
                // add listCountryByName
                listCountryByName.add(eastAsiaCountries);
            }
        }
        return listCountryByName;
    }

    public void sortCountry(ArrayList<EastAsiaCountries> sortList) {
        // the loop will loop element last to head element
        for (int i = sortList.size() - 1; i > 0; i--) {
            // the loop will loop head element to element last 
            for (int j = 0; j < i; j++) {
                // check and swap
                if (sortList.get(j).getCountryName().compareToIgnoreCase(
                        sortList.get(j + 1).getCountryName()) > 0) {
                    EastAsiaCountries temp = sortList.get(j);
                    sortList.set(j, sortList.get(j + 1));
                    sortList.set(j + 1, temp);
                }
            }
        }
    }
}
