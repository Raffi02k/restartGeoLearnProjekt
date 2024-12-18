package se.iths.java24.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import se.iths.java24.JPAUtil;
import se.iths.java24.entity.Country;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static se.iths.java24.JPAUtil.inTransaction;

public class CountryRepository {

    // Retrieve a country by its name
    public Optional<Country> countryWithName(String countryName) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return Optional.of(em.createQuery("select c from Country c where c.countryName = :countryName", Country.class)
                    .setParameter("countryName", countryName)
                    .getSingleResult());
        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }

    // Create a new country
    public static void createCountry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter country code:");
        String code = scanner.nextLine();
        System.out.println("Enter country name:");
        String name = scanner.nextLine();

        Country country = new Country();
        country.setCountryCode(code);
        country.setCountryName(name);

        inTransaction(em -> em.persist(country));

        System.out.println("Country created successfully.");
    }

    // Update an existing country
    public static void updateCountry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the country code of the country you want to update:");
        String code = scanner.nextLine();
        System.out.println("Enter the new name for the country:");
        String newName = scanner.nextLine();

        inTransaction(em -> {
            Country country = em.find(Country.class, code);
            if (country != null) {
                country.setCountryName(newName);
                System.out.println("Country updated successfully.");
            } else {
                System.out.println("Country not found.");
            }
        });
    }

    // Delete a country
    public static void deleteCountry() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the country code of the country you want to delete:");
        String code = scanner.nextLine();

        inTransaction(em -> {
            Country country = em.find(Country.class, code);
            if (country != null) {
                em.remove(country);
                System.out.println("Country deleted successfully.");
            } else {
                System.out.println("Country not found.");
            }
        });
    }

    // Show all countries
    public static void showCountries() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            String queryStr = "SELECT c FROM Country c";
            TypedQuery<Country> query = em.createQuery(queryStr, Country.class);
            List<Country> countries = query.getResultList();

            if (countries.isEmpty()) {
                System.out.println("No countries found.");
            } else {
                countries.forEach(System.out::println);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
