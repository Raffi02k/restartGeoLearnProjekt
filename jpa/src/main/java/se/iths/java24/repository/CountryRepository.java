package se.iths.java24.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import se.iths.java24.JPAUtil;
import se.iths.java24.entity.Continent;
import se.iths.java24.entity.Country;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static se.iths.java24.JPAUtil.getEntityManager;
import static se.iths.java24.JPAUtil.inTransaction;

public class CountryRepository {

    // Retrieve a country by its name
    public Optional<Country> countryWithName(String countryName) {
        EntityManager em = getEntityManager();
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
        EntityManager em = getEntityManager();
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

    public static List<Country> findAllCountriesByContinent(String continentCode) {
        EntityManager em = getEntityManager();
        List<Country> countries = null;
        try {
            String queryStr = "SELECT c FROM Country c WHERE c.continent.continentCode = :continentCode";
            TypedQuery<Country> query = em.createQuery(queryStr, Country.class);
            query.setParameter("continentCode", continentCode);
            countries = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return countries;
    }

    public static Country findCountryByNameOrCode(String input) {
        EntityManager em = getEntityManager();
        Country country = null;
        try {
            TypedQuery<Country> queryByCode = em.createQuery("SELECT c FROM Country c WHERE c.countryCode = :input", Country.class);
            queryByCode.setParameter("input", input);
            country = queryByCode.getResultStream().findFirst().orElse(null);

            if (country == null) {
                TypedQuery<Country> queryByName = em.createQuery("SELECT c FROM Country c WHERE c.countryName = :input", Country.class);
                queryByName.setParameter("input", input);
                country = queryByName.getResultStream().findFirst().orElse(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return country;
    }

    public static Country findCountryByCode(String countryCode) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Country c WHERE c.countryCode = :countryCode", Country.class)
                    .setParameter("countryCode", countryCode)
                    .getSingleResult();
        } catch (RuntimeException e) {
            return null;
        }
    }

    public static Country findCountryByName(String countryName) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Country c WHERE c.countryName = :countryName", Country.class)
                    .setParameter("countryName", countryName)
                    .getSingleResult();
        } catch (RuntimeException e) {
            return null;
        }
    }

    public static List<Country> findCountryByContinent(Continent continent) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c WHERE c.continent = :continent", Country.class);
            query.setParameter("continent", continent);
            return query.getResultList();
        } catch (RuntimeException e) {
            return null;
        }
    }
}
