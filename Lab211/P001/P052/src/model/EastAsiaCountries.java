/*
 * Copyright(C) Bui Duc Trong
 * J1.S.P0052
 * Manage Geographic
 */
package model;

/**
 *
 * @author Bui Duc Trong
 */
public class EastAsiaCountries extends Country {

    private String countryTerrain;

    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("%-10s\n", countryTerrain);
    }
}
