package se.iths.java24.methods;

import se.iths.java24.repository.CountryRepository;

import java.util.Scanner;

public class CountryMethod {

    public static void countryMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nCountry Menu:");
        System.out.println("1. Show Countries");
        System.out.println("2. Create a Country");
        System.out.println("3. Update a Country");
        System.out.println("4. Delete a Country");
        System.out.println("5. Back to CRUD Menu");
        System.out.print("Choose an option: ");

        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    CountryRepository.showCountries();
                    countryMenu();
                    break;
                case 2:
                    CountryRepository.createCountry();
                    break;
                case 3:
                    CountryRepository.updateCountry();
                    break;
                case 4:
                    CountryRepository.deleteCountry();
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
}
