package se.iths.java24.repository;

import se.iths.java24.methods.*;

import java.util.Scanner;

public class CRUDMethod {

    public static void crudMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCRUD Menu:");
            System.out.println("0. Back to CRUD Menu");
            System.out.println("1. Continent CRUD");
            System.out.println("2. Country   CRUD");
            System.out.println("3. City      CRUD");
            System.out.println("4. Currency  CRUD");
            System.out.println("5. Language  CRUD");
            System.out.print("Choose an option: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Konsumera newline
                switch (choice) {
                    case 0:
                        return; // Tillbaka till huvudmenyn
                    case 1:
                        ContinentMethod.continentMenu();
                        break;
                    case 2:
                        CountryMethod.countryMenu();
                        break;
                    case 3:
                        CityMethod.cityMenu();
                        break;
                    case 4:
                        CurrencyMethod.currencyMenu();
                        break;
                    case 5:
                        LanguageMethod.languageMenu();
                        break;
                    default:
                        System.out.println("Ogiltigt val, försök igen.");
                }
            } else {
                System.out.println("Ogiltig inmatning! Ange ett nummer.");
                scanner.next(); // Rensa felaktig inmatning
            }
        }
    }
}
