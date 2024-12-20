package se.iths.java24.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import se.iths.java24.JPAUtil;
import se.iths.java24.entity.City;
import se.iths.java24.entity.Country;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static se.iths.java24.JPAUtil.getEntityManager;
import static se.iths.java24.JPAUtil.inTransaction;

public class CityRepository {

    // Save a city to the database
    public void saveCity(City city) {
        inTransaction(em -> em.persist(city));
    }

    // Retrieve all cities with a population greater than a specified minimum
    public List<City> allCitiesWithMoreThan(int minpopulation) {
        return JPAUtil.getEntityManager()
                .createQuery("select c from City c where c.population > :minpopulation", City.class)
                .setParameter("minpopulation", minpopulation)
                .getResultList();
    }

    // Get a city by its ID
    public Optional<City> cityWithId(Long cityId) {
        EntityManager em = getEntityManager();
        try {
            return Optional.of(em.createQuery("select c from City c where c.id = :cityId", City.class)
                    .setParameter("cityId", cityId)
                    .getSingleResult());
        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }

    // Create a new city in the database
    public static void createCity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter city name:");
        String name = scanner.nextLine();
        System.out.println("Enter population:");
        int population = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter country code:");
        String countryCode = scanner.nextLine();

        City city = new City();
        city.setCityName(name);
        city.setPopulation(population);
        Country country = JPAUtil.getEntityManager().find(Country.class, countryCode);
        city.setCountry(country);

        inTransaction(em -> em.persist(city));

        System.out.println("City created successfully.");
    }

    // Update an existing city's details
    public static void updateCity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the city ID of the city you want to update:");
        Long cityId = Long.parseLong(scanner.nextLine());
        System.out.println("Enter the new name for the city:");
        String newName = scanner.nextLine();

        inTransaction(em -> {
            City city = em.find(City.class, cityId);
            if (city != null) {
                city.setCityName(newName);
                System.out.println("City updated successfully.");
            } else {
                System.out.println("City not found.");
            }
        });
    }

    // Delete a city by ID
    public static void deleteCity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the city ID of the city you want to delete:");
        Long cityId = Long.parseLong(scanner.nextLine());

        inTransaction(em -> {
            City city = em.find(City.class, cityId);
            if (city != null) {
                em.remove(city);
                System.out.println("City deleted successfully.");
            } else {
                System.out.println("City not found.");
            }
        });
    }

    // Show all cities
    public static void showCities() {
        EntityManager em = getEntityManager();
        try {
            String queryStr = "SELECT c FROM City c";
            TypedQuery<City> query = em.createQuery(queryStr, City.class);
            List<City> cities = query.getResultList();

            if (cities.isEmpty()) {
                System.out.println("No cities found.");
            } else {
                cities.forEach(System.out::println);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static List<City> findCitiesByCountryCode(String countryCode) {
        EntityManager em = JPAUtil.getEntityManager();
        List<City> cities = null;
        try {
            String queryStr = "SELECT c FROM City c WHERE c.country.countryCode = :countryCode";
            TypedQuery<City> query = em.createQuery(queryStr, City.class);
            query.setParameter("countryCode", countryCode);
            cities = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return cities;
    }

    public static List<City> findCitiesByCountry(Country country) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Skapa en fråga för att hämta alla städer som tillhör ett specifikt land
            TypedQuery<City> query = em.createQuery("SELECT c FROM City c WHERE c.country = :country", City.class);
            query.setParameter("country", country);
            return query.getResultList();  // Returnera listan med städer
        } catch (RuntimeException e) {
            return null;  // Om ingen stad hittas, returnera null
        }
    }
}
