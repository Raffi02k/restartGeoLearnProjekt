package se.iths.java24.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import se.iths.java24.JPAUtil;
import se.iths.java24.entity.Continent;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static se.iths.java24.JPAUtil.getEntityManager;
import static se.iths.java24.JPAUtil.inTransaction;

public class ContinentRepository {

    EntityManager em = getEntityManager();
    Continent continent = new Continent();

    public Optional<Continent> continentWithName(String countryName) {
        EntityManager em = getEntityManager();
        try {
            return Optional.of(em.createQuery("select c from Continent c where c.continentName = :continentName", Continent.class)
                    .setParameter("continentName", countryName)
                    .getSingleResult());
        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }

    public static void CreateContinent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter continent name:");
        String name = scanner.nextLine();
        System.out.println("Enter continent code:");
        String code = scanner.nextLine();

        Continent continent = new Continent();
        continent.setContinentName(name);
        continent.setContinentCode(code);

        inTransaction(em -> {
            em.persist(continent);
        });

        System.out.println("Continent created successfully.");
    }

    public static void UpdateContinent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the continent code of the continent you want to update:");
        String code = scanner.nextLine();
        System.out.println("Enter the new name for the continent:");
        String newName = scanner.nextLine();

        inTransaction(entityManager -> {
            Continent continent = entityManager.find(Continent.class, code);
            if (continent != null) {
                continent.setContinentName(newName);
                System.out.println("Continent updated successfully.");
            } else {
                System.out.println("Continent not found.");
            }
        });
    }
    public static void showContinents() {
        EntityManager em = getEntityManager();
        try {
            // Läs alla kontinenter
            String queryStr = "SELECT c FROM Continent c";
            TypedQuery<Continent> query = em.createQuery(queryStr, Continent.class);
            List<Continent> continents = query.getResultList();

            // Skriv ut kontinenter
            if (continents.isEmpty()) {
                System.out.println("Inga kontinenter hittades.");
            } else {
                continents.forEach(System.out::println);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Stäng EntityManager
            em.close();
        }

    }

    public static void DeleteContinent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the continent code of the continent you want to delete:");
        String code = scanner.nextLine();

        inTransaction(entityManager -> {
            Continent continent = entityManager.find(Continent.class, code);
            if (continent != null) {
                entityManager.remove(continent);
                System.out.println("Continent deleted successfully.");
            } else {
                System.out.println("Continent not found.");
            }
        });
    }
}

