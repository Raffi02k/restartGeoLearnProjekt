package se.iths.java24.methods;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import se.iths.java24.entity.City;

import java.sql.*;
import java.util.List;
import java.util.Scanner;


public class StatisticMethod {

    private static Scanner scanner = new Scanner(System.in);


    public static void statistik() {
        System.out.println("""
            Statistik Menu:
            1. Show all cities.
            2. Show top 3 cities by population
            3. Population over 300000
        """);


        System.out.print("Choose an option: ");

        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    showAllCities();
                    break;

                case 2:
                    showTopThreeCitiesByPopulation();
                    break;

                case 3:
                    showCitiesWithPopulationOver(300000);
                    break;

                default:
                    System.out.println("Invalid choice. Returning to the main menu.");

            }
        } else {
            System.out.println("Invalid input. Returning to the main menu.");
        }
    }

    private static void printTableCityPopulation(List<City> cities) {
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



    // Create a method to fetch all cities
    public static void showAllCities() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate-mysql"); // Replace with your persistence unit name
        EntityManager em = emf.createEntityManager();

        try {
            // Query to fetch all cities
            List<City> cities = em.createQuery("SELECT c FROM City c", City.class).getResultList();

            // print the header
            System.out.println("\nList of all cities:\n");
            printTableCityPopulation(cities);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error fetching cities.");
        } finally {
            em.close();
            emf.close();
        }
    }


    // Create a method to fetch all cities
    public static void showTopThreeCitiesByPopulation() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate-mysql"); // Replace with your persistence unit name
        EntityManager em = emf.createEntityManager();

        try {
            // Query to fetch three biggest cities
            List<City> cities = em.createQuery("SELECT c FROM City c ORDER BY c.population DESC", City.class).setMaxResults(3).getResultList();


            // print the header
            System.out.println("\nList of the three biggest cities:\n");
            printTableCityPopulation(cities);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error fetching cities.");
        } finally {
            em.close();
            emf.close();
        }
    }


    public static void showCitiesWithPopulationOver(int populationThreshold) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
        EntityManager em = emf.createEntityManager();

        try {
            // Query to fetch cities with population over the threshold
            List<City> cities = em.createQuery("SELECT c FROM City c WHERE c.population > :population", City.class)
                    .setParameter("population", populationThreshold)
                    .getResultList();

            System.out.println("\nCities with population over " + populationThreshold + ":\n");
            printTableCityPopulation(cities);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error fetching cities with population over " + populationThreshold + ".");
        } finally {
            em.close();
            emf.close();
        }
    }




}