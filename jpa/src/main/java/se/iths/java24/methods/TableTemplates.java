package se.iths.java24.methods;

import se.iths.java24.entity.City;

import java.util.List;

public class TableTemplates {

    static void printTableCityPopulation(List<City> cities) {
        if (cities == null || cities.isEmpty()) {
            System.out.println("No cities to display.");
            return;
        }

        // Print the table header
        System.out.printf("%-5s | %-20s | %-10s%n", "ID", "City Name", "Population");
        System.out.println("------------------------------------------------");

        // Print each city in a formatted row
        for (City city : cities) {
            System.out.printf("%-5d | %-20s | %-10d%n", city.getId(), city.getCityName(), city.getPopulation());
        }
    }


}
