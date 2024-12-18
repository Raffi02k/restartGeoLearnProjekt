package se.iths.java24;

import se.iths.java24.repository.ContinentRepository;
import java.util.Scanner;

import static se.iths.java24.repository.ContinentRepository.*;

public class Main {

    public static void main(String[] args) {
        boolean quite = false;
        Scanner scanner = new Scanner(System.in); // Glöm inte att skapa en scanner-instans

        printAction();

        while (!quite) {
            System.out.print("Ange ditt val (1-5): ");

            // Kontrollera om inmatningen är en siffra
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Konsumera newline-karaktären
                switch (choice) {
                    case 1:
                        continentMenu();
                        break;
                    case 2:
                        population();
                        break;
                    case 3:
                        statistik();
                        break;
                    case 4:
                        Quiz();
                        break;
                    case 5:
                        quite = true;
                        System.out.println("Avslutar programmet. Tack!");
                        break;
                    default:
                        System.out.println("Ogiltigt val, försök igen. Välj ett nummer mellan 1 och 6.");
                        printAction();
                }
            } else {
                System.out.println("Ogiltig inmatning! Ange ett nummer mellan 1 och 6.");
                scanner.next(); // Rensar felaktig inmatning
            }
        }

        scanner.close(); // Glöm inte att stänga scannern
    }

    public static void continentMenu() {
        Scanner scanner = new Scanner(System.in);
        ContinentRepository repository = new ContinentRepository();

        System.out.println("\nContinent Menu:");
        System.out.println("1. Show Continents");
        System.out.println("2. Create a Continent");
        System.out.println("3. Update a Continent");
        System.out.println("4. Delete a Continent");
        System.out.println("5. Back to Main Menu");
        System.out.print("Choose an option: ");

        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Konsumera newline-karaktären

            switch (choice) {
                case 1:
                    showContinents();
                    continentMenu();
                    break;
                case 2:
                    CreateContinent();
                    break;
                case 3:
                    UpdateContinent();
                    break;
                case 4:
                    DeleteContinent();
                    break;
                case 5:
                    System.out.println("Returning to Main Menu...");
                    printAction();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } else {
            System.out.println("Invalid input, please enter a number.");
            scanner.next();
        }
    }

    public static void countriesEurope() {
        System.out.println("Visar länder i Europa...");
        // Lägg till relevant logik här
    }

    public static void population() {
        System.out.println("Visar befolkningsdata...");
        // Lägg till relevant logik här
    }

    public static void statistik() {
        System.out.println("Visar statistik...");
        // Lägg till relevant logik här
    }

    public static void Quiz() {
        System.out.println("Startar quiz...");
        // Lägg till relevant logik här
    }

    public static void printAction() {
        System.out.println("""
                
                Welcome to Geo Learn Projekt!
                Välj:
                1.  - Continent.
                2.  - Population.
                3.  - Statistik.
                4.  - Quiz!
                5.  - Quit.
                """);
    }
}

//        //Ask user for information
//        System.out.println("Add city to country");
//        cities.addCityToCountry("Kalmar", 60000, "Sweden");
//
//        System.out.print("Enter search term: ");
//        Scanner scanner = new Scanner(System.in);
////
////        // Validate user input
////        if (name == null || name.isEmpty()) {
////            System.out.println("Invalid input.");
////            return;
////        }
////


//        //Create new country
//        Country country = new Country();
//        country.setCountryName("Poland");
//        country.setCountryCode("pl");

//        //Create new city
//        Country country = new Country();
//        country.setCountryName("Poland");
//        country.setCountryCode("pl");
//
////        var transaction = em.getTransaction();
////        transaction.begin();
////        em.persist(country);
////        transaction.commit();
////        em.close();
//
//        //Create
//        try {
//            inTransaction(entityManager -> {
//                entityManager.persist(country);
//            });
//        } catch (Exception e) {
//
//        }
//

//


//        inTransaction(entityManager -> {
//            var country1 = entityManager.find(Country.class, "se");
//            System.out.println(country1.getThreeLetterName());
//        });
//
//        //Use JOIN FETCH to prevent N + 1 problem
//        inTransaction(entityManager -> {
//            var c = entityManager.createQuery("SELECT c FROM Country c JOIN FETCH c.cities", Country.class)
//                    .getResultList();
//            c.forEach(System.out::println);
//        });
//
//        //Named entity graph to prevent N + 1 problem, defined in Entity class
//        inTransaction(entityManager -> {
//            var eg = entityManager.getEntityGraph("Country.cities");
//
//            var c = entityManager.createQuery("SELECT c FROM Country c", Country.class)
//                    .setHint("jakarta.persistence.fetchgraph", eg)
//                    .getResultList();
//            c.forEach(System.out::println);
//        });
//
//        //Create entity graph using code.
//        inTransaction(entityManager -> {
//            var eg = entityManager.createEntityGraph(Country.class);
//            eg.addAttributeNodes("cities");
//
//            var c = entityManager.createQuery("SELECT c FROM Country c", Country.class)
//                    .setHint("jakarta.persistence.fetchgraph", eg)
//                    .getResultList();
//            c.forEach(System.out::println);
//        });
//
//        //Only retrieve what we need
//        inTransaction(entityManager -> {
//            var c = entityManager.createQuery("SELECT c.countryName FROM Country c", String.class)
//                    .getResultList();
//            c.forEach(System.out::println);
//        });
//
//        //Convert selected Entity to dto object
//        inTransaction(entityManager -> {
//            var c = entityManager.createQuery("SELECT c FROM Country c", Country.class)
//                    .getResultList();
//            c.stream().map(country1 ->
//                            new CountryCodeAndName(country1.getCountryCode(),
//                                    country1.getCountryName()))
//                    .forEach(System.out::println);
//        });
//
//        //Select information into dto directly, Projection
//        inTransaction(entityManager -> {
//            var c = entityManager.createQuery("SELECT new se.iths.java24.CountryCodeAndName(c.countryCode, c.countryName)" +
//                                              " FROM Country c", CountryCodeAndName.class)
//                    .getResultList();
//            c.forEach(System.out::println);
//        });
//
//        //Native query, gives us access to full sql
////        inTransaction(entityManager -> {
////            var c = entityManager.createNativeQuery("delete from country where country_code='tt'")
////                    .executeUpdate();
////        });

