package se.iths.java24.methods;

import se.iths.java24.entity.City;
import se.iths.java24.entity.Country;
import se.iths.java24.repository.CityRepository;

import java.util.List;

import java.util.Scanner;

public class CityMethod {

    public static void cityMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCity Menu:");
        System.out.println("1. Show Cities");
        System.out.println("2. Create a City");
        System.out.println("3. Update a City");
        System.out.println("4. Delete a City");
        System.out.println("5. Back to CRUD Menu");
        System.out.print("Choose an option: ");

        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    CityRepository.showCities();
                    cityMenu();
                    break;
                case 2:
                    CityRepository.createCity();
                    break;
                case 3:
                    CityRepository.updateCity();
                    break;
                case 4:
                    CityRepository.deleteCity();
                    break;
                case 5:
                    return; // Tillbaka till CRUD-menyn
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } else {
            System.out.println("Invalid input, please enter a number.");
            scanner.next();
        }
    }

    public static List<City> getCitiesByCountry(Country country) {
        return CityRepository.findCitiesByCountry(country);
    }
}
