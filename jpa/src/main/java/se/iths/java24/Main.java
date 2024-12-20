package se.iths.java24;

import se.iths.java24.entity.*;
import se.iths.java24.methods.ContinentMethod;
import se.iths.java24.methods.CountryMethod;
import se.iths.java24.methods.CityMethod;
import se.iths.java24.repository.CountryRepository;
import se.iths.java24.repository.CurrencyRepository;
import se.iths.java24.repository.LanguageRepository;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);

        printAction();

        while (!quit) {
            System.out.print("Make a selection using numbers: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        selectContinent(scanner);
                        break;
                    case 2:
                        populationMenu(scanner);
                        break;
                    case 3:
                        statisticsMenu(scanner);
                        break;
                    case 4:
                        quizMenu(scanner);
                        break;
                    case 5:
                        quit = true;
                        System.out.println("Exiting Geo Learn Projekt... Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid input. Please try again.");
                        printAction();
                }
            } else {
                System.out.println("Invalid input. Please try again.");
                scanner.next();
            }
        }

        scanner.close();
    }

    public static void printAction() {
        System.out.println("""
                Welcome to Geo Learn Projekt!
                
                Main menu:
                1.  - Continents
                2.  - Population
                3.  - Statistics
                4.  - Quiz!
                5.  - Quit
                """);
    }

    // Ny funktion för att välja en kontinent och sedan gå till countryMenu
    public static void selectContinent(Scanner scanner) {
        List<Continent> continents = ContinentMethod.getAllContinents();

        if (continents.isEmpty()) {
            System.out.println("No continents found.");
            return;
        }

        System.out.println("Select a continent by entering its number:");
        for (int i = 0; i < continents.size(); i++) {
            System.out.println((i + 1) + ". " + continents.get(i).getContinentName());
        }

        if (scanner.hasNextInt()) {
            int index = scanner.nextInt() - 1;
            scanner.nextLine();

            if (index >= 0 && index < continents.size()) {
                Continent selectedContinent = continents.get(index);
                System.out.println("Selected continent: " + selectedContinent.getContinentName());
                selectCountry(scanner, selectedContinent);  // Går till countryMenu för den valda kontinenten
            } else {
                System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Invalid input.");
            scanner.next();  // Rensar felaktig inmatning
        }
    }

    // Ny funktion för att välja ett land och sedan gå till cityMenu
    public static void selectCountry(Scanner scanner, Continent selectedContinent) {
        List<Country> countries = CountryMethod.getAllCountriesByContinent(selectedContinent);

        if (countries.isEmpty()) {
            System.out.println("No countries found for " + selectedContinent.getContinentName());
            return;
        }

        System.out.println("Select a country by entering its number:");
        for (int i = 0; i < countries.size(); i++) {
            System.out.println((i + 1) + ". " + countries.get(i).getCountryName());
        }

        if (scanner.hasNextInt()) {
            int index = scanner.nextInt() - 1;
            scanner.nextLine();

            if (index >= 0 && index < countries.size()) {
                Country selectedCountry = countries.get(index);
                System.out.println("Selected country: " + selectedCountry.getCountryName());
                cityMenu(scanner, selectedCountry);
            } else {
                System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Invalid input.");
            scanner.next();
        }
    }

    // Ny metod för att visa en stadsmenu baserat på valt land
    public static void cityMenu(Scanner scanner, Country selectedCountry) {
        List<String> cities = CityMethod.getCitiesByCountry(selectedCountry).stream()
                .map(City::getCityName)
                .toList();

        if (cities.isEmpty()) {
            System.out.println("No cities found for " + selectedCountry.getCountryName());
            return;
        }

        System.out.println("Cities in " + selectedCountry.getCountryName() + ":");
        for (String city : cities) {
            System.out.println("- " + city);
        }
    }

    public static void searchCountryByNameOrCode(Scanner scanner) {
        System.out.print("Enter the country name or code: ");
        String input = scanner.nextLine().toLowerCase();

        Country country = CountryRepository.findCountryByCode(input);

        if (country == null) {
            country = CountryRepository.findCountryByName(input);
        }

        if (country == null) {
            System.out.println("No country found for input: " + input);
            return;
        }

        System.out.println("\nCountry: " + country.getCountryName());
        System.out.println("Country Code: " + country.getCountryCode());

        Language language = LanguageRepository.findLanguageByCountryCode(country.getCountryCode());
        if (language != null) {
            System.out.println("Official Language: " + language.getLanguageName());
        } else {
            System.out.println("No official language found for country: " + country.getCountryName());
        }

        Currency currency = CurrencyRepository.findCurrencyByCountryCode(country.getCountryCode());
        if (currency != null) {
            System.out.println("Currency: " + currency.getCurrencyName());
            System.out.println("Currency Code: " + currency.getCurrencyCode());
        } else {
            System.out.println("No currency found for country: " + country.getCountryName());
        }
    }

    public static void populationMenu(Scanner scanner) {
        System.out.println("Population Menu. Implement this.");
    }

    public static void statisticsMenu(Scanner scanner) {
        System.out.println("Statistics Menu. Implement this.");
    }

    public static void quizMenu(Scanner scanner) {
        System.out.println("Quiz Menu. Implement this.");
    }
}
